import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { LoginComponent } from './login/login.component';
import { PageNotFoundComponent } from './page-not-found/page-not-found.component';
import { StavkaPageComponent } from './page/stavka-page/stavka-page.component';

const routes: Routes = [
  { path: 'stavke', component: StavkaPageComponent },
  { path: 'login', component: LoginComponent },
  // { path: 'edit-stavka', component: EditStavkaPageComponent },
  { path: '', redirectTo: 'stavke', pathMatch: 'full' },
  { path: '**', component: PageNotFoundComponent },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule],
})
export class AppRoutingModule {}
