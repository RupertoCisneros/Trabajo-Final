import { Component, EventEmitter, Input, OnInit, Output, ViewChild } from '@angular/core';
import { MatDialog } from '@angular/material/dialog';
import { MatPaginator } from '@angular/material/paginator';
import { MatTableDataSource } from '@angular/material/table';
import { LoadingService } from '@global/services/loading.service';

@Component({
  selector: 'app-lista-analistas',
  templateUrl: './lista-analistas.component.html',
  styleUrls: ['./lista-analistas.component.css']
})
export class ListaAnalistasComponent implements OnInit {
  @Input() dataArray: any;
  displayedColumns: string[] = ['identificacion', 'nombre', 'documentos','Acciones'];
  dataSource = new MatTableDataSource<any>();
  
  @ViewChild(MatPaginator)
  paginator!: MatPaginator;

  paginatorHidden = false
  @Output() enviarSeleccionado = new EventEmitter<any>();

  constructor(
    public dialog: MatDialog,
    public loadingService: LoadingService) { }

  ngOnInit(): void {
    if (this.dataArray) {
      this.dataSource.data = this.dataArray
    }
  }
  applyFilter(event: Event) {
    const filterValue = (event.target as HTMLInputElement).value;
    this.dataSource.filter = filterValue.trim().toLowerCase();
  }
  ngAfterViewInit() {
    this.dataSource.paginator = this.paginator;
  }
  Reasignar(element:any){
    this.enviarSeleccionado.emit(element)
  }

}
