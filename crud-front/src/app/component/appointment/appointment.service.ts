import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { ServicesUrls } from 'src/app/@core/servicesUrls';

@Injectable({
  providedIn: 'root',
})
export class AppointmentService {
  constructor(private http: HttpClient) {}

  postAppointment(headers: RegisterAppointment) {
    return this.http.post(`${ServicesUrls.BACK_LOCAL}/appointment`, headers);
  }
}

export interface RegisterAppointment {
  doctortId: number;
  patientId: number;
}
