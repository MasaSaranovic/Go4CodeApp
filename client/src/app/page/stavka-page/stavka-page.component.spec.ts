import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { StavkaPageComponent } from './stavka-page.component';

describe('StavkaPageComponent', () => {
  let component: StavkaPageComponent;
  let fixture: ComponentFixture<StavkaPageComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ StavkaPageComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(StavkaPageComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
