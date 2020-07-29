import { Component , Input, Output, EventEmitter} from '@angular/core';

import {NgbModal, ModalDismissReasons} from '@ng-bootstrap/ng-bootstrap';
import { Rango } from "../Rango";

@Component({
  selector: 'jhi-ngbd-modal-basic',
  templateUrl: './ngbd-modal-basic.component.html',
  styleUrls: ['./ngbd-modal-basic.component.scss']
})
export class NgbdModalBasicComponent  {


  @Input()  cerrarModal!: (parametro: any) => void ;
  @Input()  rangos !: Array<Rango>
  @Input()  fecha !: string
  @Output() salida : EventEmitter<Rango>= new EventEmitter();

  idRango !: string;


  constructor( ) {}

  emitirEvento(rango : Rango):void {
    this.salida.emit(rango);
  }


}
