import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { AppComponent } from './app.component';
import { HttpClientModule } from '@angular/common/http';
import { AuthService } from './services/auth.service';
import { RegisterComponent } from './components/register/register.component';
import { FormsModule } from '@angular/forms';
import { HomeComponent } from './components/home/home.component';
import { NavBarComponent } from './components/nav-bar/nav-bar.component';
import { UpdateUserComponent } from './components/update-user/update-user.component';
import { AppRoutingModule } from './app-routing.module';
import { RouterModule } from '@angular/router';

@NgModule({
  declarations: [
    AppComponent,
    RegisterComponent,
    HomeComponent,
    NavBarComponent,
    UpdateUserComponent
  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    FormsModule,
    AppRoutingModule,
    RouterModule
  ],
  providers: [AuthService],
  bootstrap: [AppComponent]
})
export class AppModule { }
