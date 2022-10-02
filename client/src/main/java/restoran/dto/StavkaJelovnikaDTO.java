package restoran.dto;

import java.util.ArrayList;
import java.util.List;

import restoran.model.Kategorija;
import restoran.model.StavkaJelovnika;

public class StavkaJelovnikaDTO {
	
	private Long id;
    private String naziv;
    private String cena;
    
    private Kategorija kategorija;

    public StavkaJelovnikaDTO() {

    }

    public StavkaJelovnikaDTO(Long id, String naziv, String cena, Kategorija kategorija) {
		this.id = id;
		this.naziv = naziv;
		this.cena = cena;
		this.kategorija = kategorija;
	}
    
   
    public StavkaJelovnikaDTO(StavkaJelovnika stavka) {
        this.id = stavka.getId();
        this.naziv = stavka.getNaziv();
        this.cena = stavka.getCena();
        this.kategorija = kategorija;
    }
    
    public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNaziv() {
		return naziv;
	}

	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}

	public String getCena() {
		return cena;
	}

	public void setCena(String cena) {
		this.cena = cena;
	}

	public Kategorija getKategorija() {
		return kategorija;
	}

	public void setKategorija(Kategorija kategorija) {
		this.kategorija = kategorija;
	}
	
	@Override
    public String toString() {
        return "StavkaJelovnikaDTO [id=" + id + ", naziv=" + naziv + ", cena="
                + cena + "]";
    }

}
