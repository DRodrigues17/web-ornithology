import { Component, OnInit } from '@angular/core';
import { Passaro } from 'src/app/interface/Passaro';
import { PassaroService } from 'src/app/service/PassaroService';

@Component({
  selector: 'app-tela-listagem',
  templateUrl: './tela-listagem.component.html',
  styleUrls: ['./tela-listagem.component.css']
})
export class TelaListagemComponent implements OnInit {

  passaros!: Passaro[];

  constructor(
    public passaroService: PassaroService
  ) { }

  ngOnInit(): void {
    this.getPassaros();
  }
  
  getPassaros(){
   this.passaroService.passaros$.subscribe( data => {
    this.passaros = data.data.passaros!;
   });
  }
}
