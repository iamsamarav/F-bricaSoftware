import { Conta } from "./conta";
import { Endereco } from "./endereco";

export class Cliente {

  constructor(
    public id: number = 0,
    public cpf: string = '',
    public nome: string = '',
    public dataNascimento: Date = new Date(),
    public email: string = '',
    public telefone: string = '',
    public endereco: Endereco = new Endereco(),
    public senha: string = '',
    public conta: Conta = new Conta()
  ) { }
}
