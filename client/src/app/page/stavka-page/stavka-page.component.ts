import { Component, OnInit } from '@angular/core';
import { StavkaJelovnika, StavkaInterface } from '../../model/stavka.model';
import { AppService } from '../../app.service';

@Component({
  selector: 'app-stavka-page',
  templateUrl: './stavka-page.component.html'
})
export class StavkaPageComponent implements OnInit {
  stavke: StavkaJelovnika[] = [];

  constructor(private appService: AppService) {}

  ngOnInit() {
    this.loadData();
  }

  loadData() {
    this.appService.getStavke().subscribe((resp: StavkaJelovnika[]) => {
      this.stavke = resp;
      console.log(this.stavke);
    });
  }

  addStavka(student: StavkaInterface) {
    this.appService.addStavka(student).subscribe((resp) => {
      this.loadData();
    });
  }

  deleteStavka(id: number) {}

  editStavka(stavka: StavkaJelovnika) {}

  setActiveStavka(stavka: StavkaJelovnika) {}

  search(naziv: string) {}
}
