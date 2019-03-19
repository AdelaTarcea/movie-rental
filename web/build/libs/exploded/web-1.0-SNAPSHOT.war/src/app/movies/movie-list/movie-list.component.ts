import {Component, OnInit} from '@angular/core';
import {Movie} from "../shared/movies.model";
import {MoviesService} from "../shared/movies.service";
import {Router} from "@angular/router";
import {Location} from "@angular/common";

@Component({
  moduleId: module.id,
  selector: 'ubb-movie-list',
  templateUrl: './movie-list.component.html',
  styleUrls: ['./movie-list.component.css'],
})
export class MovieListComponent implements OnInit {
  errorMessage: string;
  movies: Array<Movie>;
  selectedMovie: Movie;

  constructor(private movieService: MoviesService,
              private router: Router,
              private location: Location) {
  }

  ngOnInit(): void {
    this.getMovies();
  }

  getMovies() {
    this.movieService.getMovies()
      .subscribe(
        movies => this.movies = movies,
        error => this.errorMessage = <any>error
      );
  }

  onSelect(movie: Movie): void {
    this.selectedMovie = movie;
  }

  gotoDetail(): void {
    this.router.navigate(['/movie/detail', this.selectedMovie.id]);
  }

  delete(){
    var id = this.selectedMovie.id;
    this.movieService.delete(id).subscribe((movie)=>{
      console.log("success");
      this.getMovies()
    });
  }
}

