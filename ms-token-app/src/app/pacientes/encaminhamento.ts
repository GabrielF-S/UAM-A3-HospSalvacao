import { MedicacaoVeia } from "./medicacaoVeia";

export class Encaminhamento{
    id: number;
    numToken: string;
    fichaId: number;
    nomePaciente: String;
    regioesRaiox: string[];
    medicacaoIntravenosa: MedicacaoVeia[];
}