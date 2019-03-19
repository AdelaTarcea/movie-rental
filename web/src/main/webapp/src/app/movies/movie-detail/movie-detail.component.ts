import {Component, Input, OnInit} from '@angular/core';
import {MoviesService} from "../shared/movies.service";
import {ActivatedRoute, Params} from "@angular/router";
import {Location} from '@angular/common';
import {Movie} from "../shared/movies.model";

import 'rxjs/add/operator/switchMap';


@Component({
    selector: 'ubb-movie-detail',
    templateUrl: './movie-detail.component.html',
    styleUrls: ['./movie-detail.component.css'],
})

export class MovieDetailComponent implements OnInit {

    @Input() movie: Movie;

    constructor(private movieService: MoviesService,
                private route: ActivatedRoute,
                private location: Location) {
    }

    ngOnInit(): void {
        this.route.params
            .switchMap((params: Params) => this.movieService.getMovie(+params['id']))
            .subscribe(movie => this.movie = movie);
    }

    goBack(): void {
        this.location.back();
    }

  save(): void {
    this.movieService.update(this.movie)
      .subscribe(_ => this.goBack());
  }
}
