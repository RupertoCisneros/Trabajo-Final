import { Component, Inject, OnInit } from '@angular/core';
import { MatCheckboxChange } from '@angular/material/checkbox';
import { MatDialogRef, MAT_DIALOG_DATA } from '@angular/material/dialog';

@Component({
  selector: 'app-acuerdo-responsabilidad',
  templateUrl: './acuerdo-responsabilidad.component.html',
  styleUrls: ['./acuerdo-responsabilidad.component.css']
})
export class AcuerdoResponsabilidadComponent {
  IsChecked!: boolean;
  constructor(
    public dialogRef: MatDialogRef<AcuerdoResponsabilidadComponent>,
    @Inject(MAT_DIALOG_DATA) public data: any) {
    this.IsChecked = false;
  }

  OnChange(event: MatCheckboxChange) {
    if (event.checked) {
      this.IsChecked = true
    } else {
      this.IsChecked = false
    }
  }

}
