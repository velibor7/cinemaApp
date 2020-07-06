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

  createUser(
    un: string,
    fn: string,
    ln: string,
    pn: string,
    email: string,
    pw: string
  ) {
    // console.log(fn + " - " + email + " - " + pw);
    //!  keys u userData se zovu isto kao i na bekendu stvari
    const userData = {
      username: un,
      name: fn,
      surname: ln,
      phoneNumber: pn,
      email: email,
      password: pw,
      active: true,
      position: "viewer",
      // dateOfBirth: ??
    };
    // console.log(userData);

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
