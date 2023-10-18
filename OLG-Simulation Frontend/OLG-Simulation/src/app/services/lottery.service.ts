import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http'
import { LotteryTypes } from '../lottery-types';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment.development';

@Injectable({
  providedIn: 'root'
})
export class LotteryService {

  constructor(private http: HttpClient) { }

  getLotteryInfo():Observable<LotteryTypes[]>{
    return this.http.get<LotteryTypes[]>(`${environment.apiBaseURL}/info`);
  }


  getGeneratedLine(lotteryType: LotteryTypes["lotteryName"]):Observable<number[]>{
      return this.http.get<number[]>(`${environment.apiBaseURL}/${lotteryType.toLowerCase()}`);
  }
  
}
