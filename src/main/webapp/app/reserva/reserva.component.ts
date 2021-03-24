import { Component, OnInit, ViewChild } from '@angular/core';
import { FormBuilder, FormGroup, FormControl, Validators, NgModel } from '@angular/forms';
import { NgbDateStruct, NgbCalendar, NgbDatepicker } from '@ng-bootstrap/ng-bootstrap';

import { formatDate } from '@angular/common';
import { Turno } from './turno';
import { NgbModal } from '@ng-bootstrap/ng-bootstrap';

import { ArrayType } from '@angular/compiler';
import { HttpResponse } from '@angular/common/http';

@Component({
  selector: 'jhi-reserva',
  templateUrl: './reserva.component.html',
  styleUrls: ['./reserva.component.scss'],
})
export class ReservaComponent implements OnInit {
  formulario!: FormGroup;
  miTurno!: Turno;

  constructor(private formBuilder: FormBuilder, private calendar: NgbCalendar, private ngbModalRef: NgbModal) {}

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
      sucursal: ['seleccione', [Validators.required]],
      fecha: ['', [Validators.minLength(10), Validators.required]],
      validate: '',
    });
  }

  ngOnInit(): void {
    this.creaarFormulario();
    this.setearValoresDefault();
  }
}
