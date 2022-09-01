import { Component,Input } from '@angular/core';

@Component({
  selector: 'app-visualizacion',
  templateUrl: './visualizacion.component.html',
  styleUrls: ['./visualizacion.component.css']
})
export class VisualizacionComponent {

  @Input() visualizar: any;
  @Input() tipoDeRegistro: any;

  constructor() { }

}
