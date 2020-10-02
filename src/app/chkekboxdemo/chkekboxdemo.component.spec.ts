import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ChkekboxdemoComponent } from './chkekboxdemo.component';

describe('ChkekboxdemoComponent', () => {
  let component: ChkekboxdemoComponent;
  let fixture: ComponentFixture<ChkekboxdemoComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ChkekboxdemoComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ChkekboxdemoComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
