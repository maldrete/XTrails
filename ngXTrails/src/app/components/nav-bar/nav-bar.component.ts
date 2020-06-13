import { Component, OnInit } from '@angular/core';
import { User } from 'src/app/entities/user/user';
import { AuthService } from 'src/app/services/auth.service';
import { Router } from '@angular/router';
import { NgForm, FormGroup } from '@angular/forms';
import { getLocaleFirstDayOfWeek } from '@angular/common';
import { log } from 'util';

@Component({
  selector: 'app-nav-bar',
  templateUrl: './nav-bar.component.html',
  styleUrls: ['./nav-bar.component.css']
})
export class NavBarComponent implements OnInit {
  username: string = '';
  password: string = '';
  user: User;
  itWorked: {};


  constructor(private authService: AuthService,
    private router: Router) { }

  ngOnInit(): void {
    console.log(this.checkLoginStatus());

  }

  login(form: NgForm): void {
    console.log('In Login Method');
    console.log();
    this.username = form.value.username;
    this.password = form.value.username;

    console.log('username: ' + this.username + ' password: ' + this.password);

    this.authService.login(this.username, this.password).subscribe(
      good => {
        this.itWorked = good;
        console.log("Login was" + this.itWorked);

        this.router.navigateByUrl('/');
        console.log(this.checkLoginStatus());

      },
      err => {
        console.log("failed to login");
      }
    )
  }


  logout(): void {
    this.authService.logout();
    this.checkLoginStatus();
  }

  checkLoginStatus(): boolean {
    return this.authService.checkLogin();
  }

  navigateToUpdateUser(): void {
    this.router.navigateByUrl('/updateUser');
  }
  navigateToRegister(): void {
    this.router.navigateByUrl('/register');
  }

}
