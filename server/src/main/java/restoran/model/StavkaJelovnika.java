package restoran.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
@Table(catalog = "db_restoran", name = "stavka") 
public class StavkaJelovnika {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String naziv;
	
	private String cena;
	
	@ManyToOne(fetch = FetchType.EAGER) 
	private Kategorija kategorija;
	
	public StavkaJelovnika() {
		
	}
	
	public StavkaJelovnika(Long id, String naziv, String cena) {
		
		super();
		this.id = id;
		this.naziv = naziv;
		this.cena = cena;
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
		return "StavkaJelovnika [id=" + id + ", naziv=" + naziv + ", cena=" + cena + "]";
	}
}
