import { Component, OnInit } from '@angular/core';
import {
  FormBuilder,
  FormControl,
  FormGroup,
  Validators,
} from '@angular/forms';

@Component({
  selector: 'app-appointment',
  templateUrl: './appointment.component.html',
  styleUrls: ['./appointment.component.scss'],
})
export class AppointmentComponent implements OnInit {
  choosePatient!: FormGroup;
  chooseDoctor!: FormGroup;
  chooseTime!: FormGroup;

  constructor(private fb: FormBuilder) {}

  ngOnInit(): void {
    this.createForms();
  }

  createForms() {
    this.choosePatient = this.fb.group({
      name: ['', Validators.required],
      id: [''],
    });

    this.chooseDoctor = this.fb.group({
      name: [''],
      id: [''],
    });

    this.chooseTime = this.fb.group({
      dateA: [''],
      timeA: [''],
    });
  }

  teste() {
    console.log(this.chooseDoctor.value);
    console.log(this.choosePatient.value);
  }
}
