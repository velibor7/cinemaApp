import { Injectable } from "@angular/core";
import { HttpClient } from "@angular/common/http";
import { Router } from "@angular/router";
import { Subject } from "rxjs";

@Injectable({
  providedIn: "root",
})
export class AuthService {
  private token: string;
  private tokenTimer: any;
  private userId: string;
  private userType: string;
  private isAuthenticated = false;
  private authStatusListener = new Subject<boolean>();

  constructor(private http: HttpClient, private router: Router) {}

  getToken() {
    return this.token;
  }

  getType() {
    return this.userType;
  }

  getIsAuth() {
    console.log(this.isAuthenticated);
    return this.isAuthenticated;
  }

  getUserId() {
    return this.userId;
  }

  getAuthStatusListener() {
    // console.log("[getAuthStatusListener] " )
    return this.authStatusListener.asObservable();
  }

  /*
  login(email: string, password: string) {
    this.http
      .post<{ token: string; expiresIn: number; userId: string }>(
        "http://localhost:3000/api/user/login",
        { email: email, password: password }s
      )
      .subscribe((response) => {
        const token = response.token;
        this.token = token;
        if (token) {
          const expiresInDuration = response.expiresIn;
          this.setAuthTimer(expiresInDuration);
          this.isAuthenticated = true;
          this.userId = response.userId;
          this.authStatusListener.next(true);
          const now = new Date();
          const expirationDate = new Date(
            now.getTime() + expiresInDuration * 1000
          );
          console.log(expirationDate);
          this.saveAuthData(token, expirationDate, this.userId);
          this.router.navigate(["/"]);
        }
      });
  }
  */

  autoAuthUser() {
    const authInfo = this.getAuthData();
    // ?
    if (!authInfo) {
      return;
    }

    // const now = new Date();
    // const expiresIn = authInfo.expirationDate.getTime() - now.getTime();
    //if (expiresIn > 0) {
    // this.token = authInfo.token;
    this.isAuthenticated = true;
    this.userId = authInfo.userId;
    //this.setAuthTimer(expiresIn / 1000);
    this.authStatusListener.next(true);
    //}
  }

  private setAuthTimer(duration: number) {
    console.log("Setting timer: " + duration);
    this.tokenTimer = setTimeout(() => {
      this.logout();
    }, duration * 1000);
  }

  private saveAuthData(userId: string) {
    //localStorage.setItem("token", token);
    // localStorage.setItem("expiration", expirationDate.toISOString());
    localStorage.setItem("userId", userId);
  }

  private clearAuthData() {
    //localStorage.removeItem("token");
    // localStorage.removeItem("expiration");
    localStorage.removeItem("userId");
  }

  private getAuthData() {
    //const token = localStorage.getItem("token");
    // const expirationDate = localStorage.getItem("expiration");
    const userId = localStorage.getItem("userId");
    // if (!token || !expirationDate) {
    // return;
    // }
    return {
      //token: token,
      //expirationDate: new Date(expirationDate),
      userId: userId,
    };
  }

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
        Object.keys(res).forEach((key) => {
          if (key == "id") {
            if (res[key] == null) {
              this.userId = null;
              this.isAuthenticated = false;
              this.authStatusListener.next(false);
              clearTimeout(this.tokenTimer);
              this.clearAuthData();
              console.log("WRONG PASSWORD!");
              return;
            } else {
              this.userId = res[key];
              console.log(this.userId);
              this.isAuthenticated = true;
              this.authStatusListener.next(true);
              this.saveAuthData(this.userId);
            }
          }
          // console.log(key);
        });

        // Object.keys(res).forEach((key) => {
        // if (key == "id") {
        // if (res[key] == "null") {
        // return;
        // }
        // this.userId = res[key];
        // console.log(this.userId);
        // this.isAuthenticated = true;
        // this.authStatusListener.next(true);
        // this.saveAuthData(this.userId);
        // }
        // // console.log(key);
        // });
        // this.userId = user;
        this.router.navigate(["/"]);
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
    this.token = null;
    this.isAuthenticated = false;
    this.authStatusListener.next(false);
    this.userId = null;
    clearTimeout(this.tokenTimer);
    this.clearAuthData();
    console.log("token cleared!");
    this.router.navigate(["/"]);
  }
}
