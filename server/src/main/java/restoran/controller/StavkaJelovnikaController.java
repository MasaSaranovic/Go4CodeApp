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
import restoran.model.StavkaJelovnika;
import restoran.service.StavkaJelovnikaService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class StavkaJelovnikaController {
	
	@Autowired
	StavkaJelovnikaService stavkaService;
	
	@GetMapping(value = "api/stavke")
    public ResponseEntity getStavkePage(@RequestParam(required = false, defaultValue="") String naziv) {
	  List<StavkaJelovnikaDTO> stavke;
        if (!naziv.isEmpty()) {
            final StavkaJelovnika stavka = stavkaService.findByNaziv(naziv);
            stavke = Arrays.asList(createDtoWithKategorija(stavka));
        }
        else {
        	stavke = stavkaService.findAll().stream()
                    .map(this::createDtoWithKategorija)
                    .collect(Collectors.toList());
        }

        return new ResponseEntity<>(stavke, HttpStatus.OK);
    }
	
	private StavkaJelovnikaDTO createDtoWithKategorija(StavkaJelovnika stavka) {
        final StavkaJelovnikaDTO dto = new StavkaJelovnikaDTO(stavka);
        final Kategorija kategorija = stavka.getKategorija();
        final KategorijaDTO kat = new KategorijaDTO(kategorija);
        dto.setKategorija(kategorija);

        return dto;
    }
  

	@GetMapping(value = "api/stavke/{id}")
    public ResponseEntity getStavka(@PathVariable Long id) {
        final StavkaJelovnika stavka = stavkaService.findOne(id);

        if (stavka == null) {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }

        final StavkaJelovnikaDTO stavkaDTO = createDtoWithKategorija(stavka);
        return new ResponseEntity<>(stavkaDTO, HttpStatus.OK);
     }
	
	@PostMapping(value = "api/stavke")
    public ResponseEntity create(@RequestBody StavkaJelovnikaDTO stavkaDTO) {
        final StavkaJelovnika stavka = new StavkaJelovnika();
        stavka.setNaziv(stavkaDTO.getNaziv());
        stavka.setCena(stavkaDTO.getCena());
        stavka.setKategorija(stavkaDTO.getKategorija());

        final StavkaJelovnika savedStavka = stavkaService.save(stavka);
        return new ResponseEntity<>(createDtoWithKategorija(savedStavka), HttpStatus.CREATED);
    }
	
	@PutMapping(value = "api/stavke/{id}")
    public ResponseEntity update(@PathVariable Long id,
                                 @RequestBody StavkaJelovnikaDTO stavkaDTO) {
        final StavkaJelovnika stavka = stavkaService.findOne(id);

        if (stavka == null) {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }

        stavka.setId(id);
        stavka.setNaziv(stavkaDTO.getNaziv());
        stavka.setCena(stavkaDTO.getCena());
        stavka.setKategorija(stavkaDTO.getKategorija());

        final StavkaJelovnika savedStavka = stavkaService.save(stavka);
        return new ResponseEntity<>(createDtoWithKategorija(savedStavka), HttpStatus.CREATED);
    }

    @DeleteMapping(value = "api/stavke/{id}")
    public ResponseEntity delete(@PathVariable Long id) {
         final StavkaJelovnika stavka = stavkaService.findOne(id);
        if (stavka == null) {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }

        stavkaService.remove(id);
        return new ResponseEntity(HttpStatus.OK);
    }

}
