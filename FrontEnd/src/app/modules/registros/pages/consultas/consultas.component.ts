import { Component, DoCheck, EventEmitter, OnInit, Output, ViewChild } from '@angular/core';
import { MatDialog } from '@angular/material/dialog';
import { MatPaginator } from '@angular/material/paginator';
import { MatTableDataSource } from '@angular/material/table';
import { ConsultasService } from '@global/services/consultas.service';
import { LoadingService } from '@global/services/loading.service';
import { BuscarUsuarioComponent } from '@shared/components/modals/buscar-usuario/buscar-usuario.component';
import { VerRegistroComponent } from '@shared/components/modals/ver-registro/ver-registro.component';

@Component({
  selector: 'app-consultas',
  templateUrl: './consultas.component.html',
  styleUrls: ['./consultas.component.css']
})
export class ConsultasComponent implements OnInit {
  displayedColumns: string[] = ['nroRegistro', 'descripcion', 'fechaCreacion', 'estado', 'Acciones'];
  dataSource = new MatTableDataSource<any>();
  loading = false
  paginatorHidden = false
  sinTramite = false

  @ViewChild(MatPaginator)
  paginator!: MatPaginator;

  constructor(
    private consultasService: ConsultasService,
    public dialog: MatDialog,
    public loadingService: LoadingService) { }

  ngOnInit(): void {

  }
  applyFilter(event: Event) {
    const filterValue = (event.target as HTMLInputElement).value;
    this.dataSource.filter = filterValue.trim().toLowerCase();
  }
  ngDoCheck(): void {
    if (this.dataSource.data.length > 0) {
      this.paginatorHidden = true
    } else {
      this.paginatorHidden = false
    }
  }
  buscarRegistros(){
    this.loadingService.loading = true

  }
  buscarUsuario() {
    let dialogRef = this.dialog.open(BuscarUsuarioComponent, {
      width: '800px',
      data: { titulo: 'Buscar Usuario', busqueda:'usuarios' }
    });
    dialogRef.afterClosed().subscribe((result: any) => {
      if (result) {
        console.log(result);
        this.loadingService.loading = true
        this.consultasService.obtenerRegistrosCiudadano(result.cedula).subscribe({
          next: data => {
            console.log(data);
            this.dataSource.data = data
            if (this.dataSource.data.length === 0) {
              this.sinTramite = true
            }
            this.loadingService.loading = false
            setTimeout(() => this.dataSource.paginator = this.paginator);
          }
        })
      }
    })
  }
  visualizar(id: any) {
    this.dialog.open(VerRegistroComponent, {
      height: '90%',
      width: 'auto',
      id: 'dialogTrasparent',
      data:{motivo:true,id:id}
    });
  }
}
