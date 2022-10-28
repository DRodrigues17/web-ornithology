import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { HttpClientModule } from '@angular/common/http';
import { AppRoutingModule } from './app-routing.module';

import { AppComponent } from './app.component';
import { NavbarComponent } from './Components/navbar/navbar.component';
import { FooterComponent } from './Components/footer/footer.component';
import { TelaPassaroComponent } from './Components/tela-passaro/tela-passaro.component';
import { TelaPostagemComponent } from './Components/tela-postagem/tela-postagem.component';
import { TelaListagemComponent } from './Components/tela-listagem/tela-listagem.component';
import { TelaPesquisaComponent } from './Components/tela-pesquisa/tela-pesquisa.component';
import { HomeComponent } from './Components/home/home.component';

@NgModule({
  declarations: [
    AppComponent,
    NavbarComponent,
    FooterComponent,
    TelaPassaroComponent,
    TelaPostagemComponent,
    TelaListagemComponent,
    TelaPesquisaComponent,
    HomeComponent
  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    AppRoutingModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
