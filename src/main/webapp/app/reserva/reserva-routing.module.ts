import { Routes } from '@angular/router';

import { ReservaListComponent } from './list/reserva-list/reserva-list.component';
import { ReservaComponent } from './reserva.component';
export const reservaRoute: Routes = [
  {
    path: '',
    component: ReservaListComponent,
    data: {
      defaultSort: 'id,asc',
    },
  },
  {
    path: ':registrar/formulario',
    component: ReservaComponent,
  },
];
