import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { AppointmentComponent } from './appointment.component';
import { AppointmentRoutingModule } from './appointment-routing.module';
import { SharedModule } from 'src/app/shared/shared.module';
import { AppointmentService } from './appointment.service';

@NgModule({
  declarations: [AppointmentComponent],
  providers: [AppointmentService],
  imports: [CommonModule, AppointmentRoutingModule, SharedModule],
})
export class AppointmentModule {}
