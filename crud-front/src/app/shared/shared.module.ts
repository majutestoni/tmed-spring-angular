import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { AppMaterialModule } from './app-material/app-material.module';
import { ModalFormlModule } from './modal-form/modal-form-module';
import { AutocompleteComponent } from './autocomplete/autocomplete.component';
import { MessageModalComponent } from './message-modal/message-modal.component';
import { AutocompleteItemComponent } from './autocomplete/autocomplete-item/autocomplete-item.component';

@NgModule({
  imports: [CommonModule, ModalFormlModule, AppMaterialModule],
  exports: [AppMaterialModule, ModalFormlModule, AutocompleteComponent, MessageModalComponent],
  declarations: [AutocompleteComponent, MessageModalComponent, AutocompleteItemComponent],
})
export class SharedModule {}
