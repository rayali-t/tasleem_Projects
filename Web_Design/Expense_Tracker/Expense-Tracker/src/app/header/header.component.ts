import { Component, OnInit, OnDestroy } from '@angular/core';
import { AuthService } from '../auth/auth.service';
import { Subscription } from 'rxjs';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.scss']
})
export class HeaderComponent implements OnInit, OnDestroy {
  userIsAuthenticated = false;
  private authListenerSubs: Subscription;

  constructor(private authService: AuthService) {}
 ngOnInit() {
this.authListenerSubs = this.authService
.getAuthStatusListener()
.subscribe(isAuthenticated => {
  this.userIsAuthenticated = isAuthenticated;
});
 }

 onLogout() {
  this.authService.logout();
}

 ngOnDestroy() {
  this.authListenerSubs.unsubscribe();
}


  contactUs() {
    window.open('mailto:webdesignf2k19@gmail.com?subject=Customer Concern&body= <<Your Complaint Here>>');
  }

}
