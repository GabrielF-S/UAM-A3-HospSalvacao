import { MedicacaoVeia } from "./medicacaoVeia";

export class Encaminhamento{
    id: number;
    numToken: string;
    fichaId: number;
    nomePaciente: String;
    regiaoRaioX: string[];
    medicacaoIntravenosa: MedicacaoVeia[];
}