import { NgModule } from "@angular/core";
import { Routes, RouterModule } from "@angular/router";
import { HomeComponent } from "./home/home.component";
import { LoginComponent } from "./auth/login/login.component";
import { RegisterComponent } from "./auth/register/register.component";
import { ReservationsComponent } from "./reservations/reservations.component";
import { MeComponent } from "./me/me.component";
import { AdminComponent } from "./admin/admin.component";
import { AddcinemaComponent } from "./admin/addcinema/addcinema.component";
import { ManagerComponent } from "./manager/manager.component";
import { AddmanagerComponent } from "./admin/addmanager/addmanager.component";
import { MovieDetailComponent } from "./home/movie-detail/movie-detail.component";
import { MovieStartComponent } from "./home/movie-start/movie-start.component";
import { HomeResolverService } from "./home/home-resolver.service";

const routes: Routes = [
  {
    path: "",
    redirectTo: "/home",
    pathMatch: "full",
  },
  {
    path: "home",
    component: HomeComponent,
    // children: [
    // { path: "", component: MovieStartComponent },
    // { path: ":id", component: MovieDetailComponent },
    // ],
    children: [
      { path: "", component: MovieStartComponent },
      {
        path: ":id",
        component: MovieDetailComponent,
        resolve: [HomeResolverService],
      },
    ],
  },

  { path: "login", component: LoginComponent },
  { path: "register", component: RegisterComponent },
  { path: "reservations", component: ReservationsComponent },
  { path: "me", component: MeComponent },
  { path: "admin", component: AdminComponent },
  { path: "admin/addcinema", component: AddcinemaComponent },
  { path: "admin/addmanager", component: AddmanagerComponent },
  { path: "manager", component: ManagerComponent },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule],
})
export class AppRoutingModule {}
