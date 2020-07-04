import { Component, OnInit } from "@angular/core";

@Component({
  selector: "app-movie-detail",
  templateUrl: "./movie-detail.component.html",
  styleUrls: ["./movie-detail.component.scss"],
})
export class MovieDetailComponent implements OnInit {
  popoverTitle = "Popover title";
  popoverMessage = "Popover description";
  confirmClicked = false;
  cancelClicked = false;

  constructor() {}

  ngOnInit(): void {}

  onReserve() {}
}
