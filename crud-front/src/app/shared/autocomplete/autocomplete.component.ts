import {
  Component,
  ElementRef,
  EventEmitter,
  HostListener,
  Input,
  OnChanges,
  OnInit,
  Output,
  SimpleChanges,
} from '@angular/core';
import { FormBuilder, FormControl, FormControlName } from '@angular/forms';
import { Observable } from 'rxjs';
import { debounceTime, distinctUntilChanged, map } from 'rxjs/operators';

@Component({
  selector: 'app-autocomplete',
  templateUrl: './autocomplete.component.html',
  styleUrls: ['./autocomplete.component.scss'],
})
export class AutocompleteComponent implements OnInit, OnChanges {
  @Input() public list: string[] = [];
  public listPesquisa = [];
  public input = new FormControl();
  @Input() control = '';
  public filtro$: Observable<any> | undefined;
  public isSearch = false;
  public hide = false;
  @Input() public placeholde = '';
  @Input() public value = '';
  @Input() public label = '';

  constructor(private fb: FormBuilder, private elementRef: ElementRef) {}

  ngOnChanges(): void {
    this.changeHide();
  }

  ngOnInit(): void {
    this.filtro$ = this.input.valueChanges.pipe(
      debounceTime(100),
      map((value) => value.trim()),
      distinctUntilChanged(),
      map((res) => this.searchValues(res))
    );
  }

  changeHide() {
    this.hide = !this.hide;
  }

  selectOption(item: any) {
    this.placeholde = item;
    console.log(this.placeholde);
  }

  searchValues(searchTerm: string) {
    console.log('a');
    return this.list.filter(
      (el) =>
        el.toLocaleLowerCase().search(searchTerm.toLocaleLowerCase()) !== -1
    );
  }
}
