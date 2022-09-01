import { Component, DoCheck, ViewChild } from '@angular/core';
import { MatDialog } from '@angular/material/dialog';
import { MatPaginator } from '@angular/material/paginator';
import { MatTableDataSource } from '@angular/material/table';
import { KeycloakAuthService } from '@core/helpers/keycloak-auth.service';
import { ConsultasService } from '@global/services/consultas.service';
import { BuscarPorFiltrosComponent } from '@shared/components/modals/buscar-por-filtros/buscar-por-filtros.component';
import { VerRegistroComponent } from '@shared/components/modals/ver-registro/ver-registro.component';

@Component({
  selector: 'app-consulta-analista',
  templateUrl: './consulta-analista.component.html',
  styleUrls: ['./consulta-analista.component.css']
})
export class ConsultaAnalistaComponent implements DoCheck {
  @ViewChild(MatPaginator)
  paginator!: MatPaginator;
  paginatorHidden = false
  displayedColumns: string[] = [];
  dataSource = new MatTableDataSource<any>();
  loading = false
  usuario: any
  sinRegistro=false

  constructor(
    public dialog: MatDialog,
    private keycloakService: KeycloakAuthService,
    private consultaService: ConsultasService) {
    this.usuario = this.keycloakService.getLoggedUser();
    this.displayedColumns = ['nroRegistro', 'nroIdentificacion', 'descripcion', 'nombre', 'fechaAsigna', 'estadoTramite','Acciones']
  }

  ngAfterViewInit() {
    this.dataSource.paginator = this.paginator;
  }
  applyFilter(event: Event) {
    const filterValue = (event.target as HTMLInputElement).value;
    this.dataSource.filter = filterValue.trim().toLowerCase();
  }
  ngDoCheck(): void {
    if (this.dataSource.data.length > 0) {
      this.paginatorHidden = true
    }else {
      this.paginatorHidden = false
    }
  }

  buscar() {
    let dialogRef = this.dialog.open(BuscarPorFiltrosComponent, {
      width: '500px',
      data: { titulo: 'Registros' }
    });
    dialogRef.afterClosed().subscribe((result: any) => {
      if (result) {
        this.loading = true
        let params = {
          identificacion: this.usuario.cedula,
          estado: result.estado || 0,
          fechaDesde: result.fechaDesde || ' ',
          fechaHasta: result.fechaHasta || ' '
        }
        this.consultaService.obtenerRegistrosPorFiltros(params).subscribe({
          next: (data: any) => {
            this.dataSource.data = data
            this.ningunRegistro();
            this.loading = false
          }
        })
      }

    })
  }
  mostrarTodos() {
    this.loading = true
    let params = {
      identificacion: this.usuario.cedula,
      estado: 0,
      fechaDesde: ' ',
      fechaHasta: ' '
    }
    this.consultaService.obtenerRegistrosPorFiltros(params).subscribe({
      next: (data: any) => {
        this.dataSource.data = data
        this.ningunRegistro();
        this.loading = false
      }
    })
  }
  ningunRegistro(){
    if (this.dataSource.data.length===0) {
        this.sinRegistro = true
    }else{
      this.sinRegistro = false
    }
  }
  enviarId(element:any){
    let id = element.registroProfesionalId
    this.dialog.open(VerRegistroComponent, {
      height: '90%',
      width: 'auto',
      id: 'dialogTrasparent',
      data:{id:id}
    });
  }
}
