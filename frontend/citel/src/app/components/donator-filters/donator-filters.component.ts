import { toSignal } from '@angular/core/rxjs-interop';
import { Component } from '@angular/core';
import { MatRadioButton, MatRadioGroup } from '@angular/material/radio';
import { MatSelectModule } from '@angular/material/select';
import { DonatorsService } from '../../services/donators.service';
import { HttpClientModule } from '@angular/common/http';

@Component({
  selector: 'app-donator-filters',
  standalone: true,
  imports: [
    MatRadioButton,
    MatRadioGroup,
    MatSelectModule,
    HttpClientModule
  ],
  providers: [
    DonatorsService,
  ],
  templateUrl: './donator-filters.component.html',
  styleUrl: './donator-filters.component.less'
})
export class DonatorFiltersComponent {
  constructor(private donatorsService: DonatorsService) { }

  // ngOnInit(): void {
  //   this.imcMedio();
  //   this.obesos();
  //   this.idadeMedia();
  //   this.qtdDoadores();
  // }

  selectedAge = '0-10';
  selectedType = 'A+';
  selectedReceiver = 'A+';
  imcMedio = '';
  // imcMedio = toSignal(this.donatorsService.getAvgImcAge());
  obesos = '';
  // obesos = toSignal(this.donatorsService.getObesesPerGender());
  idadeMedia = '';
  // idadeMedia = toSignal(this.donatorsService.getAvgAgePerType());
  qtdDoadores = '';
  // qtdDoadores = toSignal(this.donatorsService.getReceivers());
}
