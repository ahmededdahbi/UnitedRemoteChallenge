import { Component, OnInit } from '@angular/core';
import {AuthentificationService} from "../../service/authentification.service";
import {Router} from "@angular/router";
import {FormGroup, FormBuilder, Validators, AbstractControl} from "@angular/forms";

@Component({
  selector: 'app-registration',
  templateUrl: './registration.component.html',
  styleUrls: ['./registration.component.css']
})
export class RegistrationComponent implements OnInit {

  hasError:boolean =false
  registerForm: FormGroup;
  submitted:boolean = false;

  constructor(private authentification:AuthentificationService, private router:Router, private formBuilder: FormBuilder) { }

  ngOnInit() {
    this.registerForm = this.formBuilder.group({
        username: ['', Validators.required],
        password: ['', [Validators.required, Validators.minLength(6)]],
        rpassword: ['', [Validators.required, Validators.minLength(6)]]
      },
      {validator: this.passwordMatchValidator}
    );
  }

  passwordMatchValidator(frm: FormGroup) {
    return frm.controls['password'].value === frm.controls['rpassword'].value ? null : {'mismatch': true};
  }

  get f() { return this.registerForm.controls; }

  onRegistre(user){
    this.submitted = true;
    if(user.password != user.rpassword){
      this.hasError = true;
      return;
    }
    if (this.registerForm.invalid) {
      return;
    }
    this.authentification.register(user)
      .subscribe(response=>{
        this.router.navigateByUrl('/login');
      }, error=>{
      })
  }

}
