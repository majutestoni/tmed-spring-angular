import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { HomeComponent } from './home.component';
import { HomeRoutingModule } from './home.-routing.module';
import { PatientsComponent } from './patients/patients.component';
import { HttpClientModule } from '@angular/common/http';
import { HomeService } from './home.service';
import { SharedModule } from 'src/app/shared/shared.module';

@NgModule({
  declarations: [HomeComponent, PatientsComponent],
  imports: [CommonModule, HomeRoutingModule, HttpClientModule, SharedModule],
  providers: [HomeService],
  exports: [HomeComponent, PatientsComponent],
})
export class HomeModule {}
