export class KorisnikDTO  {
    public email: string;
    public sifra: string;
  
    constructor(email:string,sifra:string) {
      this.email = email;
      this.sifra = sifra;
    }
  }