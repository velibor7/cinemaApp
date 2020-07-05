import { Injectable } from "@angular/core";
import { HomeService } from "./home.service";
import { ActivatedRoute, RouterStateSnapshot } from "@angular/router";

@Injectable({
  providedIn: "root",
})
export class HomeResolverService {
  constructor(private homeService: HomeService) {}

  resolve(route: ActivatedRoute, state: RouterStateSnapshot) {
    const projections = this.homeService.getProjections();
    return projections;
  }
}
