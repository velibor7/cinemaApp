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

const routes: Routes = [
  {
    path: "",
    component: HomeComponent,
    // children: [
    // { path: "", component: MovieStartComponent },
    // { path: ":id", component: MovieDetailComponent },
    // ],
  },
  { path: "login", component: LoginComponent },
  { path: "register", component: RegisterComponent },
  { path: "reservations", component: ReservationsComponent },
  { path: "me", component: MeComponent },
  { path: "admin", component: AdminComponent },
  { path: "admin/addcinema", component: AddcinemaComponent },
  { path: "manager", component: ManagerComponent },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule],
})
export class AppRoutingModule {}
