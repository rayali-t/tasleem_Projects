import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { PaymentPaypalGatewayComponent } from './payment-paypal-gateway.component';

describe('PaymentPaypalGatewayComponent', () => {
  let component: PaymentPaypalGatewayComponent;
  let fixture: ComponentFixture<PaymentPaypalGatewayComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ PaymentPaypalGatewayComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(PaymentPaypalGatewayComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
