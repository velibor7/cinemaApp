import { Component, OnInit, OnDestroy } from "@angular/core";
import { AuthService } from "../auth/auth.service";
import { Subscription } from "rxjs";

@Component({
  selector: "app-me",
  templateUrl: "./me.component.html",
  styleUrls: ["./me.component.scss"],
})
export class MeComponent implements OnInit, OnDestroy {
  currentUser;
  userListenerSubs: Subscription;

  constructor(public authService: AuthService) {}

  ngOnInit(): void {
    this.currentUser = this.authService.getCurrentUser();

    this.userListenerSubs = this.authService
      .getAuthStatusListener()
      .subscribe((currentUser) => {
        this.currentUser = currentUser;
        console.log(this.currentUser);
      });
    console.log(this.currentUser);
  }

  ngOnDestroy() {
    this.userListenerSubs.unsubscribe();
  }
}
