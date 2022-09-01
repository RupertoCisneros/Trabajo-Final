import { SelectionModel } from '@angular/cdk/collections';
import { Component, Input, OnInit, Output,EventEmitter, ViewChild  } from '@angular/core';
import { MatDialog } from '@angular/material/dialog';
import { MatPaginator } from '@angular/material/paginator';
import { MatTableDataSource } from '@angular/material/table';
import { Router } from '@angular/router';
import { LoadingService } from '@global/services/loading.service';

@Component({
  selector: 'app-lista-registros',
  templateUrl: './lista-registros.component.html',
  styleUrls: ['./lista-registros.component.css']
})
export class ListaRegistrosComponent implements OnInit {

  @Input() dataArray: any;
  displayedColumns: string[] = ['select','Numero de tramite', 'Fecha de Creacion', 'Estado del tramite', 'Pertenece'];
  selection = new SelectionModel<any>(true, []);
  dataSource = new MatTableDataSource<any>();
  paginatorHidden = false

  @ViewChild(MatPaginator)
  paginator!: MatPaginator;

  @Output() enviarSeleccionados = new EventEmitter<any>();

  constructor(
    public dialog: MatDialog,
    public loadingService: LoadingService,
    private router: Router) { }

  ngOnInit(): void {
    if (this.dataArray) {
      this.dataSource.data = this.dataArray
    }
  }
  ngAfterViewInit() {
    if (this.dataSource.data) {
      this.dataSource.paginator = this.paginator;
    }

  }
  ngDoCheck(): void {
    if (this.dataSource.data.length > 0) {
      this.paginatorHidden = true
    } else {
      this.paginatorHidden = false
    }
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
  applyFilter(event: Event) {
    const filterValue = (event.target as HTMLInputElement).value;
    this.dataSource.filter = filterValue.trim().toLowerCase();
  }
  
  enviarSeleccion(){
    this.enviarSeleccionados.emit(this.selection.selected)
  }
  
  reloadCurrentRoute() {
    this.router.navigateByUrl("/Administracion", { skipLocationChange: true }).then(() => {
      this.router.navigate(["Administracion/ReasignarTramites"]);
    });
  }

}
