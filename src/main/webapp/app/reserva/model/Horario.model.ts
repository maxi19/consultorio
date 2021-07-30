interface IHorario {
  codigo?: string;
  descripcion?: string;
}

export class Horario implements IHorario {
  constructor(public codigo?: string, public descripcion?: string) {}
}
