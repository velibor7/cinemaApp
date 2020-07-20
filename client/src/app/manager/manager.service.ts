import { Injectable } from "@angular/core";
import { HttpClient } from "@angular/common/http";
import { Subject } from "rxjs";
import { Router } from "@angular/router";

@Injectable({
  providedIn: "root",
})
export class ManagerService {
  cinemasUpdated = new Subject<{ cinemas: Object[] }>();
  auditoriumsUpdated = new Subject<{ auditoriums: Object[] }>();

  private cinemas: [] = [];
  private auditoriums: [] = [];

  constructor(private http: HttpClient, private router: Router) {}

  getCinemas(managerId: string) {
    // console.log("tryin");
    this.http
      .get<[]>(
        "http://localhost:8080/api/manager/" + managerId + "/cinemalist/"
      )
      .pipe()
      .subscribe((recievedData) => {
        console.log(recievedData);
        this.cinemasUpdated.next({ cinemas: [...recievedData] });
      });
  }

  getCinemaUpdateListener() {
    return this.cinemasUpdated.asObservable();
  }

  //! AUDITORIUMS

  addAuditorium(capacity: number, label: string) {
    const audData = {
      capacity: capacity,
      label: label,
    };
    console.log(audData);
    this.http
      .post("http://localhost:8080/api/auditorium/add", audData)
      .subscribe((res) => {
        console.log(res);
        this.router.navigate(["/manager"]);
      });
  }

  getAuditoriums(id: number) {
    this.http
      .get<[]>("http://localhost:8080/api/cinema/" + id + "/auditoriumlist")
      .pipe()
      .subscribe((recievedData) => {
        console.log(recievedData);
        this.auditoriumsUpdated.next({ auditoriums: [...recievedData] });
      });
  }

  getAudUpdateListener() {
    return this.auditoriumsUpdated.asObservable();
  }

  removeAuditorium(id: number) {
    console.log("trying to delete auditorium with id: " + id);
    return this.http
      .delete("http://localhost:8080/api/auditorium/" + id)
      .subscribe(() => {
        this.router.navigate(["/manager"]);
      });
  }
}
