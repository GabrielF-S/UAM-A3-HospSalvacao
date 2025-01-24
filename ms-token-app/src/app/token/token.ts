import { Paciente } from "../pacientes/paciente";

export class Token{
    id: number;
    numToken: string;
    dataEntrada: string;
    paciente: Paciente;
    status: string;
    atendimento: string;
    retorno: boolean;
}