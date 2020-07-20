import { Component, OnInit } from "@angular/core";
import { NgForm } from "@angular/forms";
import { AdminService } from "../admin.service";

@Component({
  selector: "app-addcinema",
  templateUrl: "./addcinema.component.html",
  styleUrls: ["./addcinema.component.scss"],
})
export class AddcinemaComponent implements OnInit {
  constructor(public adminService: AdminService) {}

  ngOnInit(): void {}

  onAddCinema(form: NgForm) {
    if (form.invalid) {
      return;
    }
    this.adminService.addCinema(
      form.value.cname,
      form.value.address,
      form.value.phonenum,
      form.value.email,
      form.value.manager
    );
  }
}
