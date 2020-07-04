import { Component, OnInit } from "@angular/core";

@Component({
  selector: "app-admin",
  templateUrl: "./admin.component.html",
  styleUrls: ["./admin.component.scss"],
})
export class AdminComponent implements OnInit {
  managers = [
    {
      id: 2,
      user_type: 2,
      username: "menadjer1",
      password: "menadjer123",
      firstname: "Menadjer",
      surname: "Menadjerovic",
      phoneNumber: "+381 64 5432 332",
      email: "menadjer1@test.com",
      dateOfBirth: "01.01.1990",
      position: "manager",
      active: true,
      cinemas: [{}, {}],
    },
    {
      id: 2,
      user_type: 2,
      username: "menadjer1",
      password: "menadjer123",
      firstname: "Menadjer",
      surname: "Menadjerovic",
      phoneNumber: "+381 64 5432 332",
      email: "menadjer1@test.com",
      dateOfBirth: "01.01.1990",
      position: "manager",
      active: true,
      cinemas: [{}, {}],
    },
    {
      id: 2,
      user_type: 2,
      username: "menadjer1",
      password: "menadjer123",
      firstname: "Menadjer",
      surname: "Menadjerovic",
      phoneNumber: "+381 64 5432 332",
      email: "menadjer1@test.com",
      dateOfBirth: "01.01.1990",
      position: "manager",
      active: true,
      cinemas: [{}, {}],
    },
  ];

  constructor() {}

  ngOnInit(): void {}

  onRemove() {
    console.log("trying to remove the manager");
  }
  onEdit() {
    console.log("editing...");
  }
}
