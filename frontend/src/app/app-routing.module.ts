import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { AppComponent } from './app.component';
import { HomeComponent } from './Components/home/home.component';
import { TelaListagemComponent } from './Components/tela-listagem/tela-listagem.component';
import { TelaPesquisaComponent } from './Components/tela-pesquisa/tela-pesquisa.component';
import { TelaPostagemComponent } from './Components/tela-postagem/tela-postagem.component';

const routes: Routes = [
    { path:'home', component: HomeComponent },
    { path:'list', component: TelaListagemComponent},
    { path:'post', component: TelaPostagemComponent },
    { path:'search', component: TelaPesquisaComponent }
];

@NgModule({
    imports: [RouterModule.forRoot(routes)],
    exports: [RouterModule]
})
export class AppRoutingModule {}


