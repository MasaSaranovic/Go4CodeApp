package restoran.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import restoran.model.Kategorija;


@Repository
public interface KategorijaRepository extends JpaRepository<Kategorija, Long>{
	
	public Kategorija findByNaziv(String naziv);
	public Page<Kategorija> findByNaziv(String naziv, Pageable page);
	

}
