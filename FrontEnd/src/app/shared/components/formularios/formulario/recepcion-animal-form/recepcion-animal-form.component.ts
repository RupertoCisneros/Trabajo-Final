import { Component, DoCheck } from '@angular/core';
import { UntypedFormBuilder, UntypedFormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { AnimalService } from '@global/services/animal.service';
import { ConsultasService } from '@global/services/consultas.service';
import { LoadingService } from '@global/services/loading.service';
import { MensajesService } from '@global/services/mensajes.service';
@Component({
  selector: 'app-recepcion-animal-form',
  templateUrl: './recepcion-animal-form.component.html',
  styleUrls: ['./recepcion-animal-form.component.css']
})
export class RecepcionAnimalFormComponent implements DoCheck {
  form!: UntypedFormGroup;
  estadosTutorias: any = []
  mostrarExamenClinico: boolean = false

  constructor(
    private _formBuilder: UntypedFormBuilder,
    private consultasService: ConsultasService,
    private animalService: AnimalService,
    private mensajesService: MensajesService,
    private loadingService: LoadingService,
    private router: Router) {
    this.consultasService.consultaTipoCatalogo(36).subscribe({
      next: data => {
        this.estadosTutorias = data
      }
    })
    this.form = this._formBuilder.group({
      agenciaUBA: [],
      especie: [],
      raza: [],
      sexo: [],
      estadoReproductivo: [],
      seniasParticulares: ['', [Validators.required]],
      descripcionProceso: ['', [Validators.required]],
      colorPredominante: [],
      colorSecundario: [],
      procesoEjecucion: [],
      examenComportamiento: ['', [Validators.required]],
      examenClinicoComportamental: []

    });
  }
  ngDoCheck(): void {
    if (this.form.controls['examenComportamiento'].value === 'SI') {
      this.mostrarExamenClinico = true
      this.form.controls['examenClinicoComportamental'].setValidators([Validators.required])
      this.form.controls['examenClinicoComportamental'].updateValueAndValidity();
    } else if (this.form.controls['examenComportamiento'].value === 'NO') {
      this.mostrarExamenClinico = false
      this.form.controls['examenClinicoComportamental'].setValidators([])
      this.form.controls['examenClinicoComportamental'].updateValueAndValidity();
    }

  }
  submitForm() {
    this.loadingService.loading = true
    if (this.form.invalid) {
      console.log('error')
      console.log(this.form.value);
    } else {
      this.animalService.registroRecepcionAnimal(this.form.value).then((mensaje: any) => {
        if (mensaje.ok) {
          this.mensajesService.openSuccessSnackBar(mensaje.body.mensaje, 2000);
          this.reloadCurrentRoute()
          this.loadingService.loading = false
        } else if (mensaje.error.codigoRespuesta === 400) {
          this.mensajesService.openFailureSnackBar(mensaje.error.mensaje, 2000);
          this.loadingService.loading = false
        }
        this.loadingService.loading = false
      })
    }
  }
  cancelarForm() {
    this.reloadCurrentRoute()
  }
  reloadCurrentRoute() {
    this.router.navigateByUrl("/UBA", { skipLocationChange: true }).then(() => {
      this.router.navigate(["/UBA/RecepcionAnimal"]);
    });
  }
}
