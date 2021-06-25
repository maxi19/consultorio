import { Injectable } from '@angular/core';
import { HttpClient, HttpResponse } from '@angular/common/http';
import { Observable } from 'rxjs';
import { map, shareReplay } from 'rxjs/operators';
import { SERVER_API_URL } from 'app/app.constants';
import { createRequestOption, Pagination } from 'app/shared/util/request-util';
import { Fecha } from './Fecha';
import { Turno } from './model/Turno.model';

@Injectable({ providedIn: 'root' })
export class ReservaService {
  public resourceUrl = SERVER_API_URL + 'externos/reservas';

  public resourceInternalUrl = SERVER_API_URL + 'internos/reservas';

  constructor(private http: HttpClient) {}

  create(turno: Turno): Observable<Turno> {
    return this.http.post<Turno>(this.resourceUrl + '/registrar', turno);
  }

  update(turno: Turno): Observable<Turno> {
    return this.http.put<Turno>(this.resourceUrl, turno);
  }

  consultarfecha(fecha: string): Observable<Fecha> {
    return this.http.get<Fecha>(`${this.resourceUrl}consultarfecha/${fecha}`);
  }

  query(req?: Pagination): Observable<HttpResponse<Turno[]>> {
    const options = createRequestOption(req);
    return this.http.get<Turno[]>(this.resourceInternalUrl, { params: options, observe: 'response' });
  }

  delete(login: string): Observable<{}> {
    return this.http.delete(`${this.resourceUrl}/${login}`);
  }

  authorities(): Observable<string[]> {
    return this.http.get<string[]>(SERVER_API_URL + 'api/users/authorities');
  }

  find(id: string): Observable<Turno> {
    return this.http.get<Turno>(`${this.resourceUrl}/${id}`);
  }
}
