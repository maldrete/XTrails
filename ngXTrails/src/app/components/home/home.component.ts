import { Component, OnInit } from '@angular/core';
import { AuthService } from 'src/app/services/auth.service';
import { NgForm } from '@angular/forms';
import { User } from 'src/app/entities/user/user';
import { UserService } from 'src/app/services/user.service';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {

  constructor(private authService: AuthService, private userService: UserService) { }

  ngOnInit(): void {
    this.retrieveUser();

  }

  user: User;

  retrieveUser() {
    this.userService.getUser().subscribe(
      user => {
        this.user = user;
        // console.log(user);
      },
      bad => {
        console.error("failed to retrieve user");
      }
    )
  }
}
