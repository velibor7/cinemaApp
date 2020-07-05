import { Injectable } from "@angular/core";
import { HttpClient } from "@angular/common/http";
import { Router } from "@angular/router";
import { Subject } from "rxjs";
import { map } from "rxjs/operators";
import { Projection } from "./projection.model";

@Injectable({
  providedIn: "root",
})
export class HomeService {
  projectionsUpdated = new Subject<{ projections: Projection[] }>();

  private projections: Projection[] = [];

  constructor(private http: HttpClient, private router: Router) {}

  getProjection(id: string) {
    return this.http.get<{}>("http://localhost:8080/api/projection/" + id);
  }

  getProjections() {
    // console.log("tryin");
    this.http
      .get<[]>("http://localhost:8080/api/projection/")
      .pipe()
      .subscribe((recievedData) => {
        console.log(recievedData);
        this.projections = [...recievedData];
        this.projectionsUpdated.next({ projections: [...recievedData] });
      });
  }

  getProjectionUpdateListener() {
    return this.projectionsUpdated.asObservable();
  }
}
