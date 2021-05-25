import { NgModule } from '@angular/core';
import { RouterModule } from '@angular/router';
import { reservaRoute } from './reserva-routing.module';
import { ConsultorioSharedModule } from 'app/shared/shared.module';
import { ReservaListComponent } from './list/reserva-list/reserva-list.component';
import { ReservaComponent } from './reserva.component';

@NgModule({
  imports: [ConsultorioSharedModule, RouterModule.forChild(reservaRoute)],
  declarations: [ReservaListComponent, ReservaComponent],
  entryComponents: [],
})
export class ReservaManagementModule {}
