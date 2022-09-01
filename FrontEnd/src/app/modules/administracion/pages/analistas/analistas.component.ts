import { Component, ViewChild } from '@angular/core';
import { MatDialog } from '@angular/material/dialog';
import { MatStepper } from '@angular/material/stepper';
import { Router } from '@angular/router';
import { ConsultasService } from '@global/services/consultas.service';
import { LoadingService } from '@global/services/loading.service';
import { MensajesService } from '@global/services/mensajes.service';
import { ReasignacionService } from '@global/services/reasignacion.service';
import { BuscarUsuarioComponent } from '@shared/components/modals/buscar-usuario/buscar-usuario.component';
import { MotivoComponent } from '@shared/components/modals/motivo/motivo.component';

@Component({
  selector: 'app-analistas',
  templateUrl: './analistas.component.html',
  styleUrls: ['./analistas.component.css']
})
export class AnalistasComponent {
  resultsLength = 0;
  noExiste = false
  habilitado = true
  completadoPrimer = false;
  completadoSegundo = false;
  seleccionados: any
  @ViewChild('stepper')
  private myStepper!: MatStepper;
  usuario: any
  ip: any
  disableBoton = false

  listaRegistros = []
  listaAnalistas = []
  constructor(
    private consultaService: ConsultasService,
    public dialog: MatDialog,
    public loadingService: LoadingService,
    private router: Router,
    private reasignacionService: ReasignacionService,
    private mensajesService: MensajesService) {
    
  }

  buscarAnalista() {
    let dialogRef = this.dialog.open(BuscarUsuarioComponent, {
      width: '800px',
      data: { titulo: 'Buscar Analista',busqueda:'Analistas de tramites' }
    });
    dialogRef.afterClosed().subscribe((result: any) => {
      if (result) {
        this.loadingService.loading = true
        this.consultaService.consultaTramitesAnalista(result.cedula).subscribe({
          next: data => {
            if (data.length > 0) {
              this.noExiste = false
              this.consultaService.consultaAnalistas().subscribe((analistas: any) => { 
                this.listaRegistros = data
                this.listaAnalistas = analistas
                this.disableBoton = true
                this.loadingService.loading = false
              })
            } else {
              this.listaRegistros = []
                this.listaAnalistas = []
              this.noExiste = true
              this.disableBoton = false
              this.loadingService.loading = false
            }
            

          }, error: err => {
            this.loadingService.loading = false
          }
        })
      }

    });
  }
  async completadoStep(bol: boolean) {
    return new Promise(res => {
      setTimeout(() => {
        res(bol)
      }, 1);
    })
  }
  async obtenerSeleccionados($event: any) {
    this.seleccionados = $event
    if (this.seleccionados) {
      let bol = await this.completadoStep(true);
      if (bol) {
        this.completadoPrimer = true;
        setTimeout(() => {
          this.myStepper.next()
        }, 0);
      }
    }

  }
  async obtenerSeleccionado(usuarioSeleccionado: any) {
    if (this.seleccionados[0].analistaId!=usuarioSeleccionado.analistaId) {
      let dialogRef = this.dialog.open(MotivoComponent, {
        width: '600px',
        data: { titulo: 'Motivo de Reasignación' }
      });
  
      dialogRef.afterClosed().subscribe((result: any) => {
        if (result) {
          this.loadingService.loading = true
          this.reasignacionService.reasignar(this.seleccionados,usuarioSeleccionado,result.motivo).then(resp=>{
            if (resp.codigoRespuesta === 201) {
              this.mensajesService.openSuccessSnackBar(resp.mensaje, 2000);
              this.reloadCurrentRoute()
              this.loadingService.loading = false
            } else if (resp.error.codigoRespuesta === 400) {
              this.mensajesService.openFailureSnackBar(resp.mensaje, 2000);
              this.loadingService.loading = false
            }
            this.loadingService.loading = false
          })
        }
      })
    }else{
      this.mensajesService.openWarningSnackBar('No se puede reasignar al mismo usuario.',3000)
    }
  }

  reloadCurrentRoute() {
    this.router.navigateByUrl("/Administracion", { skipLocationChange: true }).then(() => {
      this.router.navigate(["Administracion/ReasignarTramites"]);
    });
  }

}