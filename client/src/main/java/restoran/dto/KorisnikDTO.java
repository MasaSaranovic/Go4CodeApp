package restoran.dto;

import restoran.model.Kategorija;
import restoran.model.Korisnik;

public class KorisnikDTO {

	private Long id;

	private String ime;

	private String prezime;

	private String email;
	
	private String sifra;

	public KorisnikDTO() {

	}

	public KorisnikDTO(Long id, String ime, String prezime, String email, String sifra) {
		this.id = id;
		this.ime = ime;
		this.prezime = prezime;
		this.email = email;
		this.sifra = sifra;
	}
	
	public KorisnikDTO(Korisnik korisnik) {
		this.id = korisnik.getId();
		this.ime = korisnik.getIme();
		this.prezime = korisnik.getPrezime();
		this.email = korisnik.getEmail();
		this.sifra = korisnik.getSifra();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getIme() {
		return ime;
	}

	public void setIme(String ime) {
		this.ime = ime;
	}

	public String getPrezime() {
		return prezime;
	}

	public void setPrezime(String prezime) {
		this.prezime = prezime;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	

	public String getSifra() {
		return sifra;
	}

	public void setSifra(String sifra) {
		this.sifra = sifra;
	}

	@Override
	public String toString() {
		return "KorisnikDTO [id=" + id + ", ime=" + ime + ", prezime=" + prezime + ", email=" + email + ", sifra="
				+ sifra + "]";
	}


}
