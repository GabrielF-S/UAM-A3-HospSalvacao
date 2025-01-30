import { Token } from "./token";
import { Ficha } from "./ficha";
import { Medicacao } from "./medicacao";

export class Receita{
    id: number;
    numToken: string;
    fichaId: number;
    nomePaciente: String;
    medicacoes: Medicacao[];
}