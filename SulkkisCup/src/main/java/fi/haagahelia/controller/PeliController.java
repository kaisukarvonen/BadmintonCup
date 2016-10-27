package fi.haagahelia.controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.inject.Inject;

import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import fi.haagahelia.bean.Pelaaja;
import fi.haagahelia.bean.Peli;
import fi.haagahelia.dao.PelaajaDao;
import fi.haagahelia.dao.PeliDao;

@Controller
@RequestMapping(value = "*")
public class PeliController {

	@Inject
	private PelaajaDao pelaajaDao;

	@Inject
	private PeliDao peliDao;

	@RequestMapping(value = "/main", method = RequestMethod.GET)
	public String mainPage(Model model) {
		return "redirect:/pistetilasto";
	}

	@RequestMapping(value = "pistetilasto", method = RequestMethod.GET)
	public String pisteTilasto(Model model) {
		List<Pelaaja> pelaajat = pelaajaDao.pelaajaListByPoints();
		Collections.sort(pelaajat);
		model.addAttribute("pelaajat", pelaajat);
		return "secure/main";
	}

	@RequestMapping(value = "pelit", method = RequestMethod.GET)
	public String pelit(Model model) {
		List<Peli> pelit = peliDao.peliList();
		Collections.sort(pelit);
		model.addAttribute("pelit", pelit);
		
		initPelaajaNimiList(model); 
		model.addAttribute("peli", new Peli());
		return "secure/pelit";
	}
	
	@RequestMapping(value = "pelit", method = RequestMethod.POST)
	public String addVoittajaForPeli(@ModelAttribute("peli") Peli p) {
		try {
			peliDao.addVoittaja(p);
		} catch(Exception e) {
			System.out.println("ep‰onnistui");
		}
		return "redirect:/pelit";
	}
	

	public void initPelaajaNimiList(Model model) {
		List<Pelaaja> pelaajat = pelaajaDao.pelaajaListByPoints();
		List<String> pelaajaNimet = new ArrayList<String>();
		for (Pelaaja pelaaja : pelaajat) {
			pelaajaNimet.add(pelaaja.getNimi());
		}
		model.addAttribute("pelaajat", pelaajaNimet);
	}

	@RequestMapping(value = "lisaaPeli", method = RequestMethod.GET)
	public String initLisaaPeliForm(Model model) {
		initPelaajaNimiList(model);
		model.addAttribute("peli", new Peli());
		return "secure/admin/lisaa-peli";
	}

	@RequestMapping(value = "lisaaPeli", method = RequestMethod.POST)
	public String addPeliFromForm(@ModelAttribute Peli p, Model model, RedirectAttributes ra) {
		if (p.getPelaaja1().isEmpty() || p.getPelaaja2().isEmpty() || p.getPvm().isEmpty()) {
			ra.addFlashAttribute("message", "T‰yt‰ kaikki kent‰t!");
		} else if (p.getPelaaja1().equals(p.getPelaaja2())) {
			ra.addFlashAttribute("message", "Pelaaja ei voi pelata itse‰‰n vastaan!");
		} else {
			if (!peliIsAlreadyAdded(p)) {
			peliDao.addPeli(p);
			ra.addFlashAttribute("message", "Peli lis‰tty!");
			} else {
				ra.addFlashAttribute("message", "Olet jo lis‰nnyt t‰m‰n pelin!");
			}
		}
		return "redirect:/lisaaPeli";
	}

	public boolean peliIsAlreadyAdded(Peli p) {
		List<Peli> pelit = peliDao.peliList();
		for (Peli peli : pelit) {
			if (p.getPvm().equals(peli.getPvm())) {
				if ((p.getPelaaja1().equals(peli.getPelaaja1()) && p.getPelaaja2().equals(peli.getPelaaja2())) || 
						(p.getPelaaja1().equals(peli.getPelaaja2()) && p.getPelaaja2().equals(peli.getPelaaja1()))) {
					return true;
				}
			}
		}
		return false;
	}

}
