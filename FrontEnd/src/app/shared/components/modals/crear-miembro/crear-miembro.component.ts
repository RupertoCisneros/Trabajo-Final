import { Component, DoCheck, Inject, OnInit } from '@angular/core';
import { AbstractControl, UntypedFormBuilder, UntypedFormGroup, Validators } from '@angular/forms';
import { MatDialogRef, MAT_DIALOG_DATA } from '@angular/material/dialog';
import { ComiteEticaService } from '@global/services/comite-etica.service';
import { ConsultasService } from '@global/services/consultas.service';
import { LoadingService } from '@global/services/loading.service';
import { MensajesService } from '@global/services/mensajes.service';
import { ValidacionesPropias } from '@global/Validaciones';

@Component({
  selector: 'app-crear-miembro',
  templateUrl: './crear-miembro.component.html',
  styleUrls: ['./crear-miembro.component.css']
})
export class CrearMiembroComponent implements OnInit, DoCheck {
  cedula!: UntypedFormGroup;
  form!: UntypedFormGroup;
  miembroEncontrado: any
  nroSENESCYT = false
  cargos: any = []
  encontrado: any
  idCargo: any
  constructor(
    private _formBuilder: UntypedFormBuilder,
    public loadingService: LoadingService,
    private consultasService: ConsultasService,
    public dialogRef: MatDialogRef<CrearMiembroComponent>,
    private consultaService: ConsultasService,
    @Inject(MAT_DIALOG_DATA) public data: any,
    private comiteEticaService: ComiteEticaService,
    private mensajesService: MensajesService) {
    this.cedula = this._formBuilder.group({
      cedula: ['', [Validators.required, ValidacionesPropias.soloNumeros, ValidacionesPropias.validarCedula]],
    });
    this.form = this._formBuilder.group({
      cargo: ['', [Validators.required]],
      nroSENESCYT: [''],
      email: ['', [Validators.required, Validators.email]],
      telefono: ['', [Validators.required, Validators.pattern('[0-9].{9}'), ValidacionesPropias.soloNumeros]],
      nombres: [],
      identificacion: [],
      cargoNombre: []
    });
  }
  get f(): { [key: string]: AbstractControl } {
    return this.form.controls;
  }
  ngOnInit(): void {
    this.consultaService.consultaTipoCatalogo(11).subscribe((cargos: any) => {
      this.cargos = cargos
      if (this.data.edit) {
        
        this.miembroEncontrado = this.data
        let cargo = this.cargos.find((element: any) => element.nombre === this.miembroEncontrado.cargo)
        if (cargo) {
          this.f['cargo'].setValue(cargo.tipoCatalogoId)
          this.f['cargo'].updateValueAndValidity()
          this.f['email'].setValue(this.miembroEncontrado.correo)
          this.f['email'].updateValueAndValidity()
          this.f['telefono'].setValue(this.miembroEncontrado.telefono)
          this.f['telefono'].updateValueAndValidity()
          this.f['nroSENESCYT'].setValue({ data: this.miembroEncontrado.numeroSenecyt })
          this.f['nroSENESCYT'].updateValueAndValidity()
        }
      }else{
        this.cargos = this.filterFriendsFollowing(cargos, this.data.miembros);
      }
    })

  }
  filterFriendsFollowing(array1: any, array2: any) {
    const idsNoPermitidos = array2.map((doc:any) => doc.cargo);
    return this.cargos = array1.filter((doc:any) => !idsNoPermitidos.includes(doc.nombre))
  }

  ngDoCheck(): void {

    if (this.f['cargo'].value) {
      this.encontrado = this.cargos.find((element: any) => element.tipoCatalogoId === this.f['cargo'].value)
      if (this.f['cargo'].value === 79) {
        this.nroSENESCYT = true
        this.f['nroSENESCYT'].setValidators([Validators.required])
        this.f['nroSENESCYT'].updateValueAndValidity()
      } else {
        this.nroSENESCYT = false
        this.f['nroSENESCYT'].setValidators([])
        this.f['nroSENESCYT'].updateValueAndValidity()
      }
    }
  }
  buscar() {
    this.loadingService.loading = true
    this.consultasService.obtenerUsuarioPersonas(this.cedula.controls['cedula'].value).subscribe({
      next: data => {
        if (data) {
          data.nombres = data.denominacion
          this.miembroEncontrado = data
          this.loadingService.loading = false
        }

      }
    })
  }
  addMiembro() {
    this.loadingService.loading = true
    this.form.patchValue({
      nombres: this.miembroEncontrado.nombres,
      identificacion: this.miembroEncontrado.identificacion,
      cargoNombre: this.encontrado.nombre
    })
    if (!this.data.edit) {
      this.comiteEticaService.validarExisteMiembroComite(this.form.value.identificacion, this.data.idComite).subscribe({
        next: mensaje => {
          if (mensaje.mensajeValidacion === 'OK') {
            this.comiteEticaService.registroMiembroComite({ body: this.form.value, idComite: this.data.idComite }).then(data => {
              if (data.codigoRespuesta === 201) {
                this.mensajesService.openSuccessSnackBar(data.mensaje, 3000)
                this.loadingService.loading = false
                this.dialogRef.close(true)
              } else {
                this.loadingService.loading = false
              }
              console.log(data);
            }).catch(error => {
              this.loadingService.loading = false
            })
          } else {
            this.mensajesService.openWarningSnackBar(mensaje.mensajeValidacion, 3000)
            this.loadingService.loading = false
          }
        }, error: err => {
          this.loadingService.loading = false
        }
      })
    } 
  }
  cancelarForm() {
    this.miembroEncontrado = null
    this.form.reset()
    this.form.updateValueAndValidity()

  }
}
