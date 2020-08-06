import { ComponentFixture, TestBed } from '@angular/core/testing';
import { of } from 'rxjs';
import { HttpHeaders, HttpResponse } from '@angular/common/http';

import { ConsultorioTestModule } from '../../../test.module';
import { RangoComponent } from 'app/entities/rango/rango.component';
import { RangoService } from 'app/entities/rango/rango.service';
import { Rango } from 'app/shared/model/rango.model';

describe('Component Tests', () => {
  describe('Rango Management Component', () => {
    let comp: RangoComponent;
    let fixture: ComponentFixture<RangoComponent>;
    let service: RangoService;

    beforeEach(() => {
      TestBed.configureTestingModule({
        imports: [ConsultorioTestModule],
        declarations: [RangoComponent],
      })
        .overrideTemplate(RangoComponent, '')
        .compileComponents();

      fixture = TestBed.createComponent(RangoComponent);
      comp = fixture.componentInstance;
      service = fixture.debugElement.injector.get(RangoService);
    });

    it('Should call load all on init', () => {
      // GIVEN
      const headers = new HttpHeaders().append('link', 'link;link');
      spyOn(service, 'query').and.returnValue(
        of(
          new HttpResponse({
            body: [new Rango(123)],
            headers,
          })
        )
      );

      // WHEN
      comp.ngOnInit();

      // THEN
      expect(service.query).toHaveBeenCalled();
      expect(comp.rangos && comp.rangos[0]).toEqual(jasmine.objectContaining({ id: 123 }));
    });
  });
});
