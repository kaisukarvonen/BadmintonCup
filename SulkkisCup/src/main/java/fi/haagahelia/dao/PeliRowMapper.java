package fi.haagahelia.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import fi.haagahelia.bean.Peli;

public class PeliRowMapper implements RowMapper<Peli> {

	public Peli mapRow(ResultSet rs, int line) throws SQLException {
		Peli p = new Peli();
		p.setPelaaja1(rs.getString("pelaaja1"));
		p.setPelaaja2(rs.getString("pelaaja2"));
		p.setPvm(rs.getString("pvm"));
		p.setVoittaja(rs.getString("voittaja"));
		return p;
	}

}
