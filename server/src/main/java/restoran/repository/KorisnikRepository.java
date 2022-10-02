package restoran.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import restoran.model.Korisnik;

@Repository
public interface KorisnikRepository extends JpaRepository<Korisnik, Long>{
	
	public Korisnik findByEmail(String email);
	public Korisnik findBySifra(String sifra);

}
