import { HttpErrorResponse } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { Insurance } from './insurance';
import { InsuranceService } from './insurance.service';

@Component({
  selector: 'app-insurance',
  templateUrl: './insurance.component.html',
  styleUrls: ['./insurance.component.css']
})
export class InsuranceComponent implements OnInit {
  insurances: Insurance[];
  editInsurance: Insurance;
  deleteInsurance: Insurance;

  constructor(private insuranceService: InsuranceService) {}

  ngOnInit(): void {
      this.getInsurances();
  }

  public getInsurances(): void {
    this.insuranceService.getInsurances().subscribe(
      (res: Insurance[]) => {
        this.insurances = res;
      },
      (err: HttpErrorResponse) => {
        alert("No permission");
      }
    );
  }

  public onOpenModal(insurance: any, mode: string): void{
    const container = document.getElementById('main-container');
    const button = document.createElement('button');
    button.type = 'button';
    button.style.display = 'none';
    button.setAttribute('data-bs-toggle', 'modal');
    if(mode === 'add'){
      button.setAttribute('data-bs-target', '#addInsuranceModal');
    }
    else if(mode === 'edit'){
      this.editInsurance = insurance;
      button.setAttribute('data-bs-target', '#updateInsuranceModal');
    }
    else if(mode === 'delete'){
      this.deleteInsurance = insurance;
      button.setAttribute('data-bs-target', '#deleteInsuranceModal');
    }
    container?.appendChild(button);
    button.click();
  }

  public onAddInsurance(addForm: NgForm): void{
    document.getElementById('add-insurance-form')?.click();
    this.insuranceService.addInsurance(addForm.value).subscribe(
      (res: Insurance) => {
        console.log(res);
        this.getInsurances();
        addForm.reset();
      },
      (err: HttpErrorResponse) => {
        alert("No permission");
        addForm.reset();
      }
    );
  }

  public onUpdateInsurance(insurance: Insurance): void{
    this.insuranceService.updateInsurance(insurance).subscribe(
      (res: Insurance) => {
        console.log(res);
        this.getInsurances();
      },
      (err: HttpErrorResponse) => {
        alert("No permission");
      }
    );
  }

  public onDeleteInsurance(insuranceId: number): void{
    document.getElementById('delete-insurance-form')?.click();
    this.insuranceService.deleteInsurance(insuranceId).subscribe(
      (res: void) => {
        console.log(res);
        this.getInsurances();
      },
      (err: HttpErrorResponse) => {
        alert("No permission");
      }
    );
  }
}
