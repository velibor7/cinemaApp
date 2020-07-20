import { Component, OnInit, OnDestroy } from "@angular/core";
import { Subscription } from "rxjs";
import { AdminService } from "../admin.service";

@Component({
  selector: "app-cinemalist",
  templateUrl: "./cinemalist.component.html",
  styleUrls: ["./cinemalist.component.scss"],
})
export class CinemalistComponent implements OnInit, OnDestroy {
  cinemas: any;
  cinemasSub: Subscription;

  constructor(private adminService: AdminService) {}

  ngOnInit(): void {
    this.cinemas = this.adminService.getCinemas();
    this.cinemasSub = this.adminService
      .getCinemaUpdateListener()
      .subscribe((cinemaData) => {
        this.cinemas = cinemaData.cinemas;
        console.log(this.cinemas);
      });
  }

  onRemoveCinema(id: number) {
    console.log("trying to remove the manager");
    console.log(id);
    this.adminService.removeCinema(id);
  }

  onEditCinema() {
    console.log("editing...");
  }

  ngOnDestroy() {
    this.cinemasSub.unsubscribe();
  }
}
