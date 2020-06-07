import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { UpdateUserComponent } from './components/update-user/update-user.component';
import { RegisterComponent } from './components/register/register.component';
import { HomeComponent } from './components/home/home.component';

const routes: Routes = [
  { path: 'updateUser', component: UpdateUserComponent },
  { path: 'register', component: RegisterComponent },
  { path: 'home', component: HomeComponent },
];


@NgModule({
  imports: [RouterModule.forRoot(routes, { useHash: true })],
  exports: [RouterModule]
})
export class AppRoutingModule { }
