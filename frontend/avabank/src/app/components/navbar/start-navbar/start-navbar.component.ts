import { transition, trigger, useAnimation } from '@angular/animations';
import { Component } from '@angular/core';
import { RouterLink } from '@angular/router';
import { fadeInUpAnimation } from '../../../services/site-animations.service';

@Component({
  selector: 'app-start-navbar',
  imports: [RouterLink],
  templateUrl: './start-navbar.component.html',
  styleUrl: './start-navbar.component.css',
  animations:[trigger('fadeInUp', [
    transition(':enter', useAnimation(fadeInUpAnimation))
])]
})
export class StartNavbarComponent {


}
