import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { User } from 'src/app/entities/user/user';
import { AuthService } from 'src/app/services/auth.service';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {

  constructor(private authService: AuthService) { }

  ngOnInit(): void {
  }

  register(form: NgForm) {
    const user: User = form.value;
    console.log(user);
    this.authService.register(user).subscribe(
      good => {
        console.log("user created");
      }
    )

  }

}
