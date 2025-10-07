export class Admin {
  constructor(
    public id: number = 0,
    public nome: string = '',
    public username: string = '',
    public senha: string = '',
    public contas: string[] = []
  ) {}
}
