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
  position: string;
  private authListenerSubs: Subscription;
  private positionListenerSubs: Subscription;

  constructor(public authService: AuthService) {}

  ngOnInit(): void {
    this.isAuth = this.authService.getIsAuth();
    this.position = this.authService.getPosition();
    console.log(this.position);
    // console.log(this.isAuth);

    this.authListenerSubs = this.authService
      .getAuthStatusListener()
      .subscribe((isAuthenticated) => {
        this.isAuth = isAuthenticated;
        console.log(this.isAuth);
      });

    this.positionListenerSubs = this.authService
      .getPositionStatusListener()
      .subscribe((position) => {
        this.position = position;
      });

    console.log("[header] isAuth " + this.isAuth);
  }

  onLogout() {
    this.authService.logout();
  }

  ngOnDestroy() {
    this.authListenerSubs.unsubscribe();
    this.positionListenerSubs.unsubscribe();
  }
}
