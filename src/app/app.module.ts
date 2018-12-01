import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppComponent } from './app.component';
import { LoginComponent } from './login/login.component';
import { RegistrationComponent } from './registration/registration.component';
import {Routes, RouterModule} from "@angular/router";
import { ShopsComponent } from './shops/shops.component';
import { PreferedShopsComponent } from './prefered-shops/prefered-shops.component';
import {FormsModule} from "@angular/forms";
import {HttpClientModule} from "@angular/common/http";
import {AuthentificationService} from "../service/authentification.service";
import { ReactiveFormsModule } from '@angular/forms';

const appRoutes:Routes=[
  {path:"login", component:LoginComponent},
  {path:"register", component:RegistrationComponent},
  {path:"shops", component:ShopsComponent},
  {path:"preferedShops", component:PreferedShopsComponent}
]

@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    RegistrationComponent,
    ShopsComponent,
    PreferedShopsComponent
  ],
  imports: [
    BrowserModule, RouterModule.forRoot(appRoutes), FormsModule, HttpClientModule, ReactiveFormsModule
  ],
  providers: [AuthentificationService],
  bootstrap: [AppComponent]
})
export class AppModule { }
