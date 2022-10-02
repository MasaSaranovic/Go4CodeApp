package restoran.dto;


import restoran.model.Korisnik;

public class LoginDTO {
	
	private String email;
    private String sifra;
    
    public LoginDTO(){}

    public LoginDTO(String email, String sifra){
        this.email = email;
        this.sifra = sifra;
    }
    
    public LoginDTO(Korisnik korisnik) {
        this.email = korisnik.getEmail();
        this.sifra = korisnik.getSifra();
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
    
    

}
