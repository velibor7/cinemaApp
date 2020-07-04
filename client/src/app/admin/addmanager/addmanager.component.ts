import { Component, OnInit } from "@angular/core";
import { NgForm } from "@angular/forms";

@Component({
  selector: "app-addmanager",
  templateUrl: "./addmanager.component.html",
  styleUrls: ["./addmanager.component.scss"],
})
export class AddmanagerComponent implements OnInit {
  constructor() {}

  ngOnInit(): void {}

  onAddManager(form: NgForm) {
    console.log("adding manager...");
  }
}
