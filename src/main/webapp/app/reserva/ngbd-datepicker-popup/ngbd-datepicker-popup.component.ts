import { Component, OnInit, Input } from '@angular/core';
import {NgbDateStruct} from '@ng-bootstrap/ng-bootstrap';
import { FormGroup } from '@angular/forms';

@Component({
  selector: 'jhi-ngbd-datepicker-popup',
  templateUrl: './ngbd-datepicker-popup.component.html',
})
export class NgbdDatepickerPopupComponent {  
  model!: NgbDateStruct;

  @Input() parentForm !: FormGroup;
  @Input() formControlName !: string;
  @Input() formLabel !: string;

}
