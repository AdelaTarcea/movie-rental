import {Injectable} from '@angular/core';

import {HttpClient} from "@angular/common/http";

import {Movie} from "./movies.model";

import {Observable} from "rxjs";
import 'rxjs/add/operator/catch';
import 'rxjs/add/operator/map';
import {Client} from "../../clients/shared/client.model";


@Injectable()
export class MoviesService {
  private moviesUrl = 'http://localhost:8090/api/movies';

  constructor(private httpClient: HttpClient) {
  }

  getMovies(): Observable<Movie[]> {
    return this.httpClient
      .get<Array<Movie>>(this.moviesUrl);
  }

  getMovie(id: number): Observable<Movie> {
    return this.getMovies()
      .map(movies => movies.find(movie => movie.id === id));
  }

  update(movie): Observable<Movie> {
    const url = `${this.moviesUrl}/${movie.id}`;
    return this.httpClient
      .put<Movie>(url, movie);
  }

  save (name, year, price): Observable<Movie> {
    let movie = { name, year,price};
    return this.httpClient
      .post<Movie>(this.moviesUrl, movie);
  }
  delete(id): Observable<Movie[]> {
    const url = `${this.moviesUrl}/${id}`;
    console.log(url);
    return this.httpClient
      .delete<Movie[]>(url);
  }
}
