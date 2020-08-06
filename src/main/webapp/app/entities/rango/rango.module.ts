import { NgModule } from '@angular/core';
import { RouterModule } from '@angular/router';

import { ConsultorioSharedModule } from 'app/shared/shared.module';
import { RangoComponent } from './rango.component';
import { RangoDetailComponent } from './rango-detail.component';
import { RangoUpdateComponent } from './rango-update.component';
import { RangoDeleteDialogComponent } from './rango-delete-dialog.component';
import { rangoRoute } from './rango.route';

@NgModule({
  imports: [ConsultorioSharedModule, RouterModule.forChild(rangoRoute)],
  declarations: [RangoComponent, RangoDetailComponent, RangoUpdateComponent, RangoDeleteDialogComponent],
  entryComponents: [RangoDeleteDialogComponent],
})
export class ConsultorioRangoModule {}
