
export interface KorisnikInterface {
    id?: number;
    ime: string;
    prezime: string;
    email: string;
    sifra: string;

}

export class Korisnik implements KorisnikInterface {
    public id: number;
    public ime: string;
    public prezime: string;
    public email: string;
    public sifra: string;

    constructor(korisnikCfg: KorisnikInterface) {
        this.id = korisnikCfg.id != undefined ? korisnikCfg.id : -1;
        this.ime = korisnikCfg.ime;
        this.prezime = korisnikCfg.prezime;
        this.email = korisnikCfg.email;
        this.sifra = korisnikCfg.sifra;
    }


}

export interface KorisnikDTO {
    korisnik: Korisnik;
    index: string;
}