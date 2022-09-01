import { AfterViewInit, ViewChild, Component, OnInit } from '@angular/core';
import { MatDialog } from '@angular/material/dialog';
import { MatTableDataSource } from '@angular/material/table';
import { MatPaginator } from '@angular/material/paginator';
import { CatalogosService } from '@global/services/catalogos.service';
import { TipoCatalogo, TipoCatalogoSchema } from '@core/models/tipo-catalogo.model';
import { MensajesService } from '@global/services/mensajes.service';
import { LoadingService } from '@global/services/loading.service';

@Component({
  selector: 'app-tipo-catalogo',
  templateUrl: './tipo-catalogo.component.html',
  styleUrls: ['./tipo-catalogo.component.css']
})
export class TipoCatalogoComponent implements OnInit, AfterViewInit {
  displayedColumns: string[] = Object.keys(TipoCatalogoSchema);
  dataSchema = TipoCatalogoSchema;
  dataSource = new MatTableDataSource<TipoCatalogo>();
  @ViewChild(MatPaginator)
  paginator!: MatPaginator;

  constructor(
    public dialog: MatDialog,
    private catalogoService: CatalogosService,
    private mensajesService: MensajesService,
    private loadingService: LoadingService) { }

  ngOnInit() {
    this.catalogoService.obtenerTipoCatalogos().subscribe((res: TipoCatalogo[]) => {
      this.dataSource.data = res;
    })
  }
  ngAfterViewInit() {
    this.dataSource.paginator = this.paginator;
  }
  editRow(row: any) {
    if (row.tipoCatalogoId === 0) {
      this.catalogoService.addTipoCatalogo(row).then(res => {
          if (res.codigoRespuesta === 201) {
            this.ngOnInit();
            this.mensajesService.openSuccessSnackBar(res.mensaje, 2000);
            this.loadingService.loading = false
          } 
          this.loadingService.loading = false
      });
    } else {
      this.catalogoService.updateUser(row).subscribe(() => row.Acciones = false);
    }
  }
  cancelEdit(row: any) {
    row.Acciones = false;
    this.catalogoService.obtenerTipoCatalogos().subscribe((res: TipoCatalogo[]) => {
      this.dataSource.data = res;
    })
  }

  addRow() {
    const newRow: TipoCatalogo = {tipoCatalogoId: 0, nombre: "", estado: "", Acciones: true, isSelected: false }
    this.dataSource.data = [newRow, ...this.dataSource.data];
  }

  removeRow(tipoCatalogoId: number) {
  }

  applyFilter(event: Event) {
    const filterValue = (event.target as HTMLInputElement).value;
    this.dataSource.filter = filterValue.trim().toLowerCase();
  }
}