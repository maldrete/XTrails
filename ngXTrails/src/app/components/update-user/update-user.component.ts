import { Component, OnInit } from '@angular/core';
import { UserService } from 'src/app/services/user.service';
import { User } from 'src/app/entities/user/user';
import { Location } from 'src/app/entities/location/location';
import { RouterModule, Router } from '@angular/router';
import { LocationService } from 'src/app/services/location.service';

@Component({
  selector: 'app-update-user',
  templateUrl: './update-user.component.html',
  styleUrls: ['./update-user.component.css']
})
export class UpdateUserComponent implements OnInit {

  user = new User();
  location = new Location();

  constructor(private userService: UserService, private locationService: LocationService,
    private router: Router) { }

  ngOnInit(): void {
    this.retrieveUser();
  }

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

  retrieveLocation(user: User) {
    this.locationService.getLocation(user.location.id).subscribe(
      location => {
        this.location = location;
        if (this.user.location.city === null) {
          this.user.location.city = 'empty';
        }
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

