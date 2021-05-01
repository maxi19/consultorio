import { Injectable } from '@angular/core';
import { HttpClient, HttpResponse } from '@angular/common/http';
import { Observable } from 'rxjs';
import { map, shareReplay } from 'rxjs/operators';
import { SERVER_API_URL } from 'app/app.constants';
import { createRequestOption, Pagination } from 'app/shared/util/request-util';

import { Turno } from './Turno';
import { Horario } from './Horario';

@Injectable({ providedIn: 'root' })
export class HorarioService {
  public resourceUrl = SERVER_API_URL + 'externos/registrar';

  constructor(private http: HttpClient) {}

  create(turno: Turno): Observable<Turno> {
    return this.http.post<Turno>(this.resourceUrl, turno);
  }

  update(turno: Turno): Observable<Turno> {
    return this.http.put<Turno>(this.resourceUrl, turno);
  }

  /*buscarhorario(fecha: string): Observable<Map <Horario> > {
  //  return this.http.get<Turno>(`${this.resourceUrl}/${fecha}`);
    return this.http.get(this.resourceUrl +"/"+ fecha).pipe(
      
    )
  }
*/
  query(req?: Pagination): Observable<HttpResponse<Turno[]>> {
    const options = createRequestOption(req);
    return this.http.get<Turno[]>(this.resourceUrl, { params: options, observe: 'response' });
  }

  delete(login: string): Observable<{}> {
    return this.http.delete(`${this.resourceUrl}/${login}`);
  }

  authorities(): Observable<string[]> {
    return this.http.get<string[]>(SERVER_API_URL + 'api/users/authorities');
  }
}
