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
  private userPosition: string;
  private isAuthenticated = false;
  private authStatusListener = new Subject<boolean>();
  private positionStatusListener = new Subject<string>();
  private userStatusListener = new Subject<Object>();
  private currentUser: Object;
  constructor(private http: HttpClient, private router: Router) {}

  getToken() {
    return this.token;
  }

  getPosition() {
    return this.userPosition;
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

  getPositionStatusListener() {
    // console.log("[getAuthStatusListener] " )
    return this.positionStatusListener.asObservable();
  }

  getUserStatusListener() {
    // console.log("[getAuthStatusListener] " )
    return this.userStatusListener.asObservable();
  }

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
        Object.keys(res).forEach(() => {
          if (res["id"] == null) {
            console.log("nema dalje");
            return;
          }
        });

        this.currentUser = res;
        Object.keys(res).forEach((key) => {
          if (key == "id") {
            this.userId = res[key];
            console.log(this.userId);
            this.isAuthenticated = true;
            this.authStatusListener.next(true);
            this.saveAuthData(this.userId);
          }
          // console.log(key);
        });
        Object.keys(res).forEach((key) => {
          this.userPosition = res["position"];
          console.log("position: " + this.userPosition);
          this.positionStatusListener.next(this.userPosition);
        });

        // this.userId = user;
        this.router.navigate(["/"]);
      });
  }

  // getUser(id: string) {
  // console.log("hit");
  // }

  getCurrentUser() {
    return this.currentUser;
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
