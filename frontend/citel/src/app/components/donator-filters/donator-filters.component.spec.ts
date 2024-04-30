import { ComponentFixture, TestBed } from '@angular/core/testing';

import { DonatorFiltersComponent } from './donator-filters.component';

describe('DonatorFiltersComponent', () => {
  let component: DonatorFiltersComponent;
  let fixture: ComponentFixture<DonatorFiltersComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [DonatorFiltersComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(DonatorFiltersComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
