import { Component, OnInit } from '@angular/core';
import { Passaro } from 'src/app/interface/Passaro';
import { PassaroService } from 'src/app/service/PassaroService';
import { FormGroup, FormControl } from '@angular/forms'

@Component({
  selector: 'app-tela-postagem',
  templateUrl: './tela-postagem.component.html',
  styleUrls: ['./tela-postagem.component.css']
})
export class TelaPostagemComponent implements OnInit {

  formPassaro!: FormGroup;

  

  constructor(
    public passaroService: PassaroService
  ) { }

  ngOnInit(): void {
    this.createForm(new Passaro());
  }


  createForm(passaroForm: Passaro){
    this.formPassaro = new FormGroup({
      linkImagem: new FormControl(passaroForm.linkImagem),
      nome: new FormControl(passaroForm.nome),
      nomeIngles: new FormControl(passaroForm.nomeIngles),
      nomeLatin: new FormControl(passaroForm.nomeLatin),
      tamanho: new FormControl(passaroForm.tamanho),
      genero: new FormControl(passaroForm.genero),
      corPredominante: new FormControl(passaroForm.corPredominante),
      familia: new FormControl(passaroForm.familia),
      habitat: new FormControl(passaroForm.habitat)
    })
  }


  cadastrarPassaro() {
    console.log(this.formPassaro.value);
    this.passaroService.create$(this.formPassaro.value as Passaro).subscribe();
  }
}
