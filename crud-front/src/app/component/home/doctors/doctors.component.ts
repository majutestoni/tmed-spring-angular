import { Component, Input, OnInit } from '@angular/core';
import { Subject } from 'rxjs';
import { HomeService } from '../home.service';

@Component({
  selector: 'app-doctors',
  templateUrl: './doctors.component.html',
  styleUrls: ['./doctors.component.scss'],
})
export class DoctorsComponent implements OnInit {
  public doctors: Doctor[] = [];
  displayedColumns: string[] = ['name', 'email', 'specialty', 'options'];
  @Input() reloadt: Subject<boolean> = new Subject<boolean>();

  constructor(private homeService: HomeService) {}

  ngOnInit(): void {
    this.homeService.getDoctors().subscribe((res) => {
      this.doctors = res;
    });
    this.reloadt.subscribe((res) => {
      if (res) {
        this.ngOnInit();
      }
    });
  }

  desactiveDoctor(id: number) {
    this.homeService.desactiveDoctor(id).subscribe((res) => this.ngOnInit());
  }
}

export interface Doctor {
  id: number;
  name: string;
  email: string;
  crm: string;
  specialty: SpecialtyEnum;
}

export enum Specialty {
  ORTHOPEDIST,
  DERMATOLOGIST,
  CARDIOLOGIST,
  NEUROLOGIST,
}

export enum SpecialtyEnum {
  ORTHOPEDIST = 'ortopedista',
  DERMATOLOGIST = 'dermatologista',
  CARDIOLOGIST = 'cardiologista',
  NEUROLOGIST = 'neurologista',
}
