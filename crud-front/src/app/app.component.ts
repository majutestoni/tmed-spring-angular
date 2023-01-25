import { Component } from '@angular/core';
import { TranslateService } from '@ngx-translate/core';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss'],
})
export class AppComponent {

  constructor(private translate: TranslateService){
    translate.setDefaultLang('pt-BR');
    this.translate.addLangs(['en', 'pt-BR'])
    this.translate.setDefaultLang('pt-BR')
    const browserLang = this.translate.getBrowserLang()
    this.translate.use(browserLang.match(/pt-BR|en/) ? browserLang : 'pt-BR')
  }

  title = 'crud-front';
}
