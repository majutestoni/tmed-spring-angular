import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { ServicesUrls } from 'src/app/@core/servicesUrls';
import { map, pluck, tap } from 'rxjs/operators';
import { Patient } from './patients/patients.component';
import { Doctor, Specialty } from './doctors/doctors.component';

@Injectable({
  providedIn: 'root',
})
export class HomeService {
  constructor(private http: HttpClient) {}

  getPatients(): Observable<any> {
    return this.http
      .get<Patient>(`${ServicesUrls.BACK_LOCAL}/patient`)
      .pipe(pluck('content'));
  }

  getDoctors(): Observable<any> {
    return this.http
      .get<Doctor>(`${ServicesUrls.BACK_LOCAL}/doctor`)
      .pipe(pluck('content'));
  }

  postPatient(headers: CreatePatient): Observable<any> {
    return this.http.post(`${ServicesUrls.BACK_LOCAL}/patient`, headers);
  }

  postDoctor(headers: CreateDoctor): Observable<any>{
    return this.http.post(`${ServicesUrls.BACK_LOCAL}/doctor`, headers);
  }

  deletePatient(headers: number): Observable<any> {
    return this.http.delete(`${ServicesUrls.BACK_LOCAL}/patient/${headers}`);
  }
}

export interface CreatePatient {
  name: string;
  email: string;
  phone: string;
  address: CreateAddress;
}

export interface CreateAddress {
  city: string;
  uf: string;
}

export interface CreateDoctor{
  name: string
  email: string
  crm: string
  specialty: Specialty
}
