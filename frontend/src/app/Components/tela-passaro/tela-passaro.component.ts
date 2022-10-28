import { Component, OnInit } from '@angular/core';
import { Passaro } from 'src/app/interface/Passaro';
import { PassaroService } from 'src/app/service/PassaroService';

@Component({
  selector: 'app-tela-passaro',
  templateUrl: './tela-passaro.component.html',
  styleUrls: ['./tela-passaro.component.css']
})
export class TelaPassaroComponent implements OnInit {

  nome!: string;
  passaro!: Passaro;

  constructor(public passaroService: PassaroService) {
    
   }

  ngOnInit(): void {
    this.buscarPassaro(this.nome);
  }

  buscarPassaro(nome: string){
    this.passaroService.findByName$(nome).subscribe( data =>{
      this.passaro = data.data.passaro!;
      
    });
  }

}
