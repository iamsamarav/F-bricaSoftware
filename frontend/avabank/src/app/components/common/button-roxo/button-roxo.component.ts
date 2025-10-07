import { CommonModule } from '@angular/common';
import { Component, Input } from '@angular/core';
import { RouterLink } from '@angular/router';

@Component({
  selector: 'app-button-roxo',
  imports: [CommonModule, RouterLink],
  templateUrl: './button-roxo.component.html',
  styleUrl: './button-roxo.component.css'
})
export class ButtonRoxoComponent {

  @Input() titulo: string="";
  @Input() router: string="";

}
