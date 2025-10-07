import { Component } from '@angular/core';
import { InputComponent } from '../../common/input/input.component';
import { ButtonRoxoComponent } from '../../common/button-roxo/button-roxo.component';
import { ButtonVerdeComponent } from "../../common/button-verde/button-verde.component";
import { InputAdmComponent } from '../../common/input-adm/input-adm.component';

@Component({
  selector: 'app-adm-detalhesconta',
  imports: [ButtonVerdeComponent, InputAdmComponent],
  templateUrl: './adm-detalhesconta.component.html',
  styleUrl: './adm-detalhesconta.component.css'
})
export class AdmDetalhescontaComponent {

}
