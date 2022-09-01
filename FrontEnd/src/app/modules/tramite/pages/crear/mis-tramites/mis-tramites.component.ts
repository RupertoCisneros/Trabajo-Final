import { Component, DoCheck, EventEmitter, OnInit, Output, ViewChild } from '@angular/core';
import { MatDialog } from '@angular/material/dialog';
import { MatPaginator } from '@angular/material/paginator';
import { MatTableDataSource } from '@angular/material/table';
import { PamService } from '@core/helpers/pam.service';
import { ConsultasService } from '@global/services/consultas.service';
import { LoadingService } from '@global/services/loading.service';
import { VerRegistroComponent } from '@shared/components/modals/ver-registro/ver-registro.component';

@Component({
  selector: 'app-mis-tramites',
  templateUrl: './mis-tramites.component.html',
  styleUrls: ['./mis-tramites.component.css']
})
export class MisTramitesComponent implements OnInit,DoCheck {

  persona: any
  displayedColumns: string[] = ['nroRegistro', 'descripcion', 'fechaCreacion', 'estado', 'Acciones'];
  dataSource = new MatTableDataSource<any>();
  loading = false
  paginatorHidden = false
  @Output() tipoRegistro = new EventEmitter<any>();
  
  @ViewChild(MatPaginator)
  paginator!: MatPaginator;

  constructor(
    private consultaService: ConsultasService,
    private pamService: PamService,
    public dialog: MatDialog,
    public loadingService: LoadingService) {
    this.persona = this.pamService.obtenerPersona()
  }
  ngOnInit(): void {
    this.loadingService.loading = true
    this.consultaService.obtenerRegistrosCiudadano(this.persona.nroIdentificacion).subscribe({
      next: data => {
        this.dataSource.data = data
        this.loadingService.loading = false
        setTimeout(() => this.dataSource.paginator = this.paginator);
      }
    })
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
  visualizar(id: any) {
    this.dialog.open(VerRegistroComponent, {
      height: '90%',
      width: 'auto',
      id: 'dialogTrasparent',
      data:{motivo:true,id:id}
    });
  }
  editarRegistro(element:any){
    this.tipoRegistro.emit(element)
  }

}
