import {
  HttpInterceptor,
  HttpRequest,
  HttpHandler,
  HttpHeaders,
} from "@angular/common/http";
import { Injectable } from "@angular/core";
import { AuthService } from "./auth.service";

@Injectable()
export class AuthInterceptor implements HttpInterceptor {
  constructor(private authService: AuthService) {}

  intercept(req: HttpRequest<any>, next: HttpHandler) {
    // const authToken = this.authService.getToken();

    const headers = new HttpHeaders({
      "Content-Type": "application/json",
      "Access-Control-Allow-Origin": "http://localhost:8080",
    });
    const authRequest = req.clone({
      // headers: req.headers.set("Authorization", "Bearer " + authToken),
      headers,
    });
    // console.log(authToken);
    return next.handle(authRequest);
  }
}
