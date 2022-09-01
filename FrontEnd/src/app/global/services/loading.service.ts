import { Injectable, TemplateRef } from '@angular/core';

const PrimaryRed = '#2196F3';
const SecondaryBlue = '#FFFFFF';
@Injectable({
  providedIn: 'root'
})
export class LoadingService {

  loading=false
  mensaje: any = 'Cargando Aplicación...'

  public primaryColour = PrimaryRed;
  public secondaryColour = SecondaryBlue;
  public config = {
    primaryColour: this.primaryColour,
    secondaryColour: this.secondaryColour,
    tertiaryColour: this.primaryColour,
    backdropBackgroundColour: 'rgba(0,0,0,0.35)',
    backdropBorderRadius: '3px',
  };
  public loadingTemplate!: TemplateRef<any>;
  
  constructor() {
   }
}
