import { Component, Input, OnInit } from '@angular/core';
import { StavkaJelovnika, StavkaInterface } from '../../model/stavka.model';
import { Output, EventEmitter } from '@angular/core';
import { Korisnik } from 'src/app/model/korisnik.model';
import { StavkaDTO } from 'src/app/DTO/StavkaDTO';
import { AppService } from 'src/app/app.service';
import { Router } from '@angular/router';
import { Kategorija } from 'src/app/model/kategorija.model';
import { KategorijaDTO } from 'src/app/DTO/KategorijaDTO';

@Component({
  selector: 'app-add-stavka-form',
  templateUrl: './add-stavka-form.component.html', 
  styleUrls: ['./add-stavka-form.component.css']
})
export class AddStavkaFormComponent implements OnInit {

  public kategorija: Kategorija | undefined;
  public newStavka: StavkaDTO;
  public logged: boolean;
  @Output()
  stavkaAdded: EventEmitter<StavkaInterface> = new EventEmitter();

  constructor(private appService: AppService, private router: Router) {

    this.kategorija = {
      id: -1,
      naziv: ''
    }

    this.newStavka = new StavkaDTO (this.kategorija, '', '');
    localStorage.getItem('korisnik') !== null
      ? (this.logged = true)
      : (this.logged = false);
  }
 

  ngOnInit() {}

  addStavka() {
    // this.stavkaAdded.emit(this.stavka);
    this.newStavka.kategorija.naziv = this.kategorija?.naziv!;
    this.appService.addStavka(this.newStavka).subscribe((res: StavkaJelovnika) => {
      window.location.reload();
    });

    this.newStavka.kategorija.naziv = '';
    this.newStavka.naziv = '';
    this.newStavka.cena = '';
  }
}
