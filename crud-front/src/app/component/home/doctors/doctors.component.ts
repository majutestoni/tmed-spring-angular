import { Component, OnInit } from '@angular/core';
import { HomeService } from '../home.service';

@Component({
  selector: 'app-doctors',
  templateUrl: './doctors.component.html',
  styleUrls: ['./doctors.component.scss'],
})
export class DoctorsComponent implements OnInit {
  public doctors: Doctor[] = [];
  displayedColumns: string[] = ['name', 'email', 'specialty', 'options'];

  constructor(private homeService: HomeService) {}

  ngOnInit(): void {
    this.homeService.getDoctors().subscribe((res) => {
      this.doctors = res;
    });
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
