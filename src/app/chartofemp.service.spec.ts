import { TestBed } from '@angular/core/testing';

import { ChartofempService } from './chartofemp.service';

describe('ChartofempService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: ChartofempService = TestBed.get(ChartofempService);
    expect(service).toBeTruthy();
  });
});
