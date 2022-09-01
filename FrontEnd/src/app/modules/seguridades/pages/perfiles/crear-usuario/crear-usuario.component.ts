import { Component, EventEmitter, Input, OnInit, Output } from '@angular/core';
import {
  AbstractControl,
  Validators,
  FormGroup,
  FormBuilder,
} from '@angular/forms';
import { ConsultasService } from '@global/services/consultas.service';
import { LoadingService } from '@global/services/loading.service';
import { MensajesService } from '@global/services/mensajes.service';
import { SeguridadService } from '@global/services/seguridad.service';

export interface Perfiles {
  perfilId: number,
  nombre: string
}
@Component({
  selector: 'app-crear-usuario',
  templateUrl: './crear-usuario.component.html',
  styleUrls: ['./crear-usuario.component.css'],
})
export class CrearUsuarioComponent implements OnInit {

  @Input() usuarioInput!: any;
  usuarioForm: any
  loading = false
  disabled = true
  @Output()
  propagar = new EventEmitter<boolean>();
  form: FormGroup = new FormGroup({
  });
  perfiles: Perfiles[] = []

  constructor(
    private fb: FormBuilder,
    private consultaService: ConsultasService,
    private seguridadService: SeguridadService,
    private loadingService: LoadingService,
    private mensajeService: MensajesService) {
    this.form = this.fb.group({
      perfiles: ['', [Validators.required]]
    });
  }
  get f(): { [key: string]: AbstractControl } {
    return this.form.controls;
  }
  ngOnInit(): void {
    if (this.usuarioInput) {
      this.consultaService.consultarPerfiles().subscribe({
        next: data => {
          let id;
          for (const i of data) {
            if (i.nombre!='Ciudadano') {
              this.perfiles.push(i)
            }
            if (i.nombre === this.usuarioInput.nombrePerfil) {
              id = i.perfilId
            }
          }
          this.form.patchValue({
            perfiles: id
          })
        },
        error: err => {
          this.loadingService.loading = false
        }

      })
      this.usuarioForm = {
        nombreCompleto: this.usuarioInput.nombres + " " + this.usuarioInput.apellidos,
        identificacion: this.usuarioInput.nroIdentificacion,
        email: this.usuarioInput.email
      }
    }

  }
  onSubmit() {
    this.loading = true
    this.loadingService.loading = true
    if (this.form.invalid) {
      return;
    }
    let body = {
      banderaKeycloack: "S",
      emailMunicipio: this.usuarioForm.email,
      idPerfil: this.form.value.perfiles,
      nroIdentificacion: this.usuarioForm.identificacion,
      ssoId: this.usuarioInput.ssoId,
      username: this.usuarioInput.username
    }
    this.seguridadService.asignarPerfil(body).then((data: any) => {
      this.loading = false
      this.loadingService.loading = false
      this.mensajeService.openSuccessSnackBar(data.mensaje, 3000);
      this.onReset();
    }).catch(err => {
      this.mensajeService.openFailureSnackBar('Error al grabar los datos', 3000);
      this.loading = false
      this.loadingService.loading = false
    })
  }
  onReset(): void {
    this.form.reset();
    this.propagar.emit(true);
  }
}
