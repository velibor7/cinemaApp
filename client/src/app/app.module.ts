import { BrowserModule } from "@angular/platform-browser";
import { NgModule } from "@angular/core";

import { AppRoutingModule } from "./app-routing.module";
import { AppComponent } from "./app.component";
import { HomeComponent } from "./home/home.component";
import { HeaderComponent } from "./header/header.component";
import { LoginComponent } from "./auth/login/login.component";
import { RegisterComponent } from "./auth/register/register.component";
import { MovieListComponent } from "./home/movie-list/movie-list.component";
import { MovieDetailComponent } from "./home/movie-detail/movie-detail.component";
import { ReservationsComponent } from "./reservations/reservations.component";
import { MovieStartComponent } from "./home/movie-start/movie-start.component";

import { FormsModule, ReactiveFormsModule } from "@angular/forms";
import { HttpClientModule, HTTP_INTERCEPTORS } from "@angular/common/http";
import { AuthInterceptor } from "./auth/auth-interceptor";
import { MeComponent } from "./me/me.component";
import { AdminComponent } from "./admin/admin.component";
import { AddcinemaComponent } from "./admin/addcinema/addcinema.component";
import { ManagerComponent } from "./manager/manager.component";
import { AddmanagerComponent } from "./admin/addmanager/addmanager.component";

import { ConfirmationPopoverModule } from "angular-confirmation-popover";
import { CinemalistComponent } from "./admin/cinemalist/cinemalist.component";
import { AuditoriumsComponent } from "./manager/auditoriums/auditoriums.component";

@NgModule({
  declarations: [
    AppComponent,
    HomeComponent,
    HeaderComponent,
    LoginComponent,
    RegisterComponent,
    MovieListComponent,
    MovieDetailComponent,
    ReservationsComponent,
    MovieStartComponent,
    MeComponent,
    AdminComponent,
    AddcinemaComponent,
    ManagerComponent,
    AddmanagerComponent,
    CinemalistComponent,
    AuditoriumsComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    ReactiveFormsModule,
    HttpClientModule,
    ConfirmationPopoverModule.forRoot({
      confirmButtonType: "danger",
    }),
  ],
  providers: [
    {
      provide: HTTP_INTERCEPTORS,
      useClass: AuthInterceptor,
      multi: true,
    },
  ],
  bootstrap: [AppComponent],
})
export class AppModule {}
