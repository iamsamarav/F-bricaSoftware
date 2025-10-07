import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
//import { AdmLoginComponent } from '../admin/adm-login/adm-login.component';

@NgModule({
  declarations: [
  //  AdmLoginComponent
  ],
  imports: [
    CommonModule,
    FormsModule // Adicione o FormsModule aqui
  ],
  exports: [
   // AdmLoginComponent
  ]
})
export class AdminModule { }
