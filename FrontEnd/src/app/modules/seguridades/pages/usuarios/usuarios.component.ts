import { Component, OnInit, ViewChild } from '@angular/core';
import { MatDialog } from '@angular/material/dialog';
import { MatPaginator } from '@angular/material/paginator';
import { MatTableDataSource } from '@angular/material/table';
import { ConsultasService } from '@global/services/consultas.service';
import { LoadingService } from '@global/services/loading.service';
import { MensajesService } from '@global/services/mensajes.service';
import { SeguridadService } from '@global/services/seguridad.service';
import { ConfirmacionComponent } from '@shared/components/modals/confirmacion/confirmacion.component';

@Component({
  selector: 'app-usuarios',
  templateUrl: './usuarios.component.html',
  styleUrls: ['./usuarios.component.css']
})
export class UsuariosComponent implements OnInit {
  displayedColumns: string[] = ['identificacion', 'denominacion', 'username', 'mail', 'nombrePerfil', 'estado', 'Acciones'];
  abrir = false
  dataSource = new MatTableDataSource<any>();
  @ViewChild(MatPaginator)
  paginator!: MatPaginator;

  constructor(
    private consultasService: ConsultasService,
    private seguridadesService: SeguridadService,
    private mensajesService: MensajesService,
    private loadingService: LoadingService,
    public dialog: MatDialog,
  ) { }

  ngOnInit(): void {
    this.consultasService.obtenerUsuarios().subscribe({
      next: data => {
        this.dataSource.data = data;
      }
    })
  }
  applyFilter(event: Event) {
    const filterValue = (event.target as HTMLInputElement).value;
    this.dataSource.filter = filterValue.trim().toLowerCase();
  }
  ngAfterViewInit() {
    this.dataSource.paginator = this.paginator;
  }
  abrirTab($event: any) {
    if ($event.index === 0) {
      this.abrir = false;
    } else {
      this.abrir = true;
    }
  }
  inactivarUsuario(usuario: any) {
    let proceso: any;
    if (usuario.estado === 'ACT') {
      proceso = 1;
    } else if (usuario.estado === 'INA') {
      proceso = 0;
    }
    const dialogRef = this.dialog.open(ConfirmacionComponent, {
      height: 'auto',
      width: 'auto',
      data: { mensaje: 'Está por inactivar el usuario seleccionado. ¿Seguro desea continuar?' }
    });
    dialogRef.afterClosed().subscribe((result: any) => {
      if (result) {
        this.loadingService.loading = true
        this.seguridadesService.registroActivarOInactivarUsuario(usuario, proceso).then(msg => {
          if (msg.codigoRespuesta === 201) {
            this.mensajesService.openSuccessSnackBar(msg.mensaje, 3000);
            this.ngOnInit()
            this.loadingService.loading = false
          } else {
            this.mensajesService.openSuccessSnackBar(msg.mensaje, 3000);
            this.loadingService.loading = false
          }
        })
      }
    })

  }

}
