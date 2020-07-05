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
  // popoverTitle = "Popover title";
  // popoverMessage = "Popover description";
  // confirmClicked = false;
  // cancelClicked = false;
  id: number;
  // projection: Projection = {
  // id: 1,
  // day: "07.05.2020.",
  // time: "20:00",
  // price: 300,
  // movie: {
  // name: "Random title",
  // description: "Random desc lalal",
  // genre: "action",
  // duration: 150,
  // grade: 9,
  // },
  // auditorium: {
  // id: 2,
  // capacity: 140,
  // label: "A2",
  // },
  // };

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
