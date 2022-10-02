package restoran.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;


import restoran.model.Korisnik;
import restoran.repository.KorisnikRepository;

@Component
public class KorisnikService {
	
	@Autowired
	KorisnikRepository korisnikRepository;
	
	public List<Korisnik> findAll() {
		return korisnikRepository.findAll();
	}
	
	public Page<Korisnik> findAll(Pageable page) {
		return korisnikRepository.findAll(page);
	}

	public Korisnik findOne(Long id) {
		return korisnikRepository.findById(id).get();
	}

	public Korisnik save(Korisnik korisnik) {
		return korisnikRepository.save(korisnik);
	}

	public void remove(Long id) {
		korisnikRepository.deleteById(id);
	}
	
	public Korisnik findByEmail(String email) {
		return korisnikRepository.findByEmail(email);
	}
	
	public Korisnik findBySifra(String sifra) {
		return korisnikRepository.findBySifra(sifra);
	}


}
