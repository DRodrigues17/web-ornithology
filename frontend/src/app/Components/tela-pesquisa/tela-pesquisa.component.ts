import { Component, Input, OnInit } from '@angular/core';
import { FormControl, FormGroup } from '@angular/forms';
import { TipoPesquisa } from 'src/app/enum/tipo-pesquisa.enum';
import { Passaro } from 'src/app/interface/Passaro';
import { PassaroService } from 'src/app/service/PassaroService';

@Component({
  selector: 'app-tela-pesquisa',
  templateUrl: './tela-pesquisa.component.html',
  styleUrls: ['./tela-pesquisa.component.css']
})
export class TelaPesquisaComponent implements OnInit {
  
  passaro!: any;
  nome!: string;
  visibility: boolean = false;
  alertaError!: string;

  constructor(
    public passaroService: PassaroService
  ) { }

  ngOnInit(): void {

  }


  procurarPassaro(){
    this.passaroService.findByName$(this.nome).subscribe
    ((data) => {
      this.passaro = data.data;       
      this.visibility = true

    },
    (error) =>{
      this.alertaError = 'Não foi encontrado um passaro com o nome: '
      console.error(error);
      alert(this.alertaError + this.nome)
    });   

  }
 
}