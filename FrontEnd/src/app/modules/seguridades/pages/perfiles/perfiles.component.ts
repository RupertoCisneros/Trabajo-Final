import { AfterViewInit, Component, ViewChild } from '@angular/core';
import { MatDialog } from '@angular/material/dialog';
import { MatPaginator } from '@angular/material/paginator';
import { MatTableDataSource } from '@angular/material/table';
import { ConsultasService } from '@global/services/consultas.service';
import { LoadingService } from '@global/services/loading.service';
import { MensajesService } from '@global/services/mensajes.service';
import { BuscarUsernameComponent } from '@shared/components/modals/buscar-username/buscar-username.component';
export interface Perfiles {
  perfilId: number,
  nombre: string
}
@Component({
  selector: 'app-perfiles',
  templateUrl: './perfiles.component.html',
  styleUrls: ['./perfiles.component.css']
})


export class PerfilesComponent implements AfterViewInit {

  @ViewChild(MatPaginator)
  paginator!: MatPaginator;

  loading = false
  perfiles!: Perfiles[]
  displayedColumns: string[] = [];
  dataSource = new MatTableDataSource<any>();
  noExiste = false
  usuarioSelect: any
  paginatorHidden = false

  constructor(
    public dialog: MatDialog,
    private consultaService: ConsultasService,
    private loadingService: LoadingService,
    private mensajesService: MensajesService) { }

  ngAfterViewInit() {
    this.dataSource.paginator = this.paginator;
  }
  ngDoCheck(): void {
    if (this.dataSource.data.length > 0) {
      this.paginatorHidden = true
    }
  }
  applyFilter(event: Event) {
    const filterValue = (event.target as HTMLInputElement).value;
    this.dataSource.filter = filterValue.trim().toLowerCase();
  }
  buscarCedula() {
    const dialogRef = this.dialog.open(BuscarUsernameComponent, {
      height: 'auto',
      width: 'auto',
    });
    dialogRef.afterClosed().subscribe(result => {
      if (result) {
        this.loadingService.loading = true
        this.loading = true
        this.consultaService.obtenerUsuarioKeyCloack(result.username).subscribe({
          next: (usuarios: any) => {
            this.loading = false
            this.loadingService.loading = false
            if (usuarios && usuarios.length > 0) {
              this.displayedColumns = ['nroIdentificacion', 'username', 'nombres', 'apellidos', 'nombrePerfil', 'Acciones']
              this.noExiste = false
              this.usuarioSelect = null
              this.dataSource.data = usuarios
            } else {
              this.noExiste = true
              this.usuarioSelect = null
              this.dataSource.data = []
            }
          },
          error: err => {
            this.loadingService.loading = false
          }
        })
      }
    });
  }

  reset(evento: any) {
    if (evento) {
      this.usuarioSelect = null
      this.dataSource.data = []
    }

  }
  seleccionarUsuario(usuario: any) {
    if (!usuario.nombrePerfil) {
      this.usuarioSelect = usuario
      this.dataSource.data = []
      this.paginatorHidden = false
      return
    }
    this.mensajesService.openWarningSnackBar('El usuario ya tiene un perfil asignado.',3000)

  }
}
