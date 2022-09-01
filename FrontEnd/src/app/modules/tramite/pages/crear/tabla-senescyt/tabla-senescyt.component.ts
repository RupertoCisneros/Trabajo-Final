import { Component, ViewChild, OnInit, Input, Output, EventEmitter, DoCheck } from '@angular/core';
import { MatTableDataSource } from '@angular/material/table';
import { MatPaginator } from '@angular/material/paginator';
import { ConsultasService } from 'src/app/global/services/consultas.service';
import { PamService } from '@core/helpers/pam.service';
import { MensajesService } from '@global/services/mensajes.service';
import { SelectionModel } from '@angular/cdk/collections';
import { LoadingService } from '@global/services/loading.service';

@Component({
  selector: 'app-tabla-senescyt',
  templateUrl: './tabla-senescyt.component.html',
  styleUrls: ['./tabla-senescyt.component.css']
})
export class TablaSenescytComponent implements OnInit, DoCheck {

  @Input() tipoRegistro!: any;

  resultsLength = 0;
  displayedColumns!: string[];
  dataSource = new MatTableDataSource<any>();
  @ViewChild(MatPaginator)
  paginator!: MatPaginator;
  persona: any
  @Output() sinConexion = new EventEmitter<boolean>();
  @Output() envioTitulo = new EventEmitter<any>();

  selection = new SelectionModel<any>(true, []);

  constructor(
    private consultaService: ConsultasService,
    private pamSerivce: PamService,
    private mensajeService: MensajesService,
    private loadingService: LoadingService) {
  }
  ngDoCheck(): void {
    if (this.selection.selected.length > 1) {
      this.envioTitulo.emit()
      this.selection.clear();
      this.mensajeService.openWarningSnackBar('Solo se permite un título', 3000)
    } else if (this.selection.selected.length === 1) {
      this.envioTitulo.emit(this.selection.selected)
    } else if (this.selection.selected.length === 0) {
      this.envioTitulo.emit()
    }
  }
  ngOnInit(): void {
    this.persona = this.pamSerivce.obtenerPersona();
    this.loadingService.loading = true
    this.loadingService.mensaje = 'CONSULTANDO DATOS DEL SENESCYT'
    this.consultaService.consultarUsuarioTitulosDinardap(this.persona.nroIdentificacion).subscribe({
      next: ((data) => {
        if (data[0]) {
          let cabecera = Object.keys(data[0])
          this.displayedColumns = cabecera;
          this.displayedColumns.unshift('select');
          this.dataSource.data = data
          this.removeThatParticularColumn();
          this.loadingService.loading = false
        } else {
          this.mensajeService.openWarningSnackBar('Estimado usuario, usted no contiene Títulos del SENESCYT o existen problemas de conexión con la Dinardap', 6000);
          this.sinConexion.emit(true);
          this.loadingService.loading = false
        }
      }),
      error: err => console.log(err),
    })
  }
  applyFilter(event: Event) {
    const filterValue = (event.target as HTMLInputElement).value;
    this.dataSource.filter = filterValue.trim().toLowerCase();
  }
  ngAfterViewInit() {
    this.dataSource.paginator = this.paginator;
  }
  isAllSelected() {
    const numSelected = this.selection.selected.length;
    const numRows = this.dataSource.data.length;
    return numSelected === numRows;
  }
  masterToggle() {
    if (this.isAllSelected()) {
      this.selection.clear();
      return;
    }
    this.selection.select(...this.dataSource.data);
  }

  checkboxLabel(row?: any): string {
    if (!row) {
      return `${this.isAllSelected() ? 'deselect' : 'select'} all`;
    }
    return `${this.selection.isSelected(row) ? 'deselect' : 'select'} row ${row.position + 1}`;
  }

  removeThatParticularColumn() {
    this.remove('numeroRegistro');
  }

  remove(ele: string) {
    let index = this.displayedColumns.indexOf(ele);
    if (index > -1) {
      this.displayedColumns.splice(index, 1);
    }
  }

}
