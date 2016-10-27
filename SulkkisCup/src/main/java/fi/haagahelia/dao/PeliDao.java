package fi.haagahelia.dao;

import java.util.Collections;
import java.util.List;

import javax.inject.Inject;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import fi.haagahelia.bean.Peli;

@Repository
public class PeliDao {
	
	@Inject
	private JdbcTemplate jdbcTemplate;

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}
	
	public void addPeli(Peli p) {
		String insertSQL = "insert into peli (pelaaja1,pelaaja2,pvm) values (?,?,?)";
		Object[] params = new Object[] {p.getPelaaja1(), p.getPelaaja2(), p.getPvm()};
		jdbcTemplate.update(insertSQL, params);
	}
	
	public List<Peli> peliList() {
		String searchSQL = "select pelaaja1,pelaaja2,pvm,voittaja from peli";
		RowMapper<Peli> mapper = new PeliRowMapper();
		List<Peli> pelit = jdbcTemplate.query(searchSQL, mapper); 
		return pelit;
	}
	
	public void addVoittaja(Peli p) {
		String updateSQL = "update peli set voittaja=? where pelaaja1=? AND pelaaja2=? AND "
				+ "pvm=?";
		Object[] params = new Object[] {p.getVoittaja(), p.getPelaaja1(), p.getPelaaja2(), p.getPvm()};
		jdbcTemplate.update(updateSQL, params);
		
		String updatePelaajaPisteetSQL = "update pelaaja set pisteet=pisteet+1 where name=?";
		Object[] params2 = new Object[] {p.getVoittaja()};
		jdbcTemplate.update(updatePelaajaPisteetSQL, params2);
	}

}
