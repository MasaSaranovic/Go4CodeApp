package restoran.controller;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import restoran.dto.KategorijaDTO;
import restoran.dto.StavkaJelovnikaDTO;
import restoran.model.Kategorija;
import restoran.service.KategorijaService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class KategorijaController {

	@Autowired
	KategorijaService kategorijaService;

	  @GetMapping(value = "api/kategorije")
	    public ResponseEntity getKategorijePage(@RequestParam(required = false, defaultValue="") String naziv) {
		  List<KategorijaDTO> kategorije;
	        if (!naziv.isEmpty()) {
	            final Kategorija kategorija = kategorijaService.findByNaziv(naziv);
	            kategorije = Arrays.asList(createDtoWithKategorija(kategorija));
	        }
	        else {
	        	kategorije = kategorijaService.findAll().stream()
	                    .map(this::createDtoWithKategorija)
	                    .collect(Collectors.toList());
	        }

	        return new ResponseEntity<>(kategorije, HttpStatus.OK);
	    }
	  
	  private KategorijaDTO createDtoWithKategorija(Kategorija kategorija) {
	        final KategorijaDTO dto = new KategorijaDTO(kategorija);

	        return dto;
	    }

	    @GetMapping(value = "api/kategorije/{id}")
	    public ResponseEntity getKategorija(@PathVariable Long id) {
	        final Kategorija kategorija = kategorijaService.findOne(id);

	        if (kategorija == null) {
	            return new ResponseEntity(HttpStatus.NOT_FOUND);
	        }

	        final KategorijaDTO kategorijaDTO = new KategorijaDTO(kategorija);
	        return new ResponseEntity<>(kategorijaDTO, HttpStatus.OK);
	    }

	    @PutMapping(value = "api/kategorije/{id}")
	    public ResponseEntity update(@PathVariable Long id,
	                                 @RequestBody KategorijaDTO kategorijaDTO) {
	        final Kategorija kategorija = kategorijaService.findOne(id);

	        if (kategorija == null) {
	            return new ResponseEntity(HttpStatus.NOT_FOUND);
	        }

	        kategorija.setId(id);
	        kategorija.setNaziv(kategorijaDTO.getNaziv());

	        final Kategorija savedKategorija = kategorijaService.save(kategorija);
	        return new ResponseEntity<>(new KategorijaDTO(savedKategorija), HttpStatus.OK);
	    }

	    @DeleteMapping(value = "api/kategorije/{id}")
	    public ResponseEntity delete(@PathVariable Long id) {
	        final Kategorija kategorija = kategorijaService.findOne(id);
	        if (kategorija == null) {
	            return new ResponseEntity(HttpStatus.NOT_FOUND);
	        }

	        kategorijaService.remove(id);
	        return new ResponseEntity(HttpStatus.OK);
	    }
}
