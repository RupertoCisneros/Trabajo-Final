import { Component } from '@angular/core';
import { UntypedFormBuilder, UntypedFormGroup} from '@angular/forms';
import { Router } from '@angular/router';
import { AnimalService } from '@global/services/animal.service';
import { ConsultasService } from '@global/services/consultas.service';
import { LoadingService } from '@global/services/loading.service';
import { MensajesService } from '@global/services/mensajes.service';
@Component({
  selector: 'app-datos-tecnicos-animal-form',
  templateUrl: './datos-tecnicos-animal-form.component.html',
  styleUrls: ['./datos-tecnicos-animal-form.component.css']
})
export class DatosTecnicosAnimalFormComponent {
  form!: UntypedFormGroup;
  estadosTutorias:any=[]
  minDate = new Date(2000, 0, 1);
  maxDate = new Date(); 

  constructor(
    private _formBuilder: UntypedFormBuilder,
    private consultasService: ConsultasService,
    private loadingService: LoadingService,
    private mensajesService: MensajesService,
    private router: Router,
    private animalService: AnimalService) {
      this.consultasService.consultaTipoCatalogo(36).subscribe({
        next: data => {
          this.estadosTutorias = data      
        }
      })
    this.form = this._formBuilder.group({
      identificacionFotografica: [],
      nombreAnimal:[],
      nacimiento: [],
      numeroMicrochip:[],
      tipoIdentificacion:[],
      identificacionVisible: [],
      atencionRealizada: [],
      estadoChequeo: [],
      observaciones:[],
      enfermedades: []
      
    });
  }
  submitForm() {
    this.loadingService.loading = true
    if (this.form.invalid) {
      console.log('error')
      console.log(this.form.value);
    } else {
      this.animalService.registroAtencionAnimal(this.form.value).then((mensaje: any) => {
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
      this.router.navigate(["/UBA/DatosTecnicosAnimal"]);
    });
  }
  recibirFotografia(array:any){
    if (array) {
      this.form.controls['identificacionFotografica'].setValue({files: array})
    }
  }
  recibirVisible(array:any){
    if (array) {
      this.form.controls['identificacionVisible'].setValue({files: array})
    }
  }
}
