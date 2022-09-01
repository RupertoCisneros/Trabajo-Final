import { AfterViewInit, Component, OnInit, ViewChild } from '@angular/core';
import { UntypedFormBuilder, UntypedFormGroup, Validators } from '@angular/forms';
import { MatDialog } from '@angular/material/dialog';
import { MatPaginator } from '@angular/material/paginator';
import { MatTableDataSource } from '@angular/material/table';
import { Router } from '@angular/router';
import { ComiteEticaService } from '@global/services/comite-etica.service';
import { ConsultasService } from '@global/services/consultas.service';
import { LoadingService } from '@global/services/loading.service';
import { MensajesService } from '@global/services/mensajes.service';
import { AcuerdoResponsabilidadComponent } from '@shared/components/modals/acuerdo-responsabilidad/acuerdo-responsabilidad.component';
import { ConfirmacionComponent } from '@shared/components/modals/confirmacion/confirmacion.component';

@Component({
  selector: 'app-comite-etica',
  templateUrl: './comite-etica.component.html',
  styleUrls: ['./comite-etica.component.css']
})
export class ComiteEticaComponent implements OnInit, AfterViewInit {
  form!: UntypedFormGroup;
  displayedColumnsCabecera: string[] = ['registro', 'institucion', 'facultad', 'estado', 'Acciones'];
  dataSource = new MatTableDataSource<any>();
  registroComiteEtica: any
  addComite = false
  comiteEditar: any
  guardarComiteBoolean: boolean = true
  loading = false


  @ViewChild(MatPaginator)
  paginator!: MatPaginator;
  constructor(
    private consultasService: ConsultasService,
    private _formBuilder: UntypedFormBuilder,
    private router: Router,
    public dialog: MatDialog,
    public loadingService: LoadingService,
    private comiteEticaService: ComiteEticaService,
    private mensajesService: MensajesService) {
    this.form = this._formBuilder.group({
      nombreInstitucion: ['', [Validators.required]],
      facultad: ['', [Validators.required]],
    });
  }

  ngOnInit(): void {
    this.loading = true
    this.consultasService.obtenerCabeceraComite().subscribe({
      next: data => {
        this.dataSource.data = data
        this.loading = false
      }, error: err => this.loading = false
    })
  }
  ngAfterViewInit() {
    this.dataSource.paginator = this.paginator;
  }
  applyFilter(event: Event) {
    const filterValue = (event.target as HTMLInputElement).value;
    this.dataSource.filter = filterValue.trim().toLowerCase();
  }

  reloadCurrentRoute() {
    this.router.navigateByUrl("/UBA", { skipLocationChange: true }).then(() => {
      this.router.navigate(["/UBA/ComiteEtica"]);
    });
  }

  cancelar() {
    let dialogRef = this.dialog.open(ConfirmacionComponent, {
      width: '600px',
      data: { mensaje: 'Estás seguro de salir, tus datos no se guardarán' }
    });
    dialogRef.afterClosed().subscribe((result: any) => {
      if (result) {
        this.reloadCurrentRoute()
      }
    })
  }

  guardar() {
    this.loadingService.loading = true
    this.comiteEticaService.registroComite(this.form.value).then(respuesta => {
      if (respuesta.codigoRespuesta === 201) {
        this.mensajesService.openSuccessSnackBar('Datos Grabados Correctamente', 3000).afterDismissed().subscribe(msg => {
          this.mensajesService.openWarningSnackBar(respuesta.mensaje, 0);
        })
        this.reloadCurrentRoute()
        this.loadingService.loading = false
      }
    })
  }
  editarComite(element: any) {
    this.comiteEditar = element
    this.form.patchValue({
      nombreInstitucion: element.nombreInstitucion,
      facultad: element.facultadInvestigacion
    })
    this.form.controls['nombreInstitucion'].disable();
    this.form.controls['facultad'].disable();
  }
  guardarComite() {
    this.consultasService.obtenerSubTipoRegistro(4).subscribe({
      next: data => {
        this.registroComiteEtica = data
        const dialogRef = this.dialog.open(ConfirmacionComponent, {
          height: '140px',
          width: '700px',
          data: { mensaje: 'Por favor revisar a detalle la información ingresada.' }
        });
        dialogRef.afterClosed().subscribe(result => {
          if (result) {
            const dialogRef = this.dialog.open(AcuerdoResponsabilidadComponent, {
              height: 'auto',
              width: '700px',
              data: { acuerdo: this.registroComiteEtica.novedad2, informeValorOrdenanza: '' }
            });
            dialogRef.afterClosed().subscribe(result => {
              if (result) {
                this.loadingService.loading = true
                this.comiteEticaService.registroComiteCompleto(this.comiteEditar.comiteEticaCabId).then(resp => {
                  if (resp.codigoRespuesta===201) {
                    this.mensajesService.openSuccessSnackBar(resp.mensaje, 2000)
                    this.loadingService.loading = false
                    this.reloadCurrentRoute()
                  }
                  
                })
              }
            })
          }
        })
      }
    })
  }
  recibirArray(event: any) {
    if (event === 4) {
      this.guardarComiteBoolean = false
    } else {
      this.guardarComiteBoolean = true
    }
  }
} 
