import { Component, OnInit } from '@angular/core';
import { NonNullableFormBuilder } from '@angular/forms';
import { Passaro } from 'src/app/interface/Passaro';
import { PassaroService } from 'src/app/service/PassaroService';

@Component({
  selector: 'app-tela-postagem',
  templateUrl: './tela-postagem.component.html',
  styleUrls: ['./tela-postagem.component.css']
})
export class TelaPostagemComponent implements OnInit {

  passaro!: Passaro;

  

  constructor(
    public passaroService: PassaroService
  ) { }

  ngOnInit(): void {
  }

  realizarCadastro(): void{
    this.passaro.linkImagem = '';
    this.passaro.nome ="";
    this.passaro.nomeIngles ="";
    this.passaro.nomeLatin ="";
    this.passaro.tamanho ="";
    this.passaro.genero ="";
    this.passaro.corPredominante ="";
    this.passaro.familia ="";
    this.passaro.habitat ="";
    console.log(this.passaro);
  }
}
