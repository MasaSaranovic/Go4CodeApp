import { Kategorija } from "./kategorija.model";

export interface StavkaInterface {
    id?: number;
    naziv: string;
    cena: string;
    kategorija: Kategorija;

}

export class StavkaJelovnika implements StavkaInterface {
    public id: number;
    public naziv: string;
    public cena: string;
    public kategorija: Kategorija;

    constructor(stavkaCfg: StavkaInterface) {
        this.id = stavkaCfg.id != undefined ? stavkaCfg.id : -1;
        this.naziv = stavkaCfg.naziv;
        this.cena = stavkaCfg.cena;
        this.kategorija = stavkaCfg.kategorija;
    }


}

export interface StavkaDTO {
    stavka: StavkaJelovnika;
    index: string;
}