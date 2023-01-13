import { Component, OnInit, ViewChild } from '@angular/core';
import {
  AbstractControl,
  FormBuilder,
  FormControl,
  FormGroup,
  NgControl,
  Validators,
} from '@angular/forms';
import { MatDialog } from '@angular/material/dialog';
import { NgbModal } from '@ng-bootstrap/ng-bootstrap';
import { HomeService } from './home.service';
import { Patient } from './patients/patients.component';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.scss'],
})
export class HomeComponent implements OnInit {
  @ViewChild('modalNewPatient', { static: true }) modalNewPatient: any;

  public formCreatePatient!: FormGroup;

  constructor(
    private fb: FormBuilder,
    public dialog: MatDialog,
    private modal: NgbModal,
    private homeService: HomeService
  ) {}

  ngOnInit(): void {
    this.createForm();
  }

  public createPatient(): void {
    this.modal.open(this.modalNewPatient, { animation: true, size: 'lg' });
  }

  public closeModal(): void {
    this.modal.dismissAll();
  }

  public postPacient() {
    if (this.formCreatePatient.valid) {
      this.homeService
        .postPatient(this.formCreatePatient.value)
        .subscribe(res => this.formCreatePatient.reset());
    }
  }

  private createForm(): void {
    this.formCreatePatient = this.fb.group({
      name: ['', Validators.required],
      email: ['', [Validators.required, Validators.email]],
      phone: ['', Validators.required],
      address: this.fb.group({
        city: ['', Validators.required],
        uf: ['', Validators.required],
      }),
    });
  }

  get control() {
    return this.formCreatePatient.controls;
  }
}
