import { Component, OnInit } from '@angular/core';
import {AuthentificationService} from "../../service/authentification.service";
import {Router} from "@angular/router";

@Component({
  selector: 'app-shops',
  templateUrl: './shops.component.html',
  styleUrls: ['./shops.component.css']
})
export class ShopsComponent implements OnInit {

  shops;
  likedshops;

  constructor(private authentification:AuthentificationService, private router:Router) { }

  ngOnInit() {
    this.getShops();
  }

  getShops(){
    this.authentification
      .getShops().subscribe(data=>{
      this.shops = data;
      console.log(this.shops);
    }, error=>{
      this.router.navigateByUrl('/login');
    })
  }

  onLike(id){
    this.authentification.setLikdedShop(id).subscribe(data=>{
      this.getShops();
    }, error=>{
    })
  }

}
