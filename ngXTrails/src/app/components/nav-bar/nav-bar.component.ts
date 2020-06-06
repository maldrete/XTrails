import { Component, OnInit } from '@angular/core';
import { User } from 'src/app/entities/user/user';
import { AuthService } from 'src/app/services/auth.service';

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

  constructor(private authService: AuthService) { }

  ngOnInit(): void {
    console.log(this.checkLoginStatus());

  }

  login(): void {
    this.authService.login(this.username, this.password).subscribe(
      good => {
        this.itWorked = good;
        console.log(this.itWorked);
        console.log("User Logged in");
        console.log(this.checkLoginStatus());


      },
      err => {
        console.log("failed to login");
      }
    )
  }

  checkLoginStatus(): boolean {
    return this.authService.checkLogin();
  }

}
