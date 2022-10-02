import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AddStavkaFormComponent } from './add-stavka-form.component';

describe('AddStavkaFormComponent', () => {
  let component: AddStavkaFormComponent;
  let fixture: ComponentFixture<AddStavkaFormComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AddStavkaFormComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(AddStavkaFormComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
