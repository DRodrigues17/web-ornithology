import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { AppComponent } from './app.component';
import { TelaPesquisaComponent } from './Components/tela-pesquisa/tela-pesquisa.component';
import { TelaPostagemComponent } from './Components/tela-postagem/tela-postagem.component';

const routes: Routes = [
    { path:'', component: AppComponent },
    { path:'post', component: TelaPostagemComponent },
];

@NgModule({
    imports: [RouterModule.forRoot(routes)],
    exports: [RouterModule]
})
export class AppRoutingModule {}


