import { Component, OnInit } from '@angular/core';
import { Emitters } from '../emitters/emitters';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {
  message: String;
  authenticated = false;

  constructor() { }

  ngOnInit(): void {
	
	Emitters.authEmitter.subscribe((auth: boolean) => {
      this.authenticated = auth;
    });
	
    if(document.cookie.length === 0){
      this.message = "Please sign in!";
      Emitters.authEmitter.emit(false);
    } else {
      this.message = "";
      Emitters.authEmitter.emit(true);
    }
  }

}
