import { Component, AfterViewInit, ViewChild, OnInit, OnDestroy } from '@angular/core';
import { MatTableDataSource } from '@angular/material/table';
import { MatPaginator } from '@angular/material/paginator';
import { ConsultasService } from 'src/app/global/services/consultas.service';
import { KeycloakAuthService } from '@core/helpers/keycloak-auth.service';
import { VerRegistroComponent } from '@shared/components/modals/ver-registro/ver-registro.component';
import { MatDialog } from '@angular/material/dialog';
import { TramiteService } from '@global/services/tramite.service';

@Component({
  selector: 'app-aprobar',
  templateUrl: './aprobar.component.html',
  styleUrls: ['./aprobar.component.css']
})
export class AprobarComponent implements AfterViewInit, OnInit {
  resultsLength = 0;
  displayedColumns: string[] = ['Numero de tramite', 'Fecha de Creacion', 'Estado del tramite', 'Pertenece', 'Acciones'];
  dataSource = new MatTableDataSource<any>();
  @ViewChild(MatPaginator)
  paginator!: MatPaginator;
  usuario: any
  loading = false
  registro: any

  constructor(
    private consultaService: ConsultasService,
    private keycloakService: KeycloakAuthService,
    public dialog: MatDialog,
    private tramiteService: TramiteService) {
  }
  ngOnInit(): void {
    this.loading = true
    this.usuario = this.keycloakService.getLoggedUser()
    this.consultaService.consultaTramitesAnalista(this.usuario.cedula).subscribe({
      next:data=>{
        this.dataSource.data = data
        this.loading = false
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
  enviarId(element: any) {
    let id = element.registroProfesionalId
    this.tramiteService.cerrarModal = this.tramiteService.dialog.open(VerRegistroComponent, {
      height: '90%',
      width: 'auto',
      id: 'dialogTrasparent',
      data:{id:id,aprobar:true}
    });
    this.tramiteService.cerrarModal.afterClosed().subscribe(result=>{
      if (result) {
        this.ngOnInit()
      }
    })
  }

}

