package fi.haagahelia.controller;

import javax.inject.Inject;
import javax.validation.Valid;

import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import fi.haagahelia.bean.Pelaaja;
import fi.haagahelia.dao.PelaajaDao;

@Controller
@RequestMapping(value="register")
public class RegisterController {
	
	@Inject
	private PelaajaDao pDao;
	
	@RequestMapping(method=RequestMethod.GET)
	public String initRegisterForm(Model model) {
		model.addAttribute("pelaaja", new Pelaaja());
		return "register-page";
	}

	@RequestMapping(method=RequestMethod.POST)
	public String addPelaajaFromForm( @ModelAttribute(value="pelaaja") @Valid Pelaaja p, BindingResult result, Model model) {
		if (result.hasErrors()) {
			return "register-page";
		} else {
			try {
			pDao.addPelaaja(p);
			} catch(DuplicateKeyException e) {
				model.addAttribute("errormessage", "Käyttäjätunnus on jo varattu, valitse toinen!");
				return "register-page";
			}
			return "/login-page";
		}
	}
}
