import { CommonModule } from '@angular/common';
import { Component, Input } from '@angular/core';

@Component({
  selector: 'app-button-verde',
  imports: [CommonModule],
  templateUrl: './button-verde.component.html',
  styleUrl: './button-verde.component.css'
})
export class ButtonVerdeComponent {

    @Input() titulo: string="";

}
