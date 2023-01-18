import { Component, Input, OnInit } from '@angular/core';
import { Subject } from 'rxjs';
import { HomeService } from '../home.service';

@Component({
  selector: 'app-patients',
  templateUrl: './patients.component.html',
  styleUrls: ['./patients.component.scss'],
})
export class PatientsComponent implements OnInit {
  constructor(private homeService: HomeService) {}
  public patients: Patient[] = [];
  displayedColumns: string[] = ['name', 'email', 'phone', 'options'];
  @Input() reloadt: Subject<boolean> = new Subject<boolean>();
  public totalPages = 0;

  ngOnInit(): void {
    this.homeService.getPatients().subscribe((res) => {
      this.patients = res.content;
      this.totalPages = res.totalPages;
    });
    this.reloadt.subscribe((res) => {
      if (res) {
        this.ngOnInit();
      }
    });
  }

  deletePatient(id: number): void {
    this.homeService.deletePatient(id).subscribe((res) => this.ngOnInit());
  }

  changePage(event: any) {
    this.homeService
      .getPatients(event.pageSize, event.pageIndex)
      .subscribe((res) => {
        this.patients = res.content;
        this.totalPages = res.totalPages;
      });
  }
}

export interface Patient {
  id: number;
  name: string;
  email: string;
  phone: string;
}
