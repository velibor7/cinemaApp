import { Component, OnInit } from "@angular/core";
import { NgForm } from "@angular/forms";
import { AuthService } from "../auth.service";

@Component({
  selector: "app-register",
  templateUrl: "./register.component.html",
  styleUrls: ["../auth.component.scss"],
})
export class RegisterComponent implements OnInit {
  constructor(public authService: AuthService) {}

  ngOnInit(): void {}
  onRegister(form: NgForm) {
    if (form.invalid) {
      return;
    }

    this.authService.createUser(
      form.value.fullname,
      form.value.email,
      form.value.password
    );
  }
}
