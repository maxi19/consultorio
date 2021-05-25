import { Routes } from '@angular/router';

import { ReservaListComponent } from './list/reserva-list/reserva-list.component';

export const reservaRoute: Routes = [
  {
    path: '',
    component: ReservaListComponent,
    data: {
      defaultSort: 'id,asc',
    },
  },
];
