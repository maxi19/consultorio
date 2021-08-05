import { Component, OnInit, Input } from '@angular/core';
import { NgbDateStruct } from '@ng-bootstrap/ng-bootstrap';
import { FormGroup } from '@angular/forms';

const now = new Date();

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

  minDate: NgbDateStruct = { year: now.getFullYear(), month: now.getMonth() + 1, day: now.getDate() + 1 };
}
