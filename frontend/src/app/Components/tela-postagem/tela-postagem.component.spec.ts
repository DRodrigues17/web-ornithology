import { ComponentFixture, TestBed } from '@angular/core/testing';

import { TelaPostagemComponent } from './tela-postagem.component';

describe('TelaPostagemComponent', () => {
  let component: TelaPostagemComponent;
  let fixture: ComponentFixture<TelaPostagemComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ TelaPostagemComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(TelaPostagemComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
