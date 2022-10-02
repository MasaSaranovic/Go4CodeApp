import { Kategorija } from "../model/kategorija.model";

export class StavkaDTO  {
    public naziv: string;
    public cena: string;
    public kategorija: Kategorija;
  
    constructor(kategorija:Kategorija,naziv:string,cena:string) {
      this.kategorija = kategorija;
      this.naziv = naziv;
      this.cena=cena;
    }
  }