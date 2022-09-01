import { SelectionModel } from '@angular/cdk/collections';
import { ChangeDetectorRef, Component, DoCheck, forwardRef } from '@angular/core';
import {
  NG_VALUE_ACCESSOR,
  UntypedFormBuilder,
  UntypedFormGroup,
  Validators,
  UntypedFormControl,
  NG_VALIDATORS,
  AbstractControl,
} from '@angular/forms';
import { MatCheckboxChange } from '@angular/material/checkbox';
import { MatDialog } from '@angular/material/dialog';
import { MatTableDataSource } from '@angular/material/table';
import { PamService } from '@core/helpers/pam.service';
import { AnimalService } from '@global/services/animal.service';
import { ConsultasService } from '@global/services/consultas.service';
import { LoadingService } from '@global/services/loading.service';
import { MensajesService } from '@global/services/mensajes.service';
import { TutorService } from '@global/services/tutor.service';
import { ValidacionesPropias } from '@global/Validaciones';
import { BuscarTutorComponent } from '@shared/components/modals/buscar-tutor/buscar-tutor.component';

export interface MicrochipFormsValue {
  codigoMicrochip: string;
}
import { Subscription } from 'rxjs';

@Component({
  selector: 'app-datos-generales-form',
  templateUrl: './datos-generales-form.component.html',
  styleUrls: ['./datos-generales-form.component.css'],
  providers: [
    {
      provide: NG_VALUE_ACCESSOR,
      useExisting: forwardRef(() => DatosGeneralesFormComponent),
      multi: true,
    },
    {
      provide: NG_VALIDATORS,
      useExisting: forwardRef(() => DatosGeneralesFormComponent),
      multi: true,
    },
  ],
})
export class DatosGeneralesFormComponent implements DoCheck {
  selectionAnimal = new SelectionModel<any>(true, []);
  persona: any
  comunitario!: boolean
  procedenciaAnimal: any = []
  minDate = new Date(2000, 0, 1);
  maxDate = new Date();
  estadosTutorias: any = []
  formatos = ['pdf']
  noExiste = false
  tutor: any
  tutoresComunitariosColumns: string[] = ['denominacion', 'email', 'movil', 'Acciones'];
  tutoresComunitarios = new MatTableDataSource<any>();
  tiposAnimal: any = []
  selection = new SelectionModel<any>(true, []);
  mostrarCarnetConadis = false
  mostrarCertificadoMedico = false
  mostrarEstablecimiento = false
  requerido = false
  displayedColumnsTiposAnimal: string[] = ['descripcion', 'file', 'establecimiento', 'telefono', 'select'];
  estilotabla: any
  establecimientos: any = []
  nombreEstablecimiento: any
  nombreTelefono: any
  form: UntypedFormGroup = new UntypedFormGroup({
  });


  subscriptions: Subscription[] = [];

  onChange: any = () => { };
  onTouched: any = () => { };

  get value(): MicrochipFormsValue {
    return this.form.value;
  }
  set value(value: MicrochipFormsValue) {
    this.form.setValue(value);
    this.onChange(value);
    this.onTouched();
  }


  get f(): { [key: string]: AbstractControl } {
    return this.form.controls;
  }

  constructor(
    private formBuilder: UntypedFormBuilder,
    private pamService: PamService,
    private consultasService: ConsultasService,
    public dialog: MatDialog,
    private loadingService: LoadingService,
    private tutorService: TutorService,
    private mensajeService: MensajesService,
    private changeDetectorRefs: ChangeDetectorRef,
    public animalService: AnimalService) {
    this.consultasService.consultaTipoCatalogo(36).subscribe({
      next: data => {
        this.estadosTutorias = data
        console.log(data);
      }
    })
    this.persona = this.pamService.obtenerPersona();
    this.consultasService.consultaTipoCatalogo(15).subscribe({
      next: data => {
        this.tiposAnimal = data
        for (const item of this.tiposAnimal) {
          let est: any = item
          est.file = ''
          est.establecimiento = ''
          est.telefono = ''
          est.select = false
          est.nombreArchivo = ''
        }
      }
    })
    this.consultasService.consultaTipoCatalogo(16).subscribe({
      next: data => {
        this.procedenciaAnimal = data
      }
    })



    this.form = this.formBuilder.group({
      comunitario: ['', [Validators.required]],
      estadoTutoriaId: ['', [Validators.required]],
      procedenciaAnimal: ['', [Validators.required]],
      microchip: [''],
      nombreAnimal: ['', [Validators.required]],
      observacionMicrochip: [''],
      nacimiento: ['', [Validators.required, ValidacionesPropias.LessThanToday]],
      tutoresComunitarios: [''],
      tipoAnimal: ['', [Validators.required]],
      file: [],
      establecimiento: [],
      telefono: [],
    });
    this.subscriptions.push(
      this.form.valueChanges.subscribe((value: any) => {
        this.onChange(value);
        this.onTouched();
      })
    );
  }
  ngOnDestroy() {
    this.subscriptions.forEach((s) => s.unsubscribe());
  }
  registerOnChange(fn: any) {
    this.onChange = fn;
  }
  writeValue(value: any) {
    if (value) {
      this.value = value;
    }

    if (value === null) {
      this.form.reset();
    }
  }
  registerOnTouched(fn: any) {
    this.onTouched = fn;
  }
  validate(_: UntypedFormControl) {
    return this.form.valid ? null : { invalidForm: { valid: false, errors: this.form.errors } };
  }

