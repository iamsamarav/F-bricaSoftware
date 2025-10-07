export class Conta {

  constructor(
    public id: number = 0,
    public agencia: number = 0,
    public cliente: number = 0,
    public admin: string = '',
    public numero: number = 0,
    public tipo: string = '',
    public saldo: number = 0,
    public dataAbertura: string = '',
    public dataEncerramento: string = '',
    public dataUltimoAcesso: string = '',
    public situacao: string = '',
    public transacoes: string[] = [],
    public chavesPix: string[] = [],
    public extrato: string[] = []
  ) { };
}
