import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { OTPandEmailComponent } from './otpand-email.component';

describe('OTPandEmailComponent', () => {
  let component: OTPandEmailComponent;
  let fixture: ComponentFixture<OTPandEmailComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ OTPandEmailComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(OTPandEmailComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
