import { Component, OnInit, ViewEncapsulation } from '@angular/core';
import { StavkaJelovnika } from '../model/stavka.model';
import { Input } from '@angular/core';

@Component({
  selector: 'app-stavka-list-item',
  templateUrl: './stavka-list-item.component.html'
})
export class StavkaListItemComponent implements OnInit {
  @Input() stavka: StavkaJelovnika | undefined;
  public logged: boolean;

  constructor() {

    localStorage.getItem('korisnik') !== null
      ? (this.logged = true)
      : (this.logged = false);
  }

  ngOnInit() {}

  deleteStavka() {}

  editStavka() {}
}
