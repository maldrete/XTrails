import { Component, OnInit } from '@angular/core';
import { User } from 'src/app/entities/user/user';
import { AuthService } from 'src/app/services/auth.service';
import { Router } from '@angular/router';
import { NgForm, FormGroup } from '@angular/forms';

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
    const user: User = form.value;
    user.email = '';
    // console.log(form.value);


    this.authService.login(user.username, user.password).subscribe(
      good => {
        this.itWorked = good;
        console.log("Login was" + this.itWorked);

        this.router.navigateByUrl('/');
        console.log(this.checkLoginStatus());

      },
      err => {
        console.log("failed to login");
        console.log("username " + this.username);
        console.log("password " + this.password);


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
