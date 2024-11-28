import { Endereco } from "./endereco";

export class Paciente{
    id: number;
    nome: string;
    cpf: string;
    dataNascimento: string;
    peso: number;
    altura: number;
    endereco: Endereco;
}