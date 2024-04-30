import { ComponentFixture, TestBed } from '@angular/core/testing';

import { DonatorsViewComponent } from './donators-view.component';

describe('DonatorsViewComponent', () => {
  let component: DonatorsViewComponent;
  let fixture: ComponentFixture<DonatorsViewComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [DonatorsViewComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(DonatorsViewComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
