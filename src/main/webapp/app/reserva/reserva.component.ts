import { Component, OnInit, ViewChild } from '@angular/core';
import { FormBuilder, FormGroup, FormControl, Validators, NgModel } from '@angular/forms';
import { NgbDateStruct, NgbCalendar, NgbDatepicker } from '@ng-bootstrap/ng-bootstrap';
import { NgbdModalBasicComponent } from "./ngbd-modal-basic/ngbd-modal-basic.component";
import { formatDate } from '@angular/common';
import { Turno } from './turno';
import { NgbModal } from "@ng-bootstrap/ng-bootstrap";
import { Rango } from './Rango';
import { ArrayType } from '@angular/compiler';

@Component({
  selector: 'jhi-reserva',
  templateUrl: './reserva.component.html',
  styleUrls: ['./reserva.component.scss'],
})
export class ReservaComponent implements OnInit {
  formulario!: FormGroup;
  miTurno!: Turno;
  rangoSeleccionado !: Rango;
  constructor(
    private formBuilder: FormBuilder,
    private calendar: NgbCalendar,
    private ngbModalRef: NgbModal
    ) {}

  setearValoresDefault(): void {
    this.formulario.setValue({
      nombre: '',
      apellido: '',
      documento: '',
      fecha: new Date(),
      validate: false,
    });
  }

  creaarFormulario(): void {
    this.formulario = this.formBuilder.group({
      nombre: ['sarasa', [Validators.required, Validators.minLength(3), Validators.maxLength(20)]],
      apellido: ['', [Validators.required, Validators.minLength(3), Validators.maxLength(13)]],
      documento: ['', [Validators.required, Validators.minLength(6), Validators.maxLength(13)]],
      fecha: ['', [Validators.required]],
      validate: '',
    });
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
   
   const listaDeRangos:Array<Rango> = [
    {id: '1', value: 'Sentence 1'},
    {id: '2', value: 'Sentence 2'},
    {id: '3', value: 'Sentence 3'},
    {id: '4', value: 'Sentence 4'},
    ];
  const nombre = this.formulario.controls['nombre'].value;
  const apellido = this.formulario.controls['apellido'].value;
  const documento =  this.formulario.controls['documento'].value;
  const fecha = this.formulario.controls['fecha'].value;

  modalReffNgBots.componentInstance.rangos = listaDeRangos;
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
