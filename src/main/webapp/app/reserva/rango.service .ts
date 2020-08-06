import { Injectable } from '@angular/core';
import { HttpClient, HttpResponse } from '@angular/common/http';
import { Observable } from 'rxjs';

import { SERVER_API_URL } from 'app/app.constants';
import { createRequestOption, Pagination } from 'app/shared/util/request-util';

import { Rango } from "./Rango";

@Injectable({ providedIn: 'root' })
export class reservaService {
  public resourceUrl = SERVER_API_URL + 'api/rango';

  constructor(private http: HttpClient) {}

  create(turno: Rango): Observable<Rango> {
    return this.http.post<Rango>(this.resourceUrl, turno);
  }

  update(turno: Rango): Observable<Rango> {
    return this.http.put<Rango>(this.resourceUrl, turno);
  }

  find(login: string): Observable<Rango> {
    return this.http.get<Rango>(`${this.resourceUrl}/${login}`);
  }

  query(req?: Pagination): Observable<HttpResponse<Rango[]>> {
    const options = createRequestOption(req);
    return this.http.get<Rango[]>(this.resourceUrl, { params: options, observe: 'response' });
  }

  delete(login: string): Observable<{}> {
    return this.http.delete(`${this.resourceUrl}/${login}`);
  }

  authorities(): Observable<string[]> {
    return this.http.get<string[]>(SERVER_API_URL + 'api/users/authorities');
  }
}