import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { FormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import { RouterModule, Routes } from '@angular/router';
// import { IgxDropDownModule } from '@angular/igx-drop-down';

import { AppComponent } from './app.component';
// import { FilterComponent } from './filter/filter.component';
import { SearchComponent } from './search/search.component';
import { StavkaListComponent } from './stavka-list/stavka-list.component';
import { StavkaListItemComponent } from './stavka-list-item/stavka-list-item.component';
import { AddStavkaFormComponent } from './form/add-stavka-form/add-stavka-form.component';
import { StavkaPageComponent } from './page/stavka-page/stavka-page.component';
import { PageNotFoundComponent } from './page-not-found/page-not-found.component';
import { LoginComponent } from './login/login.component';


const appRoutes: Routes = [
  { path: 'stavke', component: StavkaPageComponent },
  { path: 'login', component: LoginComponent },
  // { path: 'edit-stavka', component: EditStavkaPageComponent },
  { path: '', redirectTo: 'stavke', pathMatch: 'full' },
  { path: '**', component: PageNotFoundComponent }
]

@NgModule({
  declarations: [
    AppComponent,
    SearchComponent,
    StavkaListComponent,
    StavkaListItemComponent,
    AddStavkaFormComponent,
    StavkaPageComponent,
    PageNotFoundComponent,
    LoginComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    HttpClientModule,
    RouterModule.forRoot(appRoutes)
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }

