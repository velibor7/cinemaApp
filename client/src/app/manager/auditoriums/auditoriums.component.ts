import { Component, OnInit } from "@angular/core";
import { ActivatedRoute, Router, Params } from "@angular/router";
import { Subscription } from "rxjs";
import { ManagerComponent } from "../manager.component";
import { ManagerService } from "../manager.service";

@Component({
  selector: "app-auditoriums",
  templateUrl: "./auditoriums.component.html",
  styleUrls: ["./auditoriums.component.scss"],
})
export class AuditoriumsComponent implements OnInit {
  id: number;
  auditoriums: any;
  audSub: Subscription;

  constructor(
    private route: ActivatedRoute,
    private router: Router,
    public managerService: ManagerService
  ) {}

  ngOnInit(): void {
    this.route.params.subscribe((params: Params) => {
      this.id = +params["id"];
      console.log(this.id);
      // this.projection = this.homeService.getProjection(this.id);
      this.auditoriums = this.managerService.getAuditoriums(this.id);
      this.audSub = this.managerService
        .getAudUpdateListener()
        .subscribe((audData) => {
          this.auditoriums = audData.auditoriums;
          console.log(this.auditoriums);
        });
    });
  }

  onRemoveAuditorium(id: number) {
    console.log("trying to remove the auditorium w id: " + id);
    this.managerService.removeAuditorium(id);
  }

  onEditAuditorium() {
    console.log("editing...");
  }

  ngOnDestroy() {
    this.audSub.unsubscribe();
  }
}
