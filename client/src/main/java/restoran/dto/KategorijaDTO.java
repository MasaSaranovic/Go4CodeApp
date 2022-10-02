package restoran.dto;

import restoran.model.Kategorija;

public class KategorijaDTO {

	private Long id;

	private String naziv;

	public KategorijaDTO() {

	}

	public KategorijaDTO(Long id, String naziv) {
		this.id = id;
		this.naziv = naziv;
	}

	public KategorijaDTO(Kategorija kategorija) {
		this.id = kategorija.getId();
		this.naziv = kategorija.getNaziv();
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

	@Override
	public String toString() {
		return "KategorijaDTO [id=" + id + ", naziv=" + naziv + "]";
	}
	

}