  ngDoCheck(): void {
    if (this.comunitario) {
      this.f['comunitario'].setValue("SI")
    } else {
      this.f['comunitario'].setValue("NO")
    }
    if (this.f['comunitario'].value === 'SI') {
      this.f['tutoresComunitarios'].addValidators([Validators.required])
      this.f['tutoresComunitarios'].updateValueAndValidity();
      if (this.tutoresComunitarios.data.length > 0) {
        this.f['tutoresComunitarios'].setValue(this.tutoresComunitarios.data)
      } else {
        this.f['tutoresComunitarios'].setValue('')
      }
    }
    if (this.f['comunitario'].value === 'NO') {
      this.f['tutoresComunitarios'].clearValidators()
      this.f['tutoresComunitarios'].updateValueAndValidity();
      if (this.tutoresComunitarios.data.length === 0) {
        this.f['tutoresComunitarios'].setValue('')
      }
    }

    if (this.selection.selected.length > 0) {
      this.selection.selected.filter((item: any) => {
        if (item.tipoCatalogoId > 101) {
          if (item.establecimiento === '' || item.telefono === '') {
            this.form.controls['establecimiento'].setValidators([Validators.required])
            this.form.controls['establecimiento'].updateValueAndValidity()
            this.form.controls['telefono'].setValidators([Validators.required])
            this.form.controls['telefono'].updateValueAndValidity()
            this.form.controls['file'].setValidators([])
            this.form.controls['file'].updateValueAndValidity()
          } else {
            this.form.controls['establecimiento'].setValidators([])
            this.form.controls['establecimiento'].updateValueAndValidity()
            this.form.controls['telefono'].setValidators([])
            this.form.controls['telefono'].updateValueAndValidity()
          }
        } else
          if (item.tipoCatalogoId === 100 || item.tipoCatalogoId === 101) {
            if (item.file === '') {
              this.form.controls['file'].setValidators([Validators.required])
              this.form.controls['file'].updateValueAndValidity()
              this.form.controls['establecimiento'].setValidators([])
              this.form.controls['establecimiento'].updateValueAndValidity()
              this.form.controls['telefono'].setValidators([])
              this.form.controls['telefono'].updateValueAndValidity()
            }
            else {
              this.form.controls['file'].setValidators([])
              this.form.controls['file'].updateValueAndValidity()

            }
          }
      })
      this.f['tipoAnimal'].setValue(this.selection.selected)
    } else {
      this.f['tipoAnimal'].reset()
      this.f['tipoAnimal'].updateValueAndValidity();
    }
    this.changeDetectorRefs.detectChanges();
  }


  onChangeComuntario(ob: MatCheckboxChange) {
    if (ob.checked) {
      this.comunitario = true
    } else {
      this.comunitario = false
    }
  }

  submit() {
    console.log(this.form.value);
  }
  buscarTutor() {
    let dialogRef = this.dialog.open(BuscarTutorComponent, {
      width: 'auto',
      data: { titulo: 'Buscar Tutor' }
    });
    dialogRef.afterClosed().subscribe((result: any) => {
      if (result) {
        this.loadingService.loading = true
        this.consultasService.obtenerTutor(result.cedula).subscribe({
          next: (data: any) => {
            if (data.length != 0) {
              this.noExiste = false
              this.tutor = data[0]
              if (!this.buscarSiExisteTutor(this.tutor.tutor_id)) {
                this.tutoresComunitarios.data.push(this.tutor)
                this.tutoresComunitarios.data = this.tutoresComunitarios.data
              } else {
                this.mensajeService.openWarningSnackBar('El usuario ya esta agregado', 3000)
              }
              this.loadingService.loading = false
            } else {
              this.tutor = null
              this.noExiste = true
              this.loadingService.loading = false
            }
          }
        })
      }
    })
    this.changeDetectorRefs.detectChanges();
  }

  buscarSiExisteTutor(tutor_id: number) {
    let encontrado = this.tutoresComunitarios.data.filter((tutor: any) => tutor.tutor_id === tutor_id);
    if (encontrado.length > 0) {
      return true
    }
    return false
  }

  eliminarTutorComunitario(element: any) {
    let data = this.tutoresComunitarios.data.filter((tutor: any) => tutor.tutor_id !== element.tutor_id);
    this.tutoresComunitarios.data = data
  }

  isAllSelected() {
    const numSelected = this.selection.selected.length;
    const numRows = this.tiposAnimal.length;
    return numSelected === numRows;
  }
  masterToggle() {
    if (this.isAllSelected()) {
      this.selection.clear();
      return;
    }
    this.selection.select(...this.tiposAnimal);
  }

  checkboxLabel(row?: any): string {
    if (!row) {
      return `${this.isAllSelected() ? 'deselect' : 'select'} all`;
    }
    return `${this.selection.isSelected(row) ? 'deselect' : 'select'} row ${row.position + 1}`;
  }

  handleUpload(event: any, tipoCatalogoId: number) {
    const file = event.target.files[0];
    let nombreArchivo = file.name
    let ext = nombreArchivo.split('.').pop();
    if (this.formatos.includes(ext)) {
      if (file.size <= 500000) {
        const reader = new FileReader();
        reader.readAsDataURL(file);
        reader.onload = () => {
          this.selection.selected.filter((item: any) => {
            if (item.tipoCatalogoId === tipoCatalogoId) {
              let result = reader.result as string;
              var base64 = result.replace(/^data:(.*,)?/, "");
              item.file = base64
              item.nombreArchivo = nombreArchivo
            }
          })
        };
      } else {
        this.f['file'].reset();
        this.mensajeService.openWarningSnackBar(`El tamaño máximo es de 500KB`, 3000)

      }
    } else {
      this.f['file'].reset();
      this.mensajeService.openWarningSnackBar(`Solo se acepta formatos: ${this.formatos}`, 4000)
    }

  }


}
