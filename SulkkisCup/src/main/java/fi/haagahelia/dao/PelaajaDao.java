package fi.haagahelia.dao;

import java.util.Collections;
import java.util.List;

import javax.inject.Inject;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.security.crypto.password.StandardPasswordEncoder;
import org.springframework.stereotype.Repository;

import fi.haagahelia.bean.Pelaaja;

@Repository 
public class PelaajaDao {
	
	@Inject
	private JdbcTemplate jdbcTemplate;

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}
	
	public void addPelaaja(Pelaaja p) {
		String insertSQL = "insert into pelaaja (username, password_encrypted, enabled, name, pisteet) VALUES (?,?,?,?,?)";
		StandardPasswordEncoder encoder = new StandardPasswordEncoder();
		String hashedPassword = encoder.encode(p.getSalasana());
		Object[] params = new Object[] { p.getTunnus(), hashedPassword, 1, p.getNimi(), 0};
		jdbcTemplate.update(insertSQL, params);
		
		String insertAuthoritySQL = "INSERT INTO pelaaja_authority (pelaaja_username, authority_id) VALUES (?,?)";
		Object[] params2 = new Object[] { p.getTunnus(), 1};
		jdbcTemplate.update(insertAuthoritySQL, params2);
		System.out.println("*Lisätty "+p.getNimi()+"*");  
	}
	
	public List<Pelaaja> pelaajaListByPoints() {
		String searchSQL = "select name, pisteet from pelaaja p JOIN pelaaja_authority pauth ON (p.username = pauth.pelaaja_username) JOIN authority a ON (a.id = pauth.authority_id) WHERE pauth.authority_id = ?";
		Object[] param = new Object[] {1};
		RowMapper<Pelaaja> mapper = new PelaajaRowMapper();
		List<Pelaaja> pelaajat = jdbcTemplate.query(searchSQL, param, mapper);
		return pelaajat;
	}
	
	
}
