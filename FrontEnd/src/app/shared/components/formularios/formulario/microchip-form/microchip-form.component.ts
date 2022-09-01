import { Component, EventEmitter, Output } from '@angular/core';
import { UntypedFormBuilder, UntypedFormGroup } from '@angular/forms';
import { MatDialog } from '@angular/material/dialog';
import { ActivatedRoute, Route, Router } from '@angular/router';
import { ConsultasService } from '@global/services/consultas.service';
import { LoadingService } from '@global/services/loading.service';
import { MensajesService } from '@global/services/mensajes.service';
import { MicrochipService } from '@global/services/microchip.service';
import { TutorService } from '@global/services/tutor.service';
import { AcuerdoResponsabilidadComponent } from '@shared/components/modals/acuerdo-responsabilidad/acuerdo-responsabilidad.component';
import { BuscarTutorComponent } from '@shared/components/modals/buscar-tutor/buscar-tutor.component';
import Swal from 'sweetalert2'

@Component({
  selector: 'app-microchip-form',
  templateUrl: './microchip-form.component.html',
  styleUrls: ['./microchip-form.component.css']
})
export class MicrochipFormComponent {
  form!: UntypedFormGroup;
  tutor: any
  noExiste = false
  uba: boolean = false
  tipodeRegistro: any
  tipos: any

  @Output() formulario = new EventEmitter();
  constructor(
    private _formBuilder: UntypedFormBuilder,
    public dialog: MatDialog,
    private tutorService: TutorService,
    private loadingService: LoadingService,
    private route: ActivatedRoute,
    private microchipService: MicrochipService,
    private consultasService: ConsultasService,
    private mensajesService: MensajesService,
    private router: Router) {
    if (this.route.snapshot.data['uba']) {
      this.uba = this.route.snapshot.data['uba'];
      this.consultasService.consultaTipoRegistro().subscribe(data => {
        data.find((item: any) => {
          if (item.descripcion === "VETERINARIO/A") {
            item.hijos.find((item: any) => {
              if (item.descripcion === "Registro de Microchip") {
                this.tipodeRegistro = item;
              }
            })
          }
        });
      })
    }
    this.form = this._formBuilder.group({
      microchip: [],
      informacionConsiderada: [],
      establecimiento: [],
      observacion: [],
      tutor: []
    });
  }
  submitForm() {
    if (this.form.invalid) {
      return
    } else {
      this.form.controls['tutor'].setValue(this.tutor)
      if (!this.uba) {
        this.formulario.emit(this.form.value)
        return
      }
      const dialogRef = this.dialog.open(AcuerdoResponsabilidadComponent, {
        height: 'auto',
        width: '700px',
        data: { acuerdo: this.tipodeRegistro.acuerdoResponsabilidad, informeValorOrdenanza: this.tipodeRegistro.informeValorOrdenanza }
      });
      dialogRef.afterClosed().subscribe(result => {
        if (result) {
          this.loadingService.loading = true
          this.microchipService.registroMicrochip(this.form.value,this.uba).then(mensaje => {
            Swal.fire({
              text: mensaje.body.mensaje,
              confirmButtonColor: "#2fa4e7",
              confirmButtonText: "Aceptar",
              showClass: {
                popup: 'animate__animated animate__backInDown'
              },
              hideClass: {
                popup: 'animate__animated animate__backOutDown'
              },
            })
            this.reloadCurrentRoute()
            this.loadingService.loading = false
          })
        }
      })
    }
  }
  buscarTutor() {
    let dialogRef = this.dialog.open(BuscarTutorComponent, {
      width: 'auto',
      data: { titulo: 'Buscar Tutor' }
    });
    dialogRef.afterClosed().subscribe((result: any) => {
      if (result) {
        this.loadingService.loading = true
        this.consultasService.obtenerTutor(result.cedula).subscribe({
          next: (data: any) => {
            if (data.length != 0) {
              this.noExiste = false
              this.tutor = data[0]
              this.loadingService.loading = false
            } else {
              this.tutor = null
              this.noExiste = true
              this.loadingService.loading = false
            }
          }
        })
      }
    })
  }
  reloadCurrentRoute() {
    this.router.navigateByUrl("/UBA", { skipLocationChange: true }).then(() => {
      this.router.navigate(["/UBA/RegistrarMicrochip"]);
    });
  }
}
