import { ChangeDetectorRef, Component, DoCheck, EventEmitter, Input, OnInit, Output, ViewChild } from '@angular/core';
import { MatDialog } from '@angular/material/dialog';
import { MatPaginator } from '@angular/material/paginator';
import { MatTableDataSource } from '@angular/material/table';
import { ComiteEticaService } from '@global/services/comite-etica.service';
import { ConsultasService } from '@global/services/consultas.service';
import { LoadingService } from '@global/services/loading.service';
import { MensajesService } from '@global/services/mensajes.service';
import { CrearMiembroComponent } from '@shared/components/modals/crear-miembro/crear-miembro.component';

@Component({
  selector: 'app-miembros',
  templateUrl: './miembros.component.html',
  styleUrls: ['./miembros.component.css']
})
export class MiembrosComponent implements OnInit,DoCheck {
  miembros: any = []
  displayedColumnsMiembros: string[] = ['identificacion', 'nombres', 'cargo', 'Acciones'];
  miembrosDataSource = new MatTableDataSource<any>();
  @Input() comiteCab: any;
  @ViewChild(MatPaginator)
  paginator!: MatPaginator;
  paginatorHidden = false
  @Output() enviarArray = new EventEmitter<number>();

  constructor(

    public dialog: MatDialog,
    public loadingService: LoadingService,
    private changeDetectorRefs: ChangeDetectorRef,
    private comiteEticaService: ComiteEticaService,
    private mensajesService: MensajesService,
    private consultaService: ConsultasService) { }

  ngOnInit(): void {
    if (this.comiteCab) {
      this.consultaService.obtenerMiembrosComite(this.comiteCab.comiteEticaCabId).subscribe({
        next: data => {
          if (data) {
            this.miembros = data
            this.miembrosDataSource.data = this.miembros
          }
        }
      })
    }
  }
  ngAfterViewInit() {
    this.miembrosDataSource.paginator = this.paginator;
  }
  ngDoCheck(): void {
    this.enviarArray.emit(this.miembrosDataSource.data.length)
    if (this.miembrosDataSource.data.length > 0) {
      this.paginatorHidden = true
    } else {
      this.paginatorHidden = false
    }
  }
  addMiembro() {
    let dialogRef = this.dialog.open(CrearMiembroComponent, {
      width: '600px',
      data: { edit: false,identificacion:'',nombres:'',cargo:'',correo:'',telefono:'',numeroSenecyt:'',idComite: this.comiteCab.comiteEticaCabId,miembros: this.miembros}
    });
    dialogRef.afterClosed().subscribe((result: any) => {
      if (result) {
        this.ngOnInit()
        this.changeDetectorRefs.detectChanges();
      }
    })
  }
  eliminarMiembro(element:any){
    this.comiteEticaService.eliminarMiembroComiteEtica(element.comiteEticaDetId).subscribe({
      next: data=>{
        if (data.codigoRespuesta===201) {
          this.mensajesService.openSuccessSnackBar(data.mensaje,3000);
          this.ngOnInit()
        }
      }
    })
  }
}
