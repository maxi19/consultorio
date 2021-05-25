import { NgModule } from '@angular/core';
import { RouterModule } from '@angular/router';
import { reservaRoute } from './reserva-routing.module';
import { ConsultorioSharedModule } from 'app/shared/shared.module';

@NgModule({
  imports: [ConsultorioSharedModule, RouterModule.forChild(reservaRoute)],
  declarations: [],
  entryComponents: [],
})
export class ReservaManagementModule {}
