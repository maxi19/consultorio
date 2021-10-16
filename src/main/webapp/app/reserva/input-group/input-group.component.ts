import { Component, OnInit, Input } from '@angular/core';
import { FormGroup } from '@angular/forms';

@Component({
  selector: 'jhi-input-group',
  templateUrl: './input-group.component.html',
  styleUrls: ['./input-group.component.scss'],
})
export class InputGroupComponent {
  @Input() miParentForm!: FormGroup;
  @Input() labelValue!: string;
  @Input() idComponent!: string;
  @Input() labelFor!: string;
  @Input() miFormControlName!: string;
  @Input() plcHolder!: string;
  @Input() msgAlert!: string;
}
