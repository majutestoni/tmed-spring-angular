import { Component, Input, OnInit, ViewEncapsulation } from '@angular/core';
import { Subject } from 'rxjs';
import { HomeService } from '../home.service';

@Component({
  selector: 'app-doctors',
  templateUrl: './doctors.component.html',
  styleUrls: ['./doctors.component.scss'],
  encapsulation: ViewEncapsulation.None,
})


export class DoctorsComponent implements OnInit {
  public doctors: Doctor[] = [];
  displayedColumns: string[] = ['name', 'email', 'specialty', 'options'];
  @Input() reloadt: Subject<boolean> = new Subject<boolean>();
  public openDoctor = false;
  public totalPages = 0;


  constructor(private homeService: HomeService) {}

  ngOnInit(): void {
    this.homeService.getDoctors().subscribe((res) => {
      this.doctors = res.content;
      this.totalPages = res.totalPages;
    });
    this.reloadt.subscribe((res) => {
      if (res) {
        this.ngOnInit();
      }
    });
  }

  changePage(event: any) {
    this.homeService
      .getDoctors(event.pageSize, event.pageIndex)
      .subscribe((res) => {
        this.doctors = res.content;
        this.totalPages = res.totalPages;
      });
  }

  public excluir() {
    this.openDoctor = true;
  }

  desactiveDoctor(id: number) {
    this.homeService.desactiveDoctor(id).subscribe((res) => {
      this.ngOnInit();
      this.openDoctor = false;
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
