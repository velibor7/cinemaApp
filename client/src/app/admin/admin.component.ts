import { Component, OnInit, OnDestroy } from "@angular/core";
import { Subscription } from "rxjs";
import { AdminService } from "./admin.service";

@Component({
  selector: "app-admin",
  templateUrl: "./admin.component.html",
  styleUrls: ["./admin.component.scss"],
})
export class AdminComponent implements OnInit, OnDestroy {
  managers: any;
  managersSub: Subscription;

  constructor(private adminService: AdminService) {}

  ngOnInit(): void {
    this.managers = this.adminService.getManagers();
    this.managersSub = this.adminService
      .getManagerUpdateListener()
      .subscribe((managerData) => {
        this.managers = managerData.managers;
        console.log(this.managers);
      });
  }

  onRemoveManager(id: number) {
    console.log("trying to remove the manager");
    console.log(id);
    this.adminService.removeManager(id);
  }
  onEditManager() {
    console.log("editing...");
  }

  ngOnDestroy() {
    this.managersSub.unsubscribe();
  }
}
