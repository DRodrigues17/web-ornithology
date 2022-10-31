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
  
  formPesquisa!: FormGroup;
  passaro!: Passaro;

  constructor(
    public passaroService: PassaroService
  ) { }

  ngOnInit(): void {
    this.createForm("");
  }

  createForm(palavra: string){
    this.formPesquisa = new FormGroup({
      palavraChave: new FormControl(palavra)
    })
  }

  procurarPassaro(){
    console.log('i am a tea pot');
    this.passaroService.findByName$(this.formPesquisa.value).subscribe(data => {
    this.passaro = data.data.passaro!;        
    });   
  }

}
