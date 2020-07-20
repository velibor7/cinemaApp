import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AuditoriumsComponent } from './auditoriums.component';

describe('AuditoriumsComponent', () => {
  let component: AuditoriumsComponent;
  let fixture: ComponentFixture<AuditoriumsComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AuditoriumsComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AuditoriumsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
