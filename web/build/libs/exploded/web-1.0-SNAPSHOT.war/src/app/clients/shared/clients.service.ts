import {Injectable} from '@angular/core';

import {HttpClient} from "@angular/common/http";

import {Observable} from "rxjs";
import 'rxjs/add/operator/catch';
import 'rxjs/add/operator/map';
import {Client} from "./client.model";


@Injectable()
export class ClientsService {
  private clientsUrl = 'http://localhost:8090/api/clients';

  constructor(private httpClient: HttpClient) {
  }

  getClients(): Observable<Client[]> {
    return this.httpClient
      .get<Array<Client>>(this.clientsUrl);
  }

  getClient(id: number): Observable<Client> {
    return this.getClients()
      .map(client => client.find(client => client.id === id));
  }

  update(client): Observable<Client> {
    const url = `${this.clientsUrl}/${client.id}`;
    return this.httpClient
      .put<Client>(url, client);
  }

  save (name, cnp): Observable<Client> {
    let client = {  name,cnp};
    return this.httpClient
      .post<Client>(this.clientsUrl, client);
  }
  delete(id): Observable<Client[]> {
    const url = `${this.clientsUrl}/${id}`;
    console.log(url);
    return this.httpClient
      .delete<Client[]>(url);
  }
}
