import { ChangeDetectorRef, Component, DoCheck } from '@angular/core';
import { UntypedFormBuilder, UntypedFormGroup, Validators} from '@angular/forms';
import { Router } from '@angular/router';
import { AnimalService } from '@global/services/animal.service';
import { ConsultasService } from '@global/services/consultas.service';
import { LoadingService } from '@global/services/loading.service';
import { MensajesService } from '@global/services/mensajes.service';
@Component({
  selector: 'app-retiro-animal-form',
  templateUrl: './retiro-animal-form.component.html',
  styleUrls: ['./retiro-animal-form.component.css']
})
export class RetiroAnimalFormComponent implements DoCheck{
  form!: UntypedFormGroup;
  estadosTutorias:any=[]
  observacion:boolean = false
  
  constructor(
    private _formBuilder: UntypedFormBuilder,
    private consultasService: ConsultasService,
    private animalService: AnimalService,
    private mensajesService: MensajesService,
    private loadingService: LoadingService,
    private router: Router,
    private changeDetectorRefs: ChangeDetectorRef,) {
      this.consultasService.consultaTipoCatalogo(36).subscribe({
        next: data => {
          this.estadosTutorias = data      
        }
      })
    this.form = this._formBuilder.group({
      administracionZonal: [],
      direccionRetiro:[],
      motivoFile:[],
      motivoDescripcion: [],
      motivoRetiro:[],
      estadoTutoriaId: ['',[Validators.required]],
      observaciónTutor: [],
      condicionCalle: [],
      situacionIntervencion: [],
      observacionIntervencion: []

    });
  }
  submitForm() {
    if (this.form.invalid) {
      console.log('error')
      console.log(this.form.value);
    } else {
      this.loadingService.loading = true
      this.animalService.registroRetiroAnimal(this.form.value).then((mensaje: any) => {
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
  ngDoCheck(): void {
    let situacionIntervencion = this.form.controls['situacionIntervencion'].value;
    if (situacionIntervencion) {
      if (situacionIntervencion.nombreData === 'OTROS') {
        this.observacion = true
      }else{
        this.observacion = false
        this.form.controls['observacionIntervencion'].setValidators([])
        this.form.controls['observacionIntervencion'].reset()
        this.form.controls['observacionIntervencion'].updateValueAndValidity()
      }
    }
    this.changeDetectorRefs.detectChanges()
  }

  recibirDocumento(array:any){
    if (array) {
      this.form.controls['motivoFile'].setValue({files: array})
    }
  }
  reloadCurrentRoute() {
    this.router.navigateByUrl("/UBA", { skipLocationChange: true }).then(() => {
      this.router.navigate(["/UBA/RetiroAnimal"]);
    });
  }
  cancelarForm(){
    this.reloadCurrentRoute()
  }
}
