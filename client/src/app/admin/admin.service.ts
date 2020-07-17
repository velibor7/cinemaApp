import { Injectable } from "@angular/core";
import { HttpClient } from "@angular/common/http";
import { Subject } from "rxjs";
import { Router } from "@angular/router";

@Injectable({
  providedIn: "root",
})
export class AdminService {
  managersUpdated = new Subject<{ managers: Object[] }>();

  private managers: [] = [];

  constructor(private http: HttpClient, private router: Router) {}

  addCinema(cname: string, address: string, pn: string, manager: string) {
    const cinemaData = {
      name: cname,
      address: address,
      phoneNumber: pn,
      // manager: manager,
    };
    console.log(cinemaData);
    this.http
      .post("http://localhost:8080/api/cinema/add", cinemaData)
      .subscribe((res) => {
        console.log(res);
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
}
