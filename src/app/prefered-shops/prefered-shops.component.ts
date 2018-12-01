import { Component, OnInit } from '@angular/core';
import {AuthentificationService} from "../../service/authentification.service";
import {Router} from "@angular/router";

@Component({
  selector: 'app-prefered-shops',
  templateUrl: './prefered-shops.component.html',
  styleUrls: ['./prefered-shops.component.css']
})
export class PreferedShopsComponent implements OnInit {

  likedshops;
  tolink:string = "login";

  constructor(private authentification:AuthentificationService, private router:Router) { }

  ngOnInit() {
    this.getPreferredShops()
  }

  getPreferredShops(){
    this.authentification
      .getPreferredShops().subscribe(data=>{
      this.likedshops = data;
    }, error=>{
      this.router.navigateByUrl('/login');
    })
  }

  onDislike(id){
    this.authentification.setDisLikdedShop(id).subscribe(data=>{
      this.getPreferredShops();
    }, error=>{
    })
  }

}
