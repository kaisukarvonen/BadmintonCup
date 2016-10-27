package fi.haagahelia.bean;

public class Peli implements Comparable<Peli> { 
	private int id;
	private String pelaaja1;
	private String pelaaja2;
	private String pvm;
	private String voittaja;
	
	public Peli() {
		super();
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getPelaaja1() {
		return pelaaja1;
	}
	public void setPelaaja1(String pelaaja1) {
		this.pelaaja1 = pelaaja1;
	}
	public String getPelaaja2() {
		return pelaaja2;
	}
	public void setPelaaja2(String pelaaja2) {
		this.pelaaja2 = pelaaja2;
	}
	public String getPvm() {
		return pvm;
	}
	public void setPvm(String pvm) {
		this.pvm = pvm;
	}
	public String getVoittaja() {
		return voittaja;
	}
	public void setVoittaja(String voittaja) {
		this.voittaja = voittaja;
	}
	public int compareTo(Peli o) {
		return o.getPvm().compareTo(this.getPvm());
	}
	@Override
	public String toString() {
		return "Peli [pelaaja1=" + pelaaja1 + ", pelaaja2=" + pelaaja2 + ", pvm=" + pvm + ", voittaja=" + voittaja
				+ "]";
	}
	
	
	
	
}
