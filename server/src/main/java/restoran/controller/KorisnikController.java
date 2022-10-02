package restoran.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


import restoran.dto.KorisnikDTO;
import restoran.dto.LoginDTO;
import restoran.model.Korisnik;
import restoran.service.KorisnikService;

@RestController
@CrossOrigin("http://localhost:4200")
public class KorisnikController {
	
	@Autowired
    KorisnikService korisnikService;

    @GetMapping(value = "api/korisnici")
    public ResponseEntity<List<KorisnikDTO>> getKorisnikPage() {
        final List<KorisnikDTO> retVal = korisnikService.findAll().stream()
                .map(KorisnikDTO::new)
                .collect(Collectors.toList());

        return new ResponseEntity<>(retVal, HttpStatus.OK);
    }
    
    @GetMapping(value = "api/korisnici/{id}")
    public ResponseEntity getKorisnik(@PathVariable Long id) {
        final Korisnik korisnik = korisnikService.findOne(id);

        if (korisnik == null) {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }

        final KorisnikDTO korisnikDTO = new KorisnikDTO(korisnik);
        return new ResponseEntity<>(korisnikDTO, HttpStatus.OK);
    }
    
    @PostMapping(value = "api/korisnici")
    public ResponseEntity create(@RequestBody KorisnikDTO korisnikDTO) {
        final Korisnik korisnik = new Korisnik();
        korisnik.setIme(korisnikDTO.getIme());
        korisnik.setPrezime(korisnikDTO.getPrezime());
        korisnik.setEmail(korisnikDTO.getEmail());
        korisnik.setSifra(korisnikDTO.getSifra());
        
        final Korisnik savedKorisnik = korisnikService.save(korisnik);
        return new ResponseEntity<>(new KorisnikDTO(savedKorisnik), HttpStatus.CREATED);
    }
    
    @PostMapping(value = "api/login")
    public Korisnik login(@RequestBody LoginDTO loginDTO) {
    	String email = loginDTO.getEmail();
    	String sifra = loginDTO.getSifra();

    	
    	Korisnik korisnik = korisnikService.findByEmail(email);
        if (korisnik == null) {
            return null;
            
        }
        
        if (!korisnik.getSifra().equals(sifra)) {
            return null;
        }
        System.out.println(korisnik);
        return korisnik;
    }

    @PutMapping(value = "api/korisnici/{id}")
    public ResponseEntity update(@PathVariable Long id,
                                 @RequestBody KorisnikDTO korisnikDTO) {
        final Korisnik korisnik = korisnikService.findOne(id);

        if (korisnik == null) {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }

        korisnik.setId(id);
        korisnik.setIme(korisnikDTO.getIme());
        korisnik.setPrezime(korisnikDTO.getPrezime());
        korisnik.setEmail(korisnikDTO.getEmail());
        korisnik.setSifra(korisnikDTO.getSifra());

        final Korisnik savedKorisnik = korisnikService.save(korisnik);
        return new ResponseEntity<>(new KorisnikDTO(savedKorisnik), HttpStatus.OK);
    }

    @DeleteMapping(value = "api/korisnici/{id}")
    public ResponseEntity delete(@PathVariable Long id) {
        final Korisnik korisnik = korisnikService.findOne(id);
        if (korisnik == null) {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }

        korisnikService.remove(id);
        return new ResponseEntity(HttpStatus.OK);
    }


}
