import { Component, Inject } from '@angular/core';
import { MatDialogRef, MAT_DIALOG_DATA } from '@angular/material/dialog';

@Component({
  selector: 'app-confirmacion',
  templateUrl: './confirmacion.component.html',
  styleUrls: ['./confirmacion.component.css']
})
export class ConfirmacionComponent {

  constructor(
    public dialogRef: MatDialogRef<ConfirmacionComponent>,
    @Inject(MAT_DIALOG_DATA) public data: any) { }


}
