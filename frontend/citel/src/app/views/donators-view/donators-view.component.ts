import { DonatorsService } from './../../services/donators.service';
import { Component } from '@angular/core';
import { toSignal } from '@angular/core/rxjs-interop';
import { HeaderComponent } from '../../components/header-component/header.component';
import { DonatorsStatesTableComponent } from '../../components/donators-states-table/donators-states-table.component';
import { CommonModule } from '@angular/common';
import { HttpClientModule } from '@angular/common/http';
import { DonatorFiltersComponent } from '../../components/donator-filters/donator-filters.component';

@Component({
  selector: 'app-donators-view',
  standalone: true,
  imports: [
    CommonModule,
    HeaderComponent,
    DonatorsStatesTableComponent,
    HttpClientModule,
    DonatorFiltersComponent
  ],
  providers: [
    DonatorsService,
  ],
  templateUrl: './donators-view.component.html',
  styleUrl: './donators-view.component.less'
})
export class DonatorsViewComponent {
  constructor(private donatorsService: DonatorsService) { }

  ngOnInit(): void {
    this.receiveDonatorsPerState()
  }

  public receiveDonatorsPerState = toSignal(this.donatorsService.getDonatorsPerState())
}
