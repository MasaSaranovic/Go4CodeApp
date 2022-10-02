import { HttpClient } from '@angular/common/http';
import { Component, OnInit, ViewEncapsulation, Input } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { AppService } from '../app.service';
import { StavkaDTO } from '../DTO/StavkaDTO';
import { StavkaJelovnika, StavkaInterface } from '../model/stavka.model';

@Component({
  selector: 'app-stavka-list',
  templateUrl: './stavka-list.component.html',
  encapsulation: ViewEncapsulation.None
})
export class StavkaListComponent implements OnInit {
  // @Input() stavka: StavkaDTO;
  public logged: boolean;
  public showDeleteStavke: boolean = false;
  public stavka: StavkaJelovnika;

  @Input() public stavke: StavkaJelovnika[] = [];

  constructor(private route: ActivatedRoute,
    private http: HttpClient,
    private appService: AppService,
    private router: Router) {

      this.stavka = {
        id: -1,
        naziv: '',
        cena: '',
        kategorija: {
          id: -1,
          naziv: ''
        }
      };

    localStorage.getItem('korisnik') === null
      ? (this.logged = false)
      : (this.logged = true);
  }

  id: number = -1;

  ngOnInit() { 
    this.route.params.subscribe((params) => {
      this.id = +params['id'];
    });

    // this.appService.getStavkaById(this.id).subscribe((res) => {this.stavka = res});

    this.appService
      .getStavkaById(this.id)
      .subscribe((res) => (this.stavka = res)); 
  }

  deleteStavka($event: any,stavka: StavkaDTO){
    this.appService.deleteStavka(this.stavka.id).subscribe(res =>window.location.reload());
  }
}
