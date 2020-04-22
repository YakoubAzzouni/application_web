import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { Routes, RouterModule, Router } from '@angular/router';
import { LoginComponent } from './components/login/login.component';
import { HomeComponent } from './components/home/home.component';
import { NavBarComponent } from './components/nav-bar/nav-bar.component';
import { ParkingsComponent } from './components/parkings/parkings.component';
import { SettingsComponent } from './components/settings/settings.component';
import { SettingsVilleComponent } from './components/settings-ville/settings-ville.component';


const routes: Routes = [
  {path: "home", component: HomeComponent},
  {path: "login", component: LoginComponent },
  {path: "navBar", component: NavBarComponent},
  {path: "parkings", component: ParkingsComponent},
  {path: "settings", component: SettingsComponent},
  {path: "settings-ville", component: SettingsVilleComponent},
  { path: '**', redirectTo: 'home', pathMatch: 'full' }
];

@NgModule({
  declarations: [],
  imports: [
    CommonModule,
    RouterModule.forRoot(routes)
  ],
  exports: [RouterModule]
})
export class AppRoutingModule { }
