import { Component, OnInit } from "@angular/core";
import { Subscription } from "rxjs";
import { ManagerService } from "./manager.service";
import { AdminService } from "../admin/admin.service";
import { AuthService } from "../auth/auth.service";

@Component({
  selector: "app-manager",
  templateUrl: "./manager.component.html",
  styleUrls: ["./manager.component.scss"],
})
export class ManagerComponent implements OnInit {
  mngId: string;
  cinemas: any;
  cinemasSub: Subscription;

  constructor(
    private managerService: ManagerService,
    private adminService: AdminService,
    private authService: AuthService
  ) {}

  ngOnInit(): void {
    this.mngId = this.authService.getUserId();
    this.cinemas = this.managerService.getCinemas(this.mngId);
    this.cinemasSub = this.managerService
      .getCinemaUpdateListener()
      .subscribe((cinemaData) => {
        this.cinemas = cinemaData.cinemas;
        console.log(this.cinemas);
      });
  }

  onRemoveCinema(id: number) {
    console.log("trying to remove the cinema with id: " + id);
    this.adminService.removeCinema(id);
  }

  onEditCinema() {
    console.log("editing...");
  }

  ngOnDestroy() {
    this.cinemasSub.unsubscribe();
  }
}
