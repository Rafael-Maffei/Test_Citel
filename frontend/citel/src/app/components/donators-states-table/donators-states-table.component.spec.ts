import { ComponentFixture, TestBed } from '@angular/core/testing';

import { DonatorsStatesTableComponent } from './donators-states-table.component';

describe('DonatorsStatesTableComponent', () => {
  let component: DonatorsStatesTableComponent;
  let fixture: ComponentFixture<DonatorsStatesTableComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [DonatorsStatesTableComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(DonatorsStatesTableComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
