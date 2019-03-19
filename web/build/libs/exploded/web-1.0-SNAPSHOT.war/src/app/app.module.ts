import {BrowserModule} from '@angular/platform-browser';
import {NgModule} from '@angular/core';
import {HttpClientModule} from '@angular/common/http';
import {FormsModule} from '@angular/forms';

import {AppComponent} from './app.component';
import {AppRoutingModule} from "./app-routing.module";
import {MovieDetailComponent} from "./movies/movie-detail/movie-detail.component";
import {MoviesComponent} from "./movies/movies.component";
import {MovieListComponent} from "./movies/movie-list/movie-list.component";
import {MovieNewComponent} from "./movies/movie-new/movie-new.component";
import {ClientDetailComponent} from "./clients/client-detail/client-detail.component";
import {ClientListComponent} from "./clients/client-list/client-list.component";
import {ClientNewComponent} from "./clients/client-new/client-new.component";
import {ClientsService} from "./clients/shared/clients.service";
import {MoviesService} from "./movies/shared/movies.service";
import {ClientsComponent} from "./clients/movies.component";


@NgModule({
  declarations: [
    AppComponent,
    MovieDetailComponent,
    MoviesComponent,
    MovieListComponent,
    MovieNewComponent,

    AppComponent,
    ClientDetailComponent,
    ClientsComponent,
    ClientListComponent,
    ClientNewComponent,



  ],
  imports: [
    BrowserModule,
    FormsModule,
    HttpClientModule,
    AppRoutingModule,
  ],
  providers: [ MoviesService, ClientsService],
  bootstrap: [AppComponent]
})
export class AppModule {
}
