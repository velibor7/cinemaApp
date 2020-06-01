import { Injectable } from "@angular/core";

@Injectable({
  providedIn: "root",
})
export class AuthService {
  constructor() {}

  login(email: string, pw: string) {}
  createUser(fn: string, email: string, pw: string) {}
  logout() {}
}
