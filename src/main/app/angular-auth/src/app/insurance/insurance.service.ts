import { HttpClient, HttpHeaders } from "@angular/common/http";
import { Inject, Injectable } from "@angular/core";
import { Observable } from "rxjs";
import { environment } from "src/environments/environment";
import { Insurance } from "./insurance";

@Injectable({providedIn: 'root'})
export class InsuranceService {
    private apiServerUrl = environment.apiBaseUrl;

    constructor(private http: HttpClient) { }
    
    public getInsurances(): Observable<Insurance[]> {
        const cookies = Object.fromEntries(document.cookie.split('; ').map(v=>v.split('=').map(decodeURIComponent)));
        const headers = new HttpHeaders({
            'Content-Type': 'application/json',
            'Authorization': `Bearer ${[cookies['jwt']]}`
        });
        return this.http.get<Insurance[]>(`${this.apiServerUrl}/insurance/all`, {headers: headers});
    }

    public addInsurance(insurance: Insurance): Observable<Insurance> {
        const cookies = Object.fromEntries(document.cookie.split('; ').map(v=>v.split('=').map(decodeURIComponent)));
        const headers = new HttpHeaders({
            'Content-Type': 'application/json',
            'Authorization': `Bearer ${[cookies['jwt']]}`
        });
        return this.http.post<Insurance>(`${this.apiServerUrl}/insurance/add`, insurance, {headers: headers});
    }

    public updateInsurance(insurance: Insurance): Observable<Insurance> {
        const cookies = Object.fromEntries(document.cookie.split('; ').map(v=>v.split('=').map(decodeURIComponent)));
        const headers = new HttpHeaders({
            'Content-Type': 'application/json',
            'Authorization': `Bearer ${[cookies['jwt']]}`
        });
        return this.http.put<Insurance>(`${this.apiServerUrl}/insurance/update`, insurance, {headers: headers});
    }

    public deleteInsurance(insuranceId: number): Observable<void> {
        const cookies = Object.fromEntries(document.cookie.split('; ').map(v=>v.split('=').map(decodeURIComponent)));
        const headers = new HttpHeaders({
            'Content-Type': 'application/json',
            'Authorization': `Bearer ${[cookies['jwt']]}`
        });
        return this.http.delete<void>(`${this.apiServerUrl}/insurance/delete/${insuranceId}`, {headers: headers});
    }
}