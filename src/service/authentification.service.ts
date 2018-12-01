import {Injectable} from "@angular/core";
import {HttpClient} from "@angular/common/http";
import {HttpHeaders} from "@angular/common/http";
import {JwtHelperService} from "@auth0/angular-jwt";

@Injectable()
export class AuthentificationService {

  private host:string = "http://localhost:8080";
  private jwtToken:string;
  private roles;

  constructor(private http:HttpClient){

  }
  login(user){
    return this.http.post(this.host+"/login", user, {observe:'response'});
  }

  register(user){
    return this.http.post(this.host+"/register", user);
  }

  saveToken(jwt:string){
    this.jwtToken=jwt;
    localStorage.setItem('token', jwt);
    let jwtHelper = new JwtHelperService();
    this.roles = jwtHelper.decodeToken(this.jwtToken).roles;
  }

  loadToken(){
    this.jwtToken = localStorage.getItem('token');
  }

  setLikdedShop(id){
    let headers = new HttpHeaders();
    headers.append('Authorization', this.jwtToken);
    return this.http.get(this.host+"/likeshops/"+id, {headers:new HttpHeaders({'Authorization':this.jwtToken})})
  }

  setDisLikdedShop(id){
    let headers = new HttpHeaders();
    headers.append('Authorization', this.jwtToken);
    return this.http.get(this.host+"/dislikeshops/"+id, {headers:new HttpHeaders({'Authorization':this.jwtToken})})
  }

  getShops(){
    if(this.jwtToken == null) this.loadToken();
    return this.http.get(this.host+"/shops",
      {headers:new HttpHeaders({'Authorization':this.jwtToken})});
  }

  getPreferredShops(){
    if(this.jwtToken == null) this.loadToken();
    return this.http.get(this.host+"/preferredshops",
      {headers:new HttpHeaders({'Authorization':this.jwtToken})});
  }
}

