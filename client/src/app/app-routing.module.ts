import { NgModule } from "@angular/core";
import { Routes, RouterModule } from "@angular/router";
import { HomeComponent } from "./home/home.component";
import { LoginComponent } from "./auth/login/login.component";
import { RegisterComponent } from "./auth/register/register.component";
import { ReservationsComponent } from "./reservations/reservations.component";
import { MovieStartComponent } from "./home/movie-start/movie-start.component";
import { MovieDetailComponent } from "./home/movie-detail/movie-detail.component";

const routes: Routes = [
  {
    path: "",
    component: HomeComponent,
    children: [
      { path: "", component: MovieStartComponent },
      { path: ":id", component: MovieDetailComponent },
    ],
  },
  { path: "login", component: LoginComponent },
  { path: "register", component: RegisterComponent },
  { path: "reservations", component: ReservationsComponent },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule],
})
export class AppRoutingModule {}
