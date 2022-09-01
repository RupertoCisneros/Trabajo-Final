import { Component, OnInit } from '@angular/core';
import { AbstractControl, UntypedFormBuilder, UntypedFormControl, UntypedFormGroup, Validators } from '@angular/forms';
import { MatDialogRef } from '@angular/material/dialog';
import { ValidacionesPropias } from '@global/Validaciones';

@Component({
  selector: 'app-buscar-username',
  templateUrl: './buscar-username.component.html',
  styleUrls: ['./buscar-username.component.css']
})

export class BuscarUsernameComponent implements OnInit {
  form: UntypedFormGroup = new UntypedFormGroup({
    username: new UntypedFormControl(''),
  });
  constructor(
    public dialogRef: MatDialogRef<BuscarUsernameComponent>,
    private formBuilder: UntypedFormBuilder) {
    this.form = this.formBuilder.group({
      username: ['', [Validators.required]],
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
