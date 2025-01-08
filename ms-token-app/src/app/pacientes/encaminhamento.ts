import { MedicacaoVeia } from "./medicacaoVeia";
import { Regiao } from "./regiao";

export class Encaminhamento{
    id: number;
    numToken: string;
    fichaId: number;
    nomePaciente: String;
    regioesRaiox: Regiao[];
    medicacaoIntravenosa: MedicacaoVeia[];
}