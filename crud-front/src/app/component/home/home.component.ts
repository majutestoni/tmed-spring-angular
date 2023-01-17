import { Component, OnInit, ViewChild } from '@angular/core';
import {
  FormBuilder,
  FormControl,
  FormGroup,
  Validators,
} from '@angular/forms';
import { MatDialog } from '@angular/material/dialog';
import { NgbModal } from '@ng-bootstrap/ng-bootstrap';
import { Observable, Subject } from 'rxjs';
import { debounceTime, distinctUntilChanged, map, tap } from 'rxjs/operators';
import { Specialty } from './doctors/doctors.component';
import { HomeService } from './home.service';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.scss'],
})
export class HomeComponent implements OnInit {
  @ViewChild('modalNewPatient', { static: true }) modalNewPatient: any;
  @ViewChild('modalNewDoctor', { static: true }) modalNewDoctor: any;

  public formCreatePatient!: FormGroup;
  public formCreateDoctor!: FormGroup;
  public reloadPatient: Subject<boolean> = new Subject<boolean>();
  public reloadDoctor: Subject<boolean> = new Subject<boolean>();

  public options = [
    'ORTHOPEDIST',
    'DERMATOLOGIST',
    'CARDIOLOGIST',
    'NEUROLOGIST',
  ];

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

  public createDoctor(): void {
    this.modal.open(this.modalNewDoctor, { animation: true, size: 'lg' });
  }

  public closeModal(): void {
    this.modal.dismissAll();
  }

  public postPacient() {
    if (this.formCreatePatient.valid) {
      this.homeService
        .postPatient(this.formCreatePatient.value)
        .subscribe((res) => {
          this.formCreatePatient.reset();
          this.reloadPatient.next(true);
        });
    }
  }

  public postDoctor() {
    if (this.formCreateDoctor.valid) {
      this.homeService
        .postDoctor(this.formCreateDoctor.value)
        .subscribe((res) => {
          this.formCreateDoctor.reset();
          this.reloadDoctor.next(true);
        });
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

    this.formCreateDoctor = this.fb.group({
      name: ['', Validators.required],
      email: ['', [Validators.required, Validators.email]],
      crm: ['', Validators.required],
      specialty: ['', Validators.required],
    });
  }

  get control() {
    return this.formCreatePatient.controls;
  }
}
