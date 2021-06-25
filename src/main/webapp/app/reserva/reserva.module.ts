import { NgModule } from '@angular/core';
import { RouterModule } from '@angular/router';
import { reservaRoute } from './reserva-routing.module';
import { ConsultorioSharedModule } from 'app/shared/shared.module';
import { ReservaListComponent } from './list/reserva-list/reserva-list.component';
import { ReservaComponent } from './reserva.component';
import { ReservaManagmentDetailComponent } from './detail/reserva-managment-detail/reserva-managment-detail.component';
import { ReservaManagmentUpdateComponent } from './edit/reserva-managment-update/reserva-managment-update.component';

@NgModule({
  imports: [ConsultorioSharedModule, RouterModule.forChild(reservaRoute)],
  declarations: [ReservaListComponent, ReservaComponent, ReservaManagmentDetailComponent, ReservaManagmentUpdateComponent],
  entryComponents: [],
})
export class ReservaManagementModule {}
