import { AfterViewInit, ViewChild, Component, OnInit } from '@angular/core';
import { MatDialog } from '@angular/material/dialog';
import { MatTableDataSource } from '@angular/material/table';
import { MatPaginator } from '@angular/material/paginator';
import { CatalogosService } from '@global/services/catalogos.service';
import { Catalogo, CatalogoSchema, TipoCatalogo } from '@core/models/tipo-catalogo.model';
import { MensajesService } from '@global/services/mensajes.service';
import { ConfirmacionComponent } from '@shared/components/modals/confirmacion/confirmacion.component';

@Component({
  selector: 'app-catalogo',
  templateUrl: './catalogo.component.html',
  styleUrls: ['./catalogo.component.css']
})
export class CatalogoComponent implements OnInit, AfterViewInit {
  displayedColumns: string[] = ['nombre','nombreTipoCatalogo','estado','Acciones']//Object.keys(CatalogoSchema);
  tipoCatalogos: TipoCatalogo[] = []
  dataSchema = CatalogoSchema;
  dataSource = new MatTableDataSource<Catalogo>();
  @ViewChild(MatPaginator)
  paginator!: MatPaginator;

  constructor(
    public dialog: MatDialog,
    private catalogoService: CatalogosService,
    private mensajesService: MensajesService) { }

  ngOnInit() {
    this.catalogoService.obtenerTipoCatalogos().subscribe({
      next: data => {
        this.tipoCatalogos = data
      }
    })
    this.catalogoService.obtenerCatalogos().subscribe((res: Catalogo[]) => {
      this.dataSource.data = res;
    })
  }
  ngAfterViewInit() {
    this.dataSource.paginator = this.paginator;
  }

  editRow(row: any) {
    if (row.catalogoId === 0) {
      let encontrado;
      this.dataSource.data.find(item=>{
        if (item.nombreTipoCatalogo === row.nombreTipoCatalogo) {
          encontrado = item.tipoCatalogoId;
        }
      });
      row.tipoCatalogoId = encontrado
      this.catalogoService.addCatalogo(row).then((res:any) => {
        row.Acciones = false;
        if (res.codigoRespuesta===201) {
          this.ngOnInit()
          this.mensajesService.openSuccessSnackBar(res.mensaje,3000);
        }else{
          this.mensajesService.openFailureSnackBar(res.error.mensaje,3000);
        }
      });
    } else {
      this.catalogoService.updateUser(row).subscribe(() => row.Acciones = false);
    }
  }
  cancelEdit(row: any) {
    row.Acciones = false;
    this.catalogoService.obtenerCatalogos().subscribe((res: Catalogo[]) => {
      this.dataSource.data = res;
    })
  }

  addRow() {
    const newRow: Catalogo = { catalogoId: 0,nombreTipoCatalogo:'', nombre: "", tipoCatalogoId: 0, estado: "", Acciones: true, isSelected: false }
    this.dataSource.data = [newRow, ...this.dataSource.data];
  }

  removeRow(catalogoId: number) {
    let dialogRef = this.dialog.open(ConfirmacionComponent, {
      width: '600px',
      data: { mensaje: 'Estás seguro que deseas eliminar?' }
    });
    dialogRef.afterClosed().subscribe((result: any) => {
      if (result) {
        this.catalogoService.eliminarCatalogo(catalogoId).subscribe((res:any) => {
          if (res.codigoRespuesta===201) {
            this.dataSource.data = this.dataSource.data.filter((u: Catalogo) => u.catalogoId !== catalogoId);
            this.mensajesService.openSuccessSnackBar(res.mensaje,3000);
          }else{
            this.mensajesService.openFailureSnackBar(res.mensaje,3000);
          }
        });
      }
      })

  }

  applyFilter(event: Event) {
    const filterValue = (event.target as HTMLInputElement).value;
    this.dataSource.filter = filterValue.trim().toLowerCase();
  }
}