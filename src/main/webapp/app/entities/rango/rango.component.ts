import { Component, OnInit, OnDestroy } from '@angular/core';
import { HttpResponse } from '@angular/common/http';
import { Subscription } from 'rxjs';
import { JhiEventManager } from 'ng-jhipster';
import { NgbModal } from '@ng-bootstrap/ng-bootstrap';

import { IRango } from 'app/shared/model/rango.model';
import { RangoService } from './rango.service';
import { RangoDeleteDialogComponent } from './rango-delete-dialog.component';

@Component({
  selector: 'jhi-rango',
  templateUrl: './rango.component.html',
})
export class RangoComponent implements OnInit, OnDestroy {
  rangos?: IRango[];
  eventSubscriber?: Subscription;

  constructor(protected rangoService: RangoService, protected eventManager: JhiEventManager, protected modalService: NgbModal) {}

  loadAll(): void {
    this.rangoService.query().subscribe((res: HttpResponse<IRango[]>) => (this.rangos = res.body || []));
  }

  ngOnInit(): void {
    this.loadAll();
    this.registerChangeInRangos();
  }

  ngOnDestroy(): void {
    if (this.eventSubscriber) {
      this.eventManager.destroy(this.eventSubscriber);
    }
  }

  trackId(index: number, item: IRango): number {
    // eslint-disable-next-line @typescript-eslint/no-unnecessary-type-assertion
    return item.id!;
  }

  registerChangeInRangos(): void {
    this.eventSubscriber = this.eventManager.subscribe('rangoListModification', () => this.loadAll());
  }

  delete(rango: IRango): void {
    const modalRef = this.modalService.open(RangoDeleteDialogComponent, { size: 'lg', backdrop: 'static' });
    modalRef.componentInstance.rango = rango;
  }
}
