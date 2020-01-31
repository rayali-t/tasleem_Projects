import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { MainPageComponent } from './main-page/main-page.component';
import { LoginComponent } from './login/login.component';
import { SignupComponent } from './signup/signup.component';
import { HeaderComponent } from './header/header.component';
import { HomepageComponent } from './homepage/homepage.component';
import { PaymentPaypalGatewayComponent } from './payment-paypal-gateway/payment-paypal-gateway.component';
import {RegisterUserComponent} from './Components/register-user';
import {LoginUserComponent} from './Components/login-user';
import { DashboardComponent } from './dashboard/dashboard.component';
import { GraphComponent } from './graph/graph.component';
import {UserProfileComponent} from './Components/user-profile/user-profile.component';
// import {AddExpensesComponent} from "./Components/add-expenses/add-expenses.component";
import { LogoutUserComponent } from './Components/logout-user/logout-user.component';
import { AddIncomeComponent } from './add-income/add-income.component';


const routes: Routes = [
  {path: 'main', component: MainPageComponent},
 // {path: 'main', component: AddExpensesComponent},
  { path: '', component: HomepageComponent },
  // { path: 'login', component: LoginComponent },
  // { path: 'signup', component: SignupComponent },
  { path: 'subscribe', component: PaymentPaypalGatewayComponent },
  { path: 'signup', component: RegisterUserComponent },
  { path: 'login', component: LoginUserComponent },
  { path: 'logout', component: LogoutUserComponent},

  // { path: 'login', component: LoginComponent },
   // { path: 'signup', component: SignupComponent },
  { path: 'subscribe', component: PaymentPaypalGatewayComponent },
  { path: 'dashboard', component: DashboardComponent},
  { path: 'userdashboard', component: GraphComponent},
  { path: 'userProfile', component: UserProfileComponent},
  { path: 'addincome', component: AddIncomeComponent }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
