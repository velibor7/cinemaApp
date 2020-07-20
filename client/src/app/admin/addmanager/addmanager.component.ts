import { Component, OnInit } from "@angular/core";
import { NgForm } from "@angular/forms";
import { AdminService } from "../admin.service";

@Component({
  selector: "app-addmanager",
  templateUrl: "./addmanager.component.html",
  styleUrls: ["./addmanager.component.scss"],
})
export class AddmanagerComponent implements OnInit {
  constructor(public adminService: AdminService) {}

  ngOnInit(): void {}

  onAddManager(form: NgForm) {
    console.log("adding manager...");
    if (form.invalid) {
      return;
    }
    this.adminService.addManager(
      form.value.username,
      form.value.password,
      form.value.firstname,
      form.value.surname,
      form.value.phonenumber,
      form.value.email
    );
  }
}
