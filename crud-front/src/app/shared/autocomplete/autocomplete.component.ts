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
export class AutocompleteComponent implements OnInit {
  @Input() public options: string[] = [];
  @Input() public placeholde = '';
  @Input() public value = '';
  @Input() public label = '';
  @Output() public clicked = new EventEmitter();

  public listPesquisa = [];
  public input = new FormControl();
  public filtro$: Observable<any> | undefined;
  public isSearch = false;
  public hide = false;

  constructor(private fb: FormBuilder, private elementRef: ElementRef) {}

  @HostListener('document:click', ['$event'])
  closeItens(event: MouseEvent) {
    if (!this.elementRef.nativeElement.contains(event.target)) {
      if (this.hide) {
        this.hide = false;
      }
    }
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
    this.value = item;
    this.clicked.emit(item);
    this.hide = false;
  }

  searchValues(searchTerm: string) {
    return this.options.filter(
      (el) =>
        el.toLocaleLowerCase().search(searchTerm.toLocaleLowerCase()) !== -1
    );
  }
}
