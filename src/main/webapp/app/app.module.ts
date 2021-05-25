import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import './vendor';
import { ConsultorioSharedModule } from 'app/shared/shared.module';
import { ConsultorioCoreModule } from 'app/core/core.module';
import { ConsultorioAppRoutingModule } from './app-routing.module';
import { ConsultorioHomeModule } from './home/home.module';

// jhipster-needle-angular-add-module-import JHipster will add new module here
import { MainComponent } from './layouts/main/main.component';
import { NavbarComponent } from './layouts/navbar/navbar.component';
import { FooterComponent } from './layouts/footer/footer.component';
import { PageRibbonComponent } from './layouts/profiles/page-ribbon.component';
import { ErrorComponent } from './layouts/error/error.component';
import { ReservaManagementModule } from './reserva/reserva.module';
@NgModule({
  imports: [
    BrowserModule,
    ConsultorioSharedModule,
    ConsultorioCoreModule,
    ConsultorioHomeModule,
    // jhipster-needle-angular-add-module JHipster will add new module here
    ConsultorioAppRoutingModule,
    ReservaManagementModule,
  ],
  declarations: [MainComponent, NavbarComponent, ErrorComponent, PageRibbonComponent, FooterComponent],
  bootstrap: [MainComponent],
})
export class ConsultorioAppModule {}
