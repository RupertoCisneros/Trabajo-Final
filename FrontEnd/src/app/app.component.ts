import { Component, OnInit } from '@angular/core';
import { LoadingService } from '@global/services/loading.service';
@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit{
  title = 'Remetfu';
  loading=false
  constructor(
    public loadingService: LoadingService){
    
  }
  ngOnInit(): void {

  }

}
