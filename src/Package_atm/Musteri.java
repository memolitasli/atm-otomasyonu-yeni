package Package_atm;

public class Musteri {
	private String isim;
	private String guvenlikcevabi;
	private int id;
	private float bakiye;
	private int parola;
	private long telefon;
	public String getIsim() {
		return isim;
	}
	public void setIsim(String isim) {
		this.isim = isim;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public float getBakiye() {
		return bakiye;
	}
	public void setBakiye(float bakiye) {
		this.bakiye = bakiye;
	}
	public int getParola() {
		return parola;
	}
	public void setParola(int parola) {
		this.parola = parola;
	}
	public void setTelefon(long telefon) {
		this.telefon = telefon;
	}
	public long getTelefon() {
		return this.telefon;
	}
	public void setGuvenlik(String cevap) {
		this.guvenlikcevabi = cevap;
	}
	public String getGuvenlik() {
		return this.guvenlikcevabi;
	}
	

}
