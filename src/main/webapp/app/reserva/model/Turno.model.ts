import { AuditsModule } from 'app/admin/audits/audits.module';

export interface ITurno {
  id?: any;
  nombre?: string;
  apellido?: string;
  documento?: string;
  sucursal?: string;
  fechaTurno?: string;
  codigoHora?: string;
  horario?: string;
}

export class Turno implements ITurno {
  constructor(
    public id?: any,
    public nombre?: string,
    public apellido?: string,
    public documento?: string,
    public sucursal?: string,
    public fechaTurno?: string,
    public codigoHora?: string,
    public horario?: string
  ) {}
}
