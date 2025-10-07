import { Routes } from '@angular/router';

// Start e Central de Ajuda
import { StartComponent } from './components/start/start.component';
import { CentralAjudaComponent } from './components/central-ajuda/central-ajuda.component';

// Area do administrador

import { AdmLoginComponent } from './components/adm/adm-login/adm-login.component';
import { AdmHomeComponent } from './components/adm/adm-home/adm-home.component';
import { AdmDetalhescontaComponent } from './components/adm/adm-detalhesconta/adm-detalhesconta.component';
import { AdmFormCadastroComponent } from './components/adm/adm-form-cadastro/adm-form-cadastro.component';

// Area do cliente "Home"
import { ClienteLoginComponent } from './components/cliente/cliente-login/cliente-login.component';
import { ClienteHomeComponent } from './components/cliente/cliente-home/cliente-home.component';
import { ClientePerfilComponent } from './components/cliente/cliente-perfil/cliente-perfil.component';
import { ClienteConfigComponent } from './components/cliente/cliente-config/cliente-config.component';
import { ClienteEsquecisenhaComponent } from './components/cliente/cliente-esquecisenha/cliente-esquecisenha.component';

// Tranferencia
import { ClienteTransferenciaComponent } from './components/cliente/cliente-transferencia/cliente-transferencia.component';
import { ClientePagcomprovanteComponent } from './components/cliente/cliente-pagcomprovante/cliente-pagcomprovante.component';

// Pix
import { ClientePixComponent } from './components/cliente/cliente-pix/cliente-pix.component';
import { ClientePixareaComponent } from './components/cliente/cliente-pixarea/cliente-pixarea.component';

// Deposito e Saque
import { ClienteDepositoComponent } from './components/cliente/cliente-deposito/cliente-deposito.component';
import { ClienteSacarComponent } from './components/cliente/cliente-sacar/cliente-sacar.component';
import { ClienteCartoesComponent } from './components/cliente/cliente-cartoes/cliente-cartoes.component';

// Investimentos
import { ClienteInvestComponent } from './components/cliente/cliente-invest/cliente-invest.component';
import { ClienteInvestcarteiraComponent } from './components/cliente/cliente-investcarteira/cliente-investcarteira.component';

// Errors
import { ClienteErrotransacaoComponent } from './components/cliente/cliente-errotransacao/cliente-errotransacao.component';
import { ClienteConfirmarPagComponent } from './components/cliente/cliente-confirmar-pag/cliente-confirmar-pag.component';

export const routes: Routes = [
  // Start e Central de Ajuda
  { path: 'start', component: StartComponent },
  { path: 'central-ajuda', component: CentralAjudaComponent },

  // Area do administrador
  { path: 'adm-login', component: AdmLoginComponent },
  { path: 'adm-home', component: AdmHomeComponent },
  { path: 'adm-detalhesconta', component: AdmDetalhescontaComponent },
  { path: 'adm-form-cadastro', component: AdmFormCadastroComponent },

  // Area do cliente "Home"
  { path: 'cliente-login', component: ClienteLoginComponent },
  { path: 'cliente-home', component: ClienteHomeComponent },
  { path: 'cliente-perfil', component: ClientePerfilComponent },
  { path: 'cliente-config', component: ClienteConfigComponent },
  { path: 'cliente-esquecisenha', component: ClienteEsquecisenhaComponent },

  // Tranferencia
  { path: 'cliente-transferencia', component: ClienteTransferenciaComponent },
  { path: 'cliente-pagcomprovante', component: ClientePagcomprovanteComponent },
  { path: 'cliente-confirmar-pag', component: ClienteConfirmarPagComponent },
  { path: 'cliente-errotransacao', component: ClienteErrotransacaoComponent },

  // Pix
  { path: 'cliente-pix', component: ClientePixComponent },
  { path: 'cliente-pixarea', component: ClientePixareaComponent },

  // Deposito e Saque
  { path: 'cliente-deposito', component: ClienteDepositoComponent },
  { path: 'cliente-sacar', component: ClienteSacarComponent },
  { path: 'cliente-cartoes', component: ClienteCartoesComponent },

  // Investimentos
  { path: 'cliente-invest', component: ClienteInvestComponent },
  { path: 'cliente-investcarteira', component: ClienteInvestcarteiraComponent },

  // Errors
  { path: 'cliente-errotransacao', component: ClienteErrotransacaoComponent },
];
