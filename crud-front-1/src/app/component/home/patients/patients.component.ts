import { Component, OnInit } from '@angular/core';
import { HomeService } from '../home.service';

@Component({
  selector: 'app-patients',
  templateUrl: './patients.component.html',
  styleUrls: ['./patients.component.scss'],
})
export class PatientsComponent implements OnInit {
  constructor(private homeService: HomeService) {}
  public patients: Patient[] = []
  displayedColumns: string[] = ['name', 'email', 'phone'];

  ngOnInit(): void {
    this.homeService.getPatients().subscribe((res) => this.patients = res);
    console.log(this.patients)
  }
}

export interface Patient{
  id: number
  name: string
  email: string
  phone: string
}
