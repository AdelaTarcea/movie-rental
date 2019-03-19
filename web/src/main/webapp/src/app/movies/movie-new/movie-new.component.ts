import {Component} from "@angular/core";
import {Location} from "@angular/common";
import {MoviesService} from "../shared/movies.service";

@Component({
  moduleId: module.id,
  selector: 'ubb-movie-new',
  templateUrl: './movie-new.component.html',
  styleUrls: ['./movie-new.component.css'],
})
export class MovieNewComponent {

  constructor(private location: Location,
              private movieService: MoviesService) {

  }

  goBack(): void {
    console.log("mesaj");

    this.location.back();
  }

  save(name, year, price) {
    console.log("saveNewMovie");

    this.movieService.save(name, year, price)
      .subscribe(movie => {
        console.log("movie saved");
        this.location.back();
      });

  }
}
