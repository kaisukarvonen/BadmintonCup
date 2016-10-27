package fi.haagahelia.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import fi.haagahelia.bean.Pelaaja;

public class PelaajaRowMapper implements RowMapper<Pelaaja> {

	public Pelaaja mapRow(ResultSet rs, int line) throws SQLException {
		Pelaaja p = new Pelaaja();
		p.setNimi(rs.getString("name"));
		p.setPisteet(rs.getInt("pisteet"));
		return p;
	}

}
