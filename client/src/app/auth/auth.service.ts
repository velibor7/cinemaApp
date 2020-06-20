import { Injectable } from "@angular/core";
import { HttpClient } from "@angular/common/http";
import { Router } from "@angular/router";

@Injectable({
  providedIn: "root",
})
export class AuthService {
  constructor(private http: HttpClient, private router: Router) {}

  login(email: string, pw: string) {
    const authData = {
      email: email,
      password: pw,
    };

    let headers = new Headers();
    headers.append("Content-Type", "application/json");

    this.http
      .post("http://localhost:8080/api/user/login", authData)
      .subscribe((res) => {
        console.log(res);
        // this.router.navigate(["/"]);
      });
  }

  createUser(fn: string, email: string, pw: string) {
    console.log(fn + " - " + email + " - " + pw);
    const userData = {
      fullname: fn,
      email: email,
      password: pw,
    };

    let headers = new Headers();
    headers.append("Content-Type", "application/json");

    this.http
      .post("http://localhost:8080/api/user/register", userData)
      .subscribe((res) => {
        console.log(res);
        // this.router.navigate(["/"]);
      });
  }

  logout() {
    console.log("service fn hit!");
  }
}
