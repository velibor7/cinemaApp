import { Injectable } from "@angular/core";
import { HttpClient } from "@angular/common/http";

@Injectable({
  providedIn: "root",
})
export class AdminService {
  constructor(private http: HttpClient) {}

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
}
