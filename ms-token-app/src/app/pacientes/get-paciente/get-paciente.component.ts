import { Component, OnInit } from '@angular/core';
import { Location } from '@angular/common'

@Component({
  selector: 'app-get-paciente',
  templateUrl: './get-paciente.component.html',
  styleUrls: ['./get-paciente.component.css']
})
export class GetPacienteComponent implements OnInit {

  constructor(private location: Location,) { }

  ngOnInit(): void {
  }

  voltar() {
    this.location.back();
  }

}
