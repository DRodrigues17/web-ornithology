import { ComponentFixture, TestBed } from '@angular/core/testing';

import { TelaListagemComponent } from './tela-listagem.component';

describe('TelaListagemComponent', () => {
  let component: TelaListagemComponent;
  let fixture: ComponentFixture<TelaListagemComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ TelaListagemComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(TelaListagemComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
