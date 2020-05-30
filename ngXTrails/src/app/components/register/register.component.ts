import { Component, OnInit } from '@angular/core';
import { AuthService } from 'src/app/services/auth.service';
import { NgForm } from '@angular/forms';
import { User } from 'src/app/entities/user/user';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {

  constructor(authService: AuthService) { }

  ngOnInit(): void {
  }

  register(form: NgForm) {
    const user: User = form.value;
    console.log(user);
  }

}
