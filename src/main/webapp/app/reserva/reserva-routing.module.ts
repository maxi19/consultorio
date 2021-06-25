import { Routes, Resolve, ActivatedRouteSnapshot } from '@angular/router';
import { Injectable } from '@angular/core';
import { Observable, of } from 'rxjs';
import { ReservaListComponent } from './list/reserva-list/reserva-list.component';
import { ReservaComponent } from './reserva.component';
import { ITurno, Turno } from '../reserva/model/Turno.model';
import { ReservaService } from '../reserva/reserva.service';
import { ReservaManagmentUpdateComponent } from '../reserva/edit/reserva-managment-update/reserva-managment-update.component';
import { ReservaManagmentDetailComponent } from '../reserva/detail/reserva-managment-detail/reserva-managment-detail.component';

@Injectable({ providedIn: 'root' })
export class ReservaResolve implements Resolve<ITurno> {
  constructor(private service: ReservaService) {}

  resolve(route: ActivatedRouteSnapshot): Observable<ITurno> {
    const id = route.params['login'];
    if (id) {
      return this.service.find(id);
    }
    return of(new Turno());
  }
}

export const reservaRoute: Routes = [
  {
    path: '',
    component: ReservaListComponent,
    data: {
      defaultSort: 'id,asc',
    },
  },
  {
    path: ':login/view',
    component: ReservaManagmentDetailComponent,
    resolve: {
      user: ReservaResolve,
    },
  },
  {
    path: 'new',
    component: ReservaManagmentUpdateComponent,
    resolve: {
      user: ReservaResolve,
    },
  },
  {
    path: ':login/edit',
    component: ReservaManagmentUpdateComponent,
    resolve: {
      user: ReservaResolve,
    },
  },
  {
    path: ':registrar/formulario',
    component: ReservaComponent,
  },
];
