package restoran.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import restoran.model.Kategorija;
import restoran.repository.KategorijaRepository;


@Component
public class KategorijaService {
	
	@Autowired
	KategorijaRepository kategorijaRepository;
	StavkaJelovnikaService stavkaService;

	public Kategorija findOne(Long id) {
		return kategorijaRepository.findById(id).get();
	}

	public List<Kategorija> findAll() {
		return kategorijaRepository.findAll();
	}

	public Kategorija save(Kategorija kategorija) {
		return kategorijaRepository.save(kategorija);
	}

	public void remove(Long id) {
		if (stavkaService.findByKategorijaId(id).isEmpty()) {
			kategorijaRepository.deleteById(id);
		}
	}
	
	public Kategorija findByNaziv(String naziv) {
		return kategorijaRepository.findByNaziv(naziv);
	}
	
	public Page<Kategorija> findByNaziv(String naziv, Pageable page) {
		return kategorijaRepository.findByNaziv(naziv, page);
	}

}
