import { Component, Input, OnInit, Output } from '@angular/core';
import { EventEmitter } from '@angular/core';

@Component({
  selector: 'app-autocomplete-item',
  templateUrl: './autocomplete-item.component.html',
  styleUrls: ['./autocomplete-item.component.scss'],
})
export class AutocompleteItemComponent implements OnInit {
  @Input() options: string[] = [];
  @Output() clicked = new EventEmitter();

  ngOnInit(): void {}

  changeClick(item: any) {
    this.clicked.emit(item);
  }
}
