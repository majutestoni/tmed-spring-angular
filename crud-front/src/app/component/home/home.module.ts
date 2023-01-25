import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { HomeComponent } from './home.component';
import { HomeRoutingModule } from './home-routing.module';
import { PatientsComponent } from './patients/patients.component';
import { HttpClient, HttpClientModule } from '@angular/common/http';
import { HomeService } from './home.service';
import { SharedModule } from 'src/app/shared/shared.module';
import { DoctorsComponent } from './doctors/doctors.component';
import { TranslateLoader, TranslateModule } from '@ngx-translate/core';
import { TranslateHttpLoader } from '@ngx-translate/http-loader';

@NgModule({
    declarations: [HomeComponent, PatientsComponent, DoctorsComponent],
    providers: [HomeService],
    exports: [HomeComponent, PatientsComponent],
    imports: [CommonModule, HomeRoutingModule, HttpClientModule, SharedModule, TranslateModule.forRoot({
      loader: {
        provide: TranslateLoader,
        useFactory: HttpLoaderFactory,
        deps: [HttpClient]
      }
    })

    ]
})
export class HomeModule {}

export function HttpLoaderFactory(http: HttpClient) {
  return new TranslateHttpLoader(http, './assets/', '.json');
  }
