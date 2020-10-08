import { Component, OnInit, ViewChild } from '@angular/core';
import { FormBuilder, FormGroup, FormControl, Validators, NgModel } from '@angular/forms';
import { NgbDateStruct, NgbCalendar, NgbDatepicker } from '@ng-bootstrap/ng-bootstrap';
import { NgbdModalBasicComponent } from "./ngbd-modal-basic/ngbd-modal-basic.component";
import { formatDate } from '@angular/common';
import { Turno } from './turno';
import { NgbModal } from "@ng-bootstrap/ng-bootstrap";
import { Rango } from './Rango';
import { ArrayType } from '@angular/compiler';
import {IRango} from "../shared/model/rango.model";
import { HttpResponse } from '@angular/common/http';
import {RangoService } from "../entities/rango/rango.service";




@Component({
  selector: 'jhi-reserva',
  templateUrl: './reserva.component.html',
  styleUrls: ['./reserva.component.scss'],
})


export class ReservaComponent implements OnInit {
  formulario!: FormGroup;
  miTurno!: Turno;
  rangoSeleccionado !: Rango;
  rangos?: IRango[];
  sucursales= [
  {
    id:"2",
    nombre:"Pablo Noguez"
  },
  {
    id:"1",
    nombre:"Grand Bourg"    
  }
]


  constructor(
    private formBuilder: FormBuilder,
    private calendar: NgbCalendar,
    private rangoService: RangoService,
    private ngbModalRef: NgbModal
    ) {}

  setearValoresDefault(): void {
    this.formulario.setValue({
      nombre: '',
      apellido: '',
      documento: '',
      sucursal:'',
      fecha: '',
      validate: false,
    });
  }

  creaarFormulario(): void {
    this.formulario = this.formBuilder.group({
      nombre: ['', [Validators.required, Validators.minLength(3), Validators.maxLength(30)]],
      apellido: ['', [Validators.required, Validators.minLength(3), Validators.maxLength(30)]],
      documento: ['', [Validators.pattern("^[0-9]*$"), Validators.required, Validators.minLength(6), Validators.maxLength(17)]],
      sucursal: ["seleccione", [ Validators.required]],
      fecha: ['', [  Validators.minLength(10),Validators.required]],
      validate:'',
    });
  }

  
  cargarRangos(): void {
    this.rangoService.query().subscribe((res: HttpResponse<IRango[]>) => (this.rangos = res.body || []));
  }

  ngOnInit(): void {
    this.creaarFormulario();
    this.setearValoresDefault();
  }

  abrirDialogo(): void {
   
    const opts = {
      windowClass:'myCustomModal'
    };

   const modalReffNgBots = this.ngbModalRef.open(NgbdModalBasicComponent,opts);
   
  const nombre = this.formulario.controls['nombre'].value;
  const apellido = this.formulario.controls['apellido'].value;
  const documento =  this.formulario.controls['documento'].value;
  const fecha = this.formulario.controls['fecha'].value;

  modalReffNgBots.componentInstance.rangos = this.rangos;
  modalReffNgBots.componentInstance.fecha = fecha;

  this.miTurno = new Turno(fecha, nombre, apellido, documento,this.rangoSeleccionado);

  modalReffNgBots.componentInstance.salida.subscribe((respusta: Rango) => {
    this.rangoSeleccionado = respusta;
    modalReffNgBots.close();
  });
  
   modalReffNgBots.componentInstance.cerrarModal = () => {
    modalReffNgBots.close();
   }

  }

  mostraarBootstrapModal():void{
   
  }
}


