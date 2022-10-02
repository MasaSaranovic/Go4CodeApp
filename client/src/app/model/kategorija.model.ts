interface KategorijaInterface {
    id?: number;
    naziv: string;
}

export class Kategorija implements KategorijaInterface {
    public id: number;
    public naziv: string;

    constructor(kategorijaCfg: KategorijaInterface) {
        this.id = kategorijaCfg.id != undefined ? kategorijaCfg.id : -1;
        this.naziv = kategorijaCfg.naziv;
    }
}

export interface KategotijaDTO {
    kategorija: Kategorija;
    index: string;
}