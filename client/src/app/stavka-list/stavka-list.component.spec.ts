import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { StavkaListComponent } from './stavka-list.component';

describe('StavkaListComponent', () => {
  let component: StavkaListComponent;
  let fixture: ComponentFixture<StavkaListComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ StavkaListComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(StavkaListComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
