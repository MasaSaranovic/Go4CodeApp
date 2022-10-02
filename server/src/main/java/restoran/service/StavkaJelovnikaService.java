package restoran.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import restoran.model.Kategorija;
import restoran.model.StavkaJelovnika;
import restoran.repository.StavkaJelovnikaRepository;

@Component
public class StavkaJelovnikaService {
	
	@Autowired
	StavkaJelovnikaRepository stavkaRepository;

	public StavkaJelovnika findOne(Long id) {
		return stavkaRepository.findById(id).get();
	}

	public List<StavkaJelovnika> findAll() {
		return stavkaRepository.findAll();
	}

	public StavkaJelovnika save(StavkaJelovnika stavkaJelovnika) {
		return stavkaRepository.save(stavkaJelovnika);
	}

	public void remove(Long id) {
		stavkaRepository.deleteById(id);
	}
	
	public List<StavkaJelovnika> findByKategorijaId(Long kategorijaId) {
		return stavkaRepository.findByKategorijaId(kategorijaId);
	}
	
	public StavkaJelovnika findByNaziv(String naziv) {
		return stavkaRepository.findByNaziv(naziv);
	}
	
	public Page<StavkaJelovnika> findByNaziv(String naziv, Pageable page) {
		return stavkaRepository.findByNaziv(naziv, page);
	}

}
