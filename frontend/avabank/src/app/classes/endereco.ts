export class Endereco {

  constructor(
    public cep: string = '',
    public logradouro: string = '',
    public complemento: string = '',
    public bairro = '',
    public cidade: string = '',
    public uf: string = '',
    public estado: string = ''
  ) { }
}
