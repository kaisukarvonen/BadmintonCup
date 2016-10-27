package fi.haagahelia.bean;

import javax.validation.constraints.Size;

public class Pelaaja implements Comparable<Pelaaja> {
	
	@Size(min = 6, max = 30, message="K‰ytt‰j‰tunnuksen tulla olla v‰hint‰‰n 6 merkki‰ pitk‰!")
	private String tunnus;
	
	@Size(min = 4, max = 60, message="Nimen tulla olla v‰hint‰‰n 4 merkki‰ pitk‰!")
	private String nimi;
	
	private int pisteet;
	
	@Size(min = 8, max = 30, message="Salasanan tulee olla v‰hint‰‰n 8 merkki‰ pitk‰!")
	private String salasana;
	
	
	public Pelaaja(String nimi, int pisteet) {
		super();
		this.nimi = nimi;
		this.pisteet = pisteet;
	}
	
	public Pelaaja() {
		super();
	}

	public String getSalasana() {
		return salasana;
	}

	public void setSalasana(String password) {
		this.salasana = password;
	}

	public String getTunnus() {
		return tunnus;
	}
	public void setTunnus(String tunnus) {
		this.tunnus = tunnus;
	}
	public String getNimi() {
		return nimi;
	}
	public void setNimi(String nimi) {
		this.nimi = nimi;
	}
	public int getPisteet() {
		return pisteet;
	}
	public void setPisteet(int pisteet) {
		this.pisteet = pisteet;
	}

	public int compareTo(Pelaaja p) {
		return p.getPisteet() - this.getPisteet(); 
	}
	
	

}
