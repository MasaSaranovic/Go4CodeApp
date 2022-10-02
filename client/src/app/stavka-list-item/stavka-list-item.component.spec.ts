import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { StavkaListItemComponent } from './stavka-list-item.component';

describe('StavkaListItemComponent', () => {
  let component: StavkaListItemComponent;
  let fixture: ComponentFixture<StavkaListItemComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ StavkaListItemComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(StavkaListItemComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
