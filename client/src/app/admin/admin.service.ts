import { Injectable } from "@angular/core";
import { HttpClient } from "@angular/common/http";
import { Subject } from "rxjs";
import { Router } from "@angular/router";

@Injectable({
  providedIn: "root",
})
export class AdminService {
  managersUpdated = new Subject<{ managers: Object[] }>();
  cinemasUpdated = new Subject<{ cinemas: Object[] }>();

  private managers: [] = [];
  private cinemas: [] = [];

  constructor(private http: HttpClient, private router: Router) {}

  // ! MANAGERS LOGIC
  addManager(
    un: string,
    pw: string,
    name: string,
    sn: string,
    pn: string,
    email: string
  ) {
    const managerData = {
      username: un,
      password: pw,
      name: name,
      surname: sn,
      phoneNumber: pn,
      email: email,
    };
    console.log(managerData);
    this.http
      .post("http://localhost:8080/api/manager/create", managerData)
      .subscribe((res) => {
        console.log(res);
        this.router.navigate(["/admin"]);
      });
  }

  getManagers() {
    // console.log("tryin");
    this.http
      .get<[]>("http://localhost:8080/api/manager/")
      .pipe()
      .subscribe((recievedData) => {
        console.log(recievedData);
        //! OVO MORAM PROVERITI
        // this.managers = [...recievedData];
        this.managersUpdated.next({ managers: [...recievedData] });
      });
  }

  getManagerUpdateListener() {
    return this.managersUpdated.asObservable();
  }

  removeManager(id: number) {
    console.log("trying to delete manager with id: " + id);
    return this.http
      .delete("http://localhost:8080/api/manager/" + id)
      .subscribe(() => {
        this.router.navigate(["/admin"]);
      });
  }

  //! CINEMA LOGIC

  addCinema(
    cname: string,
    address: string,
    pn: string,
    email: string,
    manager: string
  ) {
    const cinemaData = {
      name: cname,
      address: address,
      phoneNumber: pn,
      email: email,
      // manager: manager,
    };
    console.log(cinemaData);
    this.http
      .post("http://localhost:8080/api/cinema/add", cinemaData)
      .subscribe((res) => {
        console.log(res);
        this.router.navigate(["/admin"]);
      });
  }

  getCinemas() {
    // console.log("tryin");
    this.http
      .get<[]>("http://localhost:8080/api/cinema/")
      .pipe()
      .subscribe((recievedData) => {
        console.log(recievedData);
        this.cinemasUpdated.next({ cinemas: [...recievedData] });
      });
  }

  getCinemaUpdateListener() {
    return this.cinemasUpdated.asObservable();
  }

  removeCinema(id: number) {
    console.log("trying to delete cinema with id: " + id);
    return this.http
      .delete("http://localhost:8080/api/cinema/" + id)
      .subscribe(() => {
        this.router.navigate(["/admin"]);
      });
  }
}
