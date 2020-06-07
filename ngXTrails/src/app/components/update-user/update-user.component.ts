import { Component, OnInit } from '@angular/core';
import { UserService } from 'src/app/services/user.service';
import { User } from 'src/app/entities/user/user';
import { RouterModule, Router } from '@angular/router';

@Component({
  selector: 'app-update-user',
  templateUrl: './update-user.component.html',
  styleUrls: ['./update-user.component.css']
})
export class UpdateUserComponent implements OnInit {

  user = new User();

  constructor(private userService: UserService,
    private router: Router) { }

  ngOnInit(): void {
    this.retrieveUser();
  }

  retrieveUser() {
    this.userService.getUser().subscribe(
      user => {
        this.user = user;
        console.log(user);
      },
      bad => {
        console.error("failed to retrieve user");
      }
    )
  }

  updateUser() {
    console.log(this.user)
    this.userService.updateUser(this.user).subscribe(
      good => {
        this.router.navigateByUrl("/");

      },
      bad => {
        console.error("Failed to Update");
      }
    );
  }

}
