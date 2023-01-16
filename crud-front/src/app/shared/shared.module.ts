import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { AppMaterialModule } from './app-material/app-material.module';
import { ModalFormlModule } from './modal-form/modal-form-module';
import { AutocompleteComponent } from './autocomplete/autocomplete.component';

@NgModule({
  imports: [CommonModule, ModalFormlModule, AppMaterialModule],
  exports: [AppMaterialModule, ModalFormlModule, AutocompleteComponent],
  declarations: [AutocompleteComponent],
})
export class SharedModule {}
