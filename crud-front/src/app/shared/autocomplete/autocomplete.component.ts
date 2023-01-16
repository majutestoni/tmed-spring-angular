import { Component, OnChanges, OnInit, SimpleChanges } from '@angular/core';
import { FormBuilder, FormControl } from '@angular/forms';
import { Observable } from 'rxjs';
import { debounceTime, distinctUntilChanged, map } from 'rxjs/operators';

@Component({
  selector: 'app-autocomplete',
  templateUrl: './autocomplete.component.html',
  styleUrls: ['./autocomplete.component.scss'],
})
export class AutocompleteComponent implements OnInit, OnChanges {
  public list: string[] = [
    'nome',
    'sobrenome',
    'nome do meio',
    'apelido',
    'name',
    'diminutivo',
    'parecido',
  ];
  public listPesquisa = [];
  public input = new FormControl();
  public filtro$: Observable<any> | undefined;
  public isSearch = false;
  public hide = false;


  constructor(private fb: FormBuilder) {}

  ngOnChanges(): void {
    this.changeHide()
  }

  ngOnInit(): void {
    this.filtro$ = this.input.valueChanges.pipe(
      debounceTime(100),
      map((value) => value.trim()),
      distinctUntilChanged(),
      map((res) => this.searchValues(res))
    );
  }

  changeHide(){
    this.hide
    ? this.hide = false
    : this.hide = true
  }

  searchValues(searchTerm: string) {
    console.log('a');
    return this.list.filter(
      (el) =>
        el.toLocaleLowerCase().search(searchTerm.toLocaleLowerCase()) !== -1
    );
  }
}
