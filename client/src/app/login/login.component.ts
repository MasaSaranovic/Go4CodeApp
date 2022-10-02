import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { AppService } from '../app.service';
import { KorisnikDTO } from '../DTO/KorisnikDTO';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  public korisnikDTO: KorisnikDTO;
  public error: boolean;

  constructor(private appService: AppService, private route: Router) { 
    this.korisnikDTO = {
      email: '',
      sifra: '',
    };
    this.error = false;
  }

  ngOnInit(): void {
  }

  login() {
    this.appService.login(this.korisnikDTO).subscribe((res) => {
      if (res === null) {
        this.error = true;
      } else {
        localStorage.setItem('korisnik', JSON.stringify(res));
        this.appService.editKorisnik(res);
        this.route.navigate(['/stavke']);
      }
    });
  }

}
