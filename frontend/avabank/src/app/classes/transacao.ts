export class Transacao {

  constructor(
    public id: number = 0,
    public conta: string = '',
    public tipoTransacao: string = '',
    public valor: number = 0,
    public dataTransacao: string = '',
    public numeroProtocolo: string = '',
    public descricao: string = '',
    public chaveDestino: string = '',
    public tipoPix: string = '',
    public codigoBarras: string = '',
    public dataVencimento: string = '',
    public numeroConta: string = '',
    public agencia: string = ''
  ) { }
}
