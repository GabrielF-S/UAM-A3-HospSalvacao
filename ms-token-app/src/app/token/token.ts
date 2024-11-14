import { Paciente } from "../pacientes/paciente";

export class Token{
    in: number;
    numToken: string;
    dataEntrada: string;
    paciente: Paciente;
    status: string;
    atendimento: string;
}