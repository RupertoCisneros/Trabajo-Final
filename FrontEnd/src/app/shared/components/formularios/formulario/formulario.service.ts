import { Injectable } from '@angular/core';
import { Type } from '@angular/core';
import { AnimalFormComponent } from './animal-form/animal-form.component';
import { EspecialistaFormComponent } from './especialista-form/especialista-form.component';
import { MicrochipFormComponent } from './microchip-form/microchip-form.component';
import { TutorFormComponent } from './tutor-form/tutor-form.component';
import { VeterinarioFormComponent } from './veterinario-form/veterinario-form.component';

export class AdForm {
  constructor(public component: Type<any>, public data: any) {}
}
@Injectable({
  providedIn: 'root'
})
export class FormularioService {
  getForms(){
    return [
      new AdForm(EspecialistaFormComponent,{name:'Especialista en Comportamiento/Conducta animal'}),
      new AdForm(TutorFormComponent,{name:'Registro de Datos de Tutor'}),
      new AdForm(VeterinarioFormComponent,{name:'Registro de Datos de Veterinario(a)'}),
      new AdForm(MicrochipFormComponent,{name:'Registro de Microchip'}),
      new AdForm(AnimalFormComponent,{name:'Registro de Animales de Compañia'}),
    ]
  }
}