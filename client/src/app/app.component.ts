import { Component } from '@angular/core';
import { AppService } from './app.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'restoran';

  public logged: boolean;
  constructor(private appService: AppService) {
    this.logged = false;
  }

  ngOnInit() {
    this.appService.cast.subscribe((res) =>
      res != null ? (this.logged = true) : (this.logged = false)
    );
  }

  logout() {
    // this.appService.editUser(null);
    localStorage.removeItem('korisnik');
    localStorage.getItem('korisnik') !== null
      ? (this.logged = true)
      : (this.logged = false);
      window.location.reload()
  }
}
