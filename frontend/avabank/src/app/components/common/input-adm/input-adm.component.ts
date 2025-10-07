import { CommonModule } from '@angular/common';
import { Component, Input } from '@angular/core';

@Component({
  selector: 'app-input-adm',
  imports: [CommonModule],
  templateUrl: './input-adm.component.html',
  styleUrl: './input-adm.component.css',
})
export class InputAdmComponent {

  @Input() label: string="";
  @Input() type: string="text";
  @Input() placeholder: string="";
  @Input() name: string="";
  // @Input() model: any;
  
}
