import { TestBed } from '@angular/core/testing';

import { DonatorsService } from './donators.service';

describe('DonatorsStateService', () => {
  let service: DonatorsService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(DonatorsService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
