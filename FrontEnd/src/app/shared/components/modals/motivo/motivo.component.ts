import { Component, Inject, OnInit } from '@angular/core';
import { AbstractControl, UntypedFormBuilder, UntypedFormControl, UntypedFormGroup, Validators } from '@angular/forms';
import { MatDialogRef, MAT_DIALOG_DATA } from '@angular/material/dialog';

@Component({
  selector: 'app-motivo',
  templateUrl: './motivo.component.html',
  styleUrls: ['./motivo.component.css']
})
export class MotivoComponent implements OnInit {

  form = new UntypedFormGroup({
    motivo: new UntypedFormControl(''),
  });
  
  constructor(
    private dialogRef: MatDialogRef<MotivoComponent>,
    private formBuilder: UntypedFormBuilder,
    @Inject(MAT_DIALOG_DATA) public data: any) {
    this.form = this.formBuilder.group({
      motivo: ['',[Validators.required]]
    });
   }
   get f(): { [key: string]: AbstractControl } {
    return this.form.controls;
  }
  
  ngOnInit(): void {
    
  }
  enviarMotivo(){
    if (this.form.invalid) {
      
    }else{
      this.dialogRef.close(this.form.value);
    }
  }


}
