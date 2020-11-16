import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { LeavehistoryComponent } from './leavehistory.component';

describe('LeavehistoryComponent', () => {
  let component: LeavehistoryComponent;
  let fixture: ComponentFixture<LeavehistoryComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ LeavehistoryComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(LeavehistoryComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
