import { Component, OnInit } from "@angular/core";
import { Projection } from "../projection.model";
import { HomeService } from "../home.service";
import { ActivatedRoute, Router, Params } from "@angular/router";

@Component({
  selector: "app-movie-detail",
  templateUrl: "./movie-detail.component.html",
  styleUrls: ["./movie-detail.component.scss"],
})
export class MovieDetailComponent implements OnInit {
  id: number;

  projection: Projection;

  constructor(
    private homeService: HomeService,
    private route: ActivatedRoute,
    private router: Router
  ) {}

  ngOnInit(): void {
    this.route.params.subscribe((params: Params) => {
      this.id = +params["id"];
      this.projection = this.homeService.getProjection(this.id);
    });
  }

  onReserve() {
    console.log("RESERVED!");
    alert("REZERVISANO!");
  }
}

/*
  mwlConfirmationPopover
  [popoverTitle]="popoverTitle"
  [popoverMessage]="popoverMessage"
  placement="left"
  (confirm)="confirmClicked = true"
  (cancel)="cancelClicked = true"
  */
