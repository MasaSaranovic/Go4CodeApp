package restoran.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import restoran.model.Kategorija;
import restoran.model.StavkaJelovnika;

@Component
public interface StavkaJelovnikaRepository extends JpaRepository<StavkaJelovnika, Long>{

	public List<StavkaJelovnika> findByKategorijaId(Long kategorijaId);
	
	public StavkaJelovnika findByNaziv(String naziv);
	public Page<StavkaJelovnika> findByNaziv(String naziv, Pageable page);

}
