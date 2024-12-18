import { Token } from "../token/token";
import { Ficha } from "../triagem/ficha";
import { Medicacao } from "./medicacao";

export class Receita{
    id: number;
    numToken: string;
    fichaId: number;
    nomePaciente: String;
    medicacoes: Medicacao[];
}