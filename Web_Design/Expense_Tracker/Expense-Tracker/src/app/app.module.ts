import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import {FormsModule, ReactiveFormsModule} from '@angular/forms';
import {BrowserAnimationsModule} from '@angular/platform-browser/animations';
import { HttpClientModule, HTTP_INTERCEPTORS } from '@angular/common/http';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';



import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { MainPageComponent } from './main-page/main-page.component';
import { AddItemFormComponent } from './add-item-form/add-item-form.component';
import { BudgetItemListComponent } from './budget-item-list/budget-item-list.component';
import { BudgetItemCardComponent } from './budget-item-list/budget-item-card/budget-item-card.component';
import { EditItemModalComponent } from './edit-item-modal/edit-item-modal.component';
import { AuthInterceptor } from './auth/auth-interceptor';
import {RegisterUserComponent} from './Components/register-user';
import {LoginUserComponent} from './Components/login-user';
// import {AddExpensesComponent} from "./Components/add-expenses/add-expenses.component";

import { MatDialogModule,
  MatInputModule,
  MatCardModule,
  MatButtonModule,
  MatToolbarModule,
  MatExpansionModule,
  MatProgressSpinnerModule,
  MatPaginatorModule,
  MatGridListModule,
  MatFormFieldModule } from '@angular/material';

import { MatDatepickerModule } from '@angular/material/datepicker';
import { MatSelectModule } from '@angular/material/select';

import { LoginComponent } from './login/login.component';
import { SignupComponent } from './signup/signup.component';
import { HeaderComponent } from './header/header.component';
import { HomepageComponent } from './homepage/homepage.component';
import { PaymentPaypalGatewayComponent } from './payment-paypal-gateway/payment-paypal-gateway.component';
import {AlertService, AuthenticationService, UserService} from './_services';
import { DashboardComponent } from './dashboard/dashboard.component';
import { GraphComponent } from './graph/graph.component';
import {UserProfileComponent} from './Components/user-profile/user-profile.component';
import {FileUploadModule} from 'ng2-file-upload';
import { NavbarComponent } from './navbar/navbar.component';
import { LogoutUserComponent } from './Components/logout-user/logout-user.component';
import { AddIncomeComponent } from './add-income/add-income.component';

@NgModule({
  declarations: [
    AppComponent,
    MainPageComponent,
    AddItemFormComponent,
    BudgetItemListComponent,
    BudgetItemCardComponent,
    EditItemModalComponent,
    LoginComponent,
    SignupComponent,
    HeaderComponent,
    HomepageComponent,
    PaymentPaypalGatewayComponent,
    RegisterUserComponent,
    LoginUserComponent,
    DashboardComponent,
    GraphComponent,
    UserProfileComponent,
    // AddExpensesComponent,
    NavbarComponent,
    LogoutUserComponent,
    AddIncomeComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    BrowserAnimationsModule,
    MatDialogModule,
    MatInputModule,
    MatCardModule,
    MatButtonModule,
    MatToolbarModule,
    MatExpansionModule,
    MatProgressSpinnerModule,
    MatPaginatorModule,
    HttpClientModule,
    NgbModule,
    ReactiveFormsModule,
    MatGridListModule,
    MatFormFieldModule,
    FileUploadModule,
    MatSelectModule,
    MatDatepickerModule
  ],
  providers: [
    { provide: HTTP_INTERCEPTORS, useClass: AuthInterceptor, multi: true },
    AuthenticationService, UserService, AlertService
  ],
  entryComponents: [EditItemModalComponent],
  bootstrap: [AppComponent]
})
export class AppModule { }
