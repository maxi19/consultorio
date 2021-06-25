import { Component, OnInit } from '@angular/core';
import { FormBuilder, Validators } from '@angular/forms';
import { ActivatedRoute } from '@angular/router';

import { Turno } from '../../model/Turno.model';

@Component({
  selector: 'jhi-reserva-managment-update',
  templateUrl: './reserva-managment-update.component.html',
  styleUrls: ['./reserva-managment-update.component.scss'],
})
export class ReservaManagmentUpdateComponent implements OnInit {
  turno!: Turno;
  isSaving = false;

  editForm = this.fb.group({
    id: [],
    nombre: ['', [Validators.maxLength(50)]],
    apellido: ['', [Validators.maxLength(50)]],
    documento: ['', [Validators.minLength(5), Validators.maxLength(254)]],
    sucursal: [],
    fecha: [],
    codigoHora: [],
  });

  constructor(private route: ActivatedRoute, private fb: FormBuilder) {}

  ngOnInit(): void {
    this.route.data.subscribe(({ turno }) => {
      if (turno) {
        this.turno = turno;
        this.updateForm(turno);
      }
    });
  }

  private updateForm(turno: Turno): void {
    this.editForm.patchValue({
      id: turno.id,
      nombre: turno.nombre,
      apellido: turno.apellido,
      documento: turno.documento,
      sucursal: turno.sucursal,
      fechaTurno: turno.fechaTurno,
      codigoHora: turno.codigoHora,
    });
  }
}
