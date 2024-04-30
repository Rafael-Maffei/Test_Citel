import { Component, Input } from '@angular/core';
import { DonatorsPerStateModel } from '../../models/donators-states-model';
import { CommonModule } from '@angular/common';
import {MatPaginatorModule} from '@angular/material/paginator';

@Component({
  selector: 'app-donators-states-table',
  standalone: true,
  imports: [
    CommonModule,
    MatPaginatorModule,    
  ],
  templateUrl: './donators-states-table.component.html',
  styleUrl: './donators-states-table.component.less'
})
export class DonatorsStatesTableComponent {
  @Input() list: DonatorsPerStateModel[]
}
