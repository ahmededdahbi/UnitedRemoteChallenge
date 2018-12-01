import { Component, OnInit } from '@angular/core';
import {AuthentificationService} from "../../service/authentification.service";
import {Router} from "@angular/router";

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  mode:number = 0;

  constructor(private authentification:AuthentificationService, private router:Router) { }

  ngOnInit() {
  }

  onLogin(user){
    this.authentification.login(user)
      .subscribe(response=>{
        let jwt = response.headers.get('Authorization');
        this.authentification.saveToken(jwt);
        console.log(jwt);
        this.router.navigateByUrl('/shops');
        console.log(jwt);
      }, error=>{
        this.mode=1;
      })
  }

}
