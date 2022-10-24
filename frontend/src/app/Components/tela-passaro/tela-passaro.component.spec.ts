import { ComponentFixture, TestBed } from '@angular/core/testing';

import { TelaPassaroComponent } from './tela-passaro.component';

describe('TelaPassaroComponent', () => {
  let component: TelaPassaroComponent;
  let fixture: ComponentFixture<TelaPassaroComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ TelaPassaroComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(TelaPassaroComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
