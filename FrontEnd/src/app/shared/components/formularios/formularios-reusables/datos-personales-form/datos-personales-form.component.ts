import { Component, forwardRef, OnInit } from '@angular/core';
import {
  NG_VALUE_ACCESSOR,
  NG_VALIDATORS,
} from '@angular/forms';
import { PamService } from '@core/helpers/pam.service';
import { TramiteService } from '@global/services/tramite.service';
import { Subscription } from 'rxjs';

@Component({
  selector: 'app-datos-personales-form',
  templateUrl: './datos-personales-form.component.html',
  styleUrls: ['./datos-personales-form.component.css'],
  providers: [
    {
      provide: NG_VALUE_ACCESSOR,
      useExisting: forwardRef(() => DatosPersonalesFormComponent),
      multi: true,
    },
    {
      provide: NG_VALIDATORS,
      useExisting: forwardRef(() => DatosPersonalesFormComponent),
      multi: true,
    },
  ],
})
export class DatosPersonalesFormComponent implements OnInit {
  persona:any
  subscriptions: Subscription[] = [];
  onChange: any = () => {};
  onTouched: any = () => {};
  edit:boolean = false

  constructor(
    private pamService: PamService,
    public tramiteService: TramiteService) {
  }

  ngOnInit(): void {
    this.persona = this.pamService.obtenerPersona();
  }
  ngOnDestroy() {
    this.subscriptions.forEach((s) => s.unsubscribe());
  }
  cancelar(){
    this.edit=false
    this.ngOnInit()
  }
}
