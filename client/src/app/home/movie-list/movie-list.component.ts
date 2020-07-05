import { Component, OnInit, OnDestroy } from "@angular/core";
import { HomeService } from "../home.service";
import { Subscription } from "rxjs";
import { connectableObservableDescriptor } from "rxjs/internal/observable/ConnectableObservable";

@Component({
  selector: "app-movie-list",
  templateUrl: "./movie-list.component.html",
  styleUrls: ["./movie-list.component.scss"],
})
export class MovieListComponent implements OnInit {
  projections: any;
  projSub: Subscription;
  constructor(private homeService: HomeService) {}

  ngOnInit(): void {
    this.projections = this.homeService.getProjections();
    this.projSub = this.homeService
      .getProjectionUpdateListener()
      .subscribe((projData) => {
        this.projections = projData.projections;
      });
  }

  ngOnDestroy() {
    this.projSub.unsubscribe();
  }
}
