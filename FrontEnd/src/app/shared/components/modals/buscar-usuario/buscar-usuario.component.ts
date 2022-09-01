import { Component, DoCheck, Inject, ViewChild, } from '@angular/core';
import { AbstractControl, UntypedFormBuilder, UntypedFormGroup, Validators } from '@angular/forms';
import { MatDialogRef, MAT_DIALOG_DATA } from '@angular/material/dialog';
import { MatPaginator } from '@angular/material/paginator';
import { MatTableDataSource } from '@angular/material/table';
import { ConsultasService } from '@global/services/consultas.service';

import { ValidacionesPropias } from '@global/Validaciones';

@Component({
  selector: 'app-buscar-usuario',
  templateUrl: './buscar-usuario.component.html',
  styleUrls: ['./buscar-usuario.component.css']
})
export class BuscarUsuarioComponent implements DoCheck {
  @ViewChild(MatPaginator)
  paginator!: MatPaginator;
  escogido!: string;
  paginatorHidden = false
  displayedColumns: string[] = [];
  dataSource = new MatTableDataSource<any>();
  loading = false
  noExiste = false

  form: UntypedFormGroup = new UntypedFormGroup({
  });
  constructor(
    public dialogRef: MatDialogRef<BuscarUsuarioComponent>,
    private formBuilder: UntypedFormBuilder,
    private consultaService: ConsultasService,
    @Inject(MAT_DIALOG_DATA) public data: any,) {

    this.form = this.formBuilder.group({
      cedula: [''],
      usuario: ['']
    });
  }
  get f(): { [key: string]: AbstractControl } {
    return this.form.controls;
  }
  ngAfterViewInit() {
    this.dataSource.paginator = this.paginator;
  }
  applyFilter(event: Event) {
    const filterValue = (event.target as HTMLInputElement).value;
    this.dataSource.filter = filterValue.trim().toLowerCase();
  }

  buscar() {
    if (this.escogido === '1') {
      this.dialogRef.close(this.form.value);
    } else if (this.escogido === '2') {
      this.loading = true
      if (this.data.busqueda === 'Analistas de tramites') {
        this.consultaService.consultaNombresAnalistas(this.form.value.usuario).subscribe({
          next: data => {
            this.displayedColumns = ['nroIdentificacion', 'usuario', 'Acciones']
            this.dataSource.data = data
            this.loading = false
            this.noExiste = false
            if (this.dataSource.data.length === 0) {
              this.noExiste = true
            }   
          }
        })
      }else if (this.data.busqueda === 'usuarios'){
        this.consultaService.consultaNombres(this.form.value.usuario).subscribe({
          next: data => {
            this.displayedColumns = ['nroIdentificacion', 'usuario', 'Acciones']
            this.dataSource.data = data
            this.loading = false
            this.noExiste = false
            if (this.dataSource.data.length === 0) {
              this.noExiste = true
            }          
           
          }
        })
      }


    }
  }
  ngDoCheck(): void {
    if (this.dataSource.data.length > 0) {
      this.paginatorHidden = true
    }
    if (this.escogido === '1') {
      this.f['cedula'].setValidators([Validators.required, ValidacionesPropias.soloNumeros, ValidacionesPropias.validarCedula]);
      this.f['cedula'].updateValueAndValidity();
      this.f['usuario'].setValidators([]);
      this.f['usuario'].updateValueAndValidity();
      this.f['usuario'].patchValue('')
    } else if (this.escogido === '2') {
      this.f['usuario'].setValidators([Validators.required]);
      this.f['usuario'].updateValueAndValidity();
      this.f['cedula'].setValidators([]);
      this.f['cedula'].updateValueAndValidity();
      this.f['cedula'].setValue('')
    }
  }

  seleccionarUsuario(element: any) {
    this.dialogRef.close({ cedula: element.nroIdentificacion })
  }
}
