import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { AppComponent } from './app.component';
import { HomeComponent } from './Components/home/home.component';
import { TelaListagemComponent } from './Components/tela-listagem/tela-listagem.component';
import { TelaPesquisaComponent } from './Components/tela-pesquisa/tela-pesquisa.component';
import { TelaPostagemComponent } from './Components/tela-postagem/tela-postagem.component';
import { TelaPassaroComponent } from './Components/tela-passaro/tela-passaro.component';

const routes: Routes = [
    { path:'', component: HomeComponent },
    { path:'list', component: TelaListagemComponent},
    { path:'post', component: TelaPostagemComponent },
    { path:'search', component: TelaPesquisaComponent },
    { path:'passaroPage/:nome', component: TelaPassaroComponent }
];

@NgModule({
    imports: [RouterModule.forRoot(routes)],
    exports: [RouterModule]
})
export class AppRoutingModule {}


