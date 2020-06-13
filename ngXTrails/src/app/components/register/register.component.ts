import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { User } from 'src/app/entities/user/user';
import { AuthService } from 'src/app/services/auth.service';
import { Location } from 'src/app/entities/location/location';
import { LocationService } from 'src/app/services/location.service';
import { log } from 'util';
import { Router } from '@angular/router';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {

  user: User = new User();
  loc: Location = new Location();

  username: string;
  password: string;
  email: string;
  city: string;

  constructor(private authService: AuthService, private locationService: LocationService, private router: Router) { }

  ngOnInit(): void {
  }

  register(form: NgForm) {
    // const user: User = form.value;
    if (this.city === null) {
      this.city = 'empty';
    }
    this.user.username = this.username;
    this.user.password = this.password;
    this.user.email = this.email;
    this.loc.city = this.city;
    this.user.location = this.loc;

    console.log(this.user);

    this.locationService.createLocation(this.loc).subscribe(
      good => {
        console.log('location created');
        this.user.location = good;
        console.log(good);
      }
    )

    this.authService.register(this.user).subscribe(
      good => {
        this.authService.login(this.user.username, this.user.password).subscribe(
          good => {
            this.router.navigateByUrl('/home');
          },
          bad => {
            console.log('failed to login');
          });
      },
      bad => {
        console.error("Failed to Register");
      });
  }

}
