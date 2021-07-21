import { Injectable } from '@angular/core';
import { HttpClient, HttpResponse } from '@angular/common/http';
import { Observable } from 'rxjs';
import { map, shareReplay } from 'rxjs/operators';
import { SERVER_API_URL } from 'app/app.constants';
import { createRequestOption, Pagination } from 'app/shared/util/request-util';

import { Turno } from './model/Turno.model';
import { Horario } from '../reserva/model/Horario.model';

@Injectable({ providedIn: 'root' })
export class HorarioService {
  public resourceUrl = SERVER_API_URL + '/horarios';

  constructor(private http: HttpClient) {}

  create(turno: Turno): Observable<Turno> {
    return this.http.post<Turno>(this.resourceUrl, turno);
  }

  update(turno: Turno): Observable<Turno> {
    return this.http.put<Turno>(this.resourceUrl, turno);
  }

  query(req?: Pagination): Observable<HttpResponse<Turno[]>> {
    const options = createRequestOption(req);
    return this.http.get<Turno[]>(this.resourceUrl, { params: options, observe: 'response' });
  }

  consultarhorarios(idSucursal: string): Observable<Horario[]> {
    return this.http.get<Horario[]>(`${this.resourceUrl}/consultarPorSucursal/${idSucursal}`);
  }
}
