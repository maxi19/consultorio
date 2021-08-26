import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { NgbCalendar } from '@ng-bootstrap/ng-bootstrap';
import { formatDate } from '@angular/common';
import { NgbModal } from '@ng-bootstrap/ng-bootstrap';
import swal from 'sweetalert';

import { ReservaService } from './reserva.service';
import { HorarioService } from './horarios.service';
import { Sucursal } from '../reserva/model/Sucursal.model';
import { Horario } from '../reserva/model/Horario.model';
import { Fecha } from './Fecha';

@Component({
  selector: 'jhi-reserva',
  templateUrl: './reserva.component.html',
  styleUrls: ['./reserva.component.scss'],
})
export class ReservaComponent implements OnInit {
  formulario!: FormGroup;
  fecha?: Fecha;
  fechaAconsultar?: string;
  mostrarHorarios?: boolean;
  horarios?: Horario[];

  sucursales: Sucursal[] = [
    {
      id: '1',
      nombre: 'Grand Bourg',
    },
    {
      id: '2',
      nombre: 'Pablo Nogues',
    },
  ];

  constructor(
    private formBuilder: FormBuilder,
    private calendar: NgbCalendar,
    private ngbModalRef: NgbModal,
    public reservaService: ReservaService,
    private horarioService: HorarioService
  ) {
    this.mostrarHorarios = false;
  }

  setearValoresDefault(): void {
    this.formulario.setValue({
      nombre: '',
      apellido: '',
      documento: '',
      telefono: '',
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
      telefono: ['', [Validators.pattern('^[0-9]*$'), Validators.required, Validators.minLength(6), Validators.maxLength(17)]],
      sucursal: ['', [Validators.required, Validators.maxLength(1)]],
      fecha: ['', [Validators.minLength(10), Validators.required]],
      validate: '',
    });
  }

  ngOnInit(): void {
    this.creaarFormulario();
    this.setearValoresDefault();
  }

  generarReserva(horario: Horario): void {
    this.reservaService
      .create({
        nombre: this.formulario.get('nombre')!.value,
        apellido: this.formulario.get('apellido')!.value,
        documento: this.formulario.get('documento')!.value,
        telefono: this.formulario.get('telefono')!.value,
        sucursal: this.formulario.get('sucursal')!.value,
        fechaTurno: formatDate(this.formulario.get('fecha')!.value, 'yyyy-MM-dd', 'en-US'),
        codigoHora: horario.codigo,
        horario: horario.codigo,
      })
      .subscribe(
        respuesta => {
          swal('Se realizo la reserva con exito! ', 'Hace click en ok para descargar el turno!', 'success');
        },
        error => {
          swal({
            title: 'Se produjo un error en el servicio!',
            text: 'ese horario ya esta reservado!',
            icon: 'error',
          });
        }
      );
  }

  consultarFecha(): void {
    this.reservaService.consultarfecha(this.formulario.get('fecha')?.value).subscribe(respuesta => {
      this.fecha = respuesta;
    });
  }

  sucursalSeleccionada(sucursal: Sucursal): void {
    if (sucursal != null) {
      this.formulario.controls['sucursal'].setValue(sucursal.id);
      this.calendar.getWeekday;
      this.mostrarHorarios = true;
      this.cargarHorarios(sucursal.id);
    }
  }

  cargarHorarios(id: string): void {
    this.horarioService.consultarhorarios(id).subscribe(
      resp => {
        this.horarios = resp;
      },
      error => {
        swal({
          title: 'Se produjo un error en el servicio!',
          text: 'Error en el servicio, intentelo mas tarde!',
          icon: 'error',
        });
      }
    );
  }
}
