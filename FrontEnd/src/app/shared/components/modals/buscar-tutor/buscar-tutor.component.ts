import { Component, Inject, OnInit } from '@angular/core';
import { AbstractControl, UntypedFormBuilder, UntypedFormControl, UntypedFormGroup, Validators } from '@angular/forms';
import { MatDialogRef, MAT_DIALOG_DATA } from '@angular/material/dialog';
import { ValidacionesPropias } from '@global/Validaciones';

@Component({
  selector: 'app-buscar-tutor',
  templateUrl: './buscar-tutor.component.html',
  styleUrls: ['./buscar-tutor.component.css']
})
export class BuscarTutorComponent implements OnInit {
  form: UntypedFormGroup = new UntypedFormGroup({
    cedula: new UntypedFormControl(''),
  });
  constructor(
    public dialogRef: MatDialogRef<BuscarTutorComponent>,
    private formBuilder: UntypedFormBuilder,
    @Inject(MAT_DIALOG_DATA) public data: any,) {
    this.form = this.formBuilder.group({
      cedula: ['', [Validators.required,ValidacionesPropias.validarCedula]],
 });
   }
  get f(): { [key: string]: AbstractControl } {
    return this.form.controls;
  }
  ngOnInit(): void {
  }

  buscarCedula(){
    if (!this.form.invalid) {
      this.dialogRef.close(this.form.value)
    }
  }

}
