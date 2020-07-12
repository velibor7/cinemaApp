import { Component, OnInit, OnDestroy } from "@angular/core";
import { AuthService } from "../auth/auth.service";
import { Subscription } from "rxjs";

@Component({
  selector: "app-header",
  templateUrl: "./header.component.html",
  styleUrls: ["./header.component.scss"],
})
export class HeaderComponent implements OnInit, OnDestroy {
  isAuth: boolean = false;
  private authListenerSubs: Subscription;

  constructor(public authService: AuthService) {}

  ngOnInit(): void {
    this.isAuth = this.authService.getIsAuth();
    // console.log(this.isAuth);

    this.authListenerSubs = this.authService
      .getAuthStatusListener()
      .subscribe((isAuthenticated) => {
        this.isAuth = isAuthenticated;
        console.log(this.isAuth);
      });

    console.log("[header] isAuth " + this.isAuth);
  }

  onLogout() {
    this.authService.logout();
  }

  ngOnDestroy() {
    this.authListenerSubs.unsubscribe();
  }
}
