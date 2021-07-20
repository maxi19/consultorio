import { Component, OnInit, Input } from '@angular/core';
import { NgbDateStruct } from '@ng-bootstrap/ng-bootstrap';
import { FormGroup } from '@angular/forms';

@Component({
  selector: 'jhi-datepicker',
  templateUrl: './datepicker.component.html',
  styleUrls: ['./datepicker.component.scss'],
})
export class DatepickerComponent {
  model!: NgbDateStruct;

  @Input() miParentForm!: FormGroup;
  @Input() miFormControlName!: string;
  @Input() miFormLabel!: string;
}
