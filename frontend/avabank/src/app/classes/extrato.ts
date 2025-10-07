export class Extrato {

  constructor(
    public id: number = 0,
    public conta: number = 0,
    public cliente: string = '',
    public transacao: string = '',
    public tipoTransacao: string = '',
    public descricao: string = '',
    public dataTransacao: string = '',
    public saldoAnterior: number = 0,
    public valor: number = 0,
    public saldoPosterior: number = 0
  ) { }
}
