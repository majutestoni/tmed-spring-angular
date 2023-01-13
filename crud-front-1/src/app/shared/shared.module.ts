import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { AppMaterialModule } from './app-material/app-material.module';
import { ModalFormlModule } from './modal-form/modal-form-module';

@NgModule({
  imports: [CommonModule],
  exports: [AppMaterialModule, ModalFormlModule],
})
export class SharedModule {}
