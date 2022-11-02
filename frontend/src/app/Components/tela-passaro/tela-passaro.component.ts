import { Component, OnInit } from '@angular/core';
import { Passaro } from 'src/app/interface/Passaro';
import { PassaroService } from 'src/app/service/PassaroService';
import { ActivatedRoute } from '@angular/router';


@Component({
  selector: 'app-tela-passaro',
  templateUrl: './tela-passaro.component.html',
  styleUrls: ['./tela-passaro.component.css']
})
export class TelaPassaroComponent implements OnInit {

  passaro!: any;
  nome: any = '';
  
  constructor(public passaroService: PassaroService, private route: ActivatedRoute,
    ) {
    
   }

  ngOnInit(): void {
    this.getUrlParams();
    this.procurarPassaro(this.nome.nome)
    
  }

  getUrlParams(){
    console.log('NOME',this.route.params)
    this.route?.params?.subscribe((params)=> {
      this.nome = params;
      
    
    });
  }

  procurarPassaro(nome: any){
    this.passaroService.findByName$(nome).subscribe
    ((data) => {
      this.passaro = data.data;       
    },
    (error) =>{
      console.error(error);
      alert("Não foi encontrado um passaro com o nome: "+this.nome)
    });   

  }

}
