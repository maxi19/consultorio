import { Component, OnInit, ViewChild } from '@angular/core';
import { FormBuilder, FormGroup, FormControl, Validators, NgModel } from '@angular/forms';
import { NgbDateStruct, NgbCalendar, NgbDatepicker } from '@ng-bootstrap/ng-bootstrap';

import { formatDate } from '@angular/common';
import { Turno } from './turno';
import { NgbModal } from '@ng-bootstrap/ng-bootstrap';

import { ArrayType } from '@angular/compiler';
import { HttpResponse } from '@angular/common/http';
import { ReservaService } from './reserva.service';
import swal from 'sweetalert';
import { Fecha } from './Fecha';
import { pipe } from 'rxjs';

@Component({
  selector: 'jhi-reserva',
  templateUrl: './reserva.component.html',
  styleUrls: ['./reserva.component.scss'],
})
export class ReservaComponent implements OnInit {
  formulario!: FormGroup;
  miTurno!: Turno;
  fecha?: Fecha;
  fechaAconsultar?: string;
  constructor(
    private formBuilder: FormBuilder,
    private calendar: NgbCalendar,
    private ngbModalRef: NgbModal,
    public reservaService: ReservaService
  ) {}

  setearValoresDefault(): void {
    this.formulario.setValue({
      nombre: '',
      apellido: '',
      documento: '',
      sucursal: '',
      fecha: '',
      validate: false,
    });
  }

  creaarFormulario(): void {
    this.formulario = this.formBuilder.group({
      nombre: ['', [Validators.required, Validators.minLength(3), Validators.maxLength(30)]],
      apellido: ['', [Validators.required, Validators.minLength(3), Validators.maxLength(30)]],
      documento: ['', [Validators.pattern('^[0-9]*$'), Validators.required, Validators.minLength(6), Validators.maxLength(17)]],
      // sucursal: ['seleccione', [Validators.required]],
      fecha: ['', [Validators.minLength(10), Validators.required]],
      validate: '',
    });
  }

  ngOnInit(): void {
    this.creaarFormulario();
    this.setearValoresDefault();
  }

  generarReserva(): void {
    this.reservaService
      .create({
        nombre: this.formulario.get('nombre')!.value,
        apellido: this.formulario.get('apellido')!.value,
        documento: this.formulario.get('documento')!.value,
        sucursal: '1',
        fechaTurno: this.formulario.get('fecha')!.value,
        // codigoHora: 1,
      })
      .subscribe(respuesta => {
        swal('Se realizo la reserva con exito! ', 'Hace click en ok para descargar el turno!', 'success');
      });
  }

  consultarFecha(): void {
    this.reservaService.consultarfecha(this.formulario.get('fecha')?.value).subscribe(respuesta => {
      this.fecha = respuesta;
    });
  }
}
