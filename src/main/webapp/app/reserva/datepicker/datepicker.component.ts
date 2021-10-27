import { Component, OnInit, Input } from '@angular/core';
import { NgbDateStruct, NgbDatepickerConfig } from '@ng-bootstrap/ng-bootstrap';
import { FormGroup } from '@angular/forms';

const now = new Date();

@Component({
  selector: 'jhi-datepicker',
  templateUrl: './datepicker.component.html',
  styleUrls: ['./datepicker.component.scss'],
})
export class DatepickerComponent {
  @Input() miParentForm!: FormGroup;
  @Input() miFormControlName!: string;
  @Input() miFormLabel!: string;
  @Input() disabledDaysItem!: number[];

  diasNoDisponibles!: number[];

  constructor(ngbDatepicker: NgbDatepickerConfig) {
    const s = new Date();
    ngbDatepicker.minDate = { year: s.getFullYear(), month: s.getMonth(), day: s.getDay() + 1 };

    ngbDatepicker.markDisabled = (date: NgbDateStruct) => {
      const d = new Date(date.year, date.month - 1, date.day);
      if (this.disabledDaysItem.includes(d.getDay())) {
        return true;
      }
      return false;
    };
  }
}
