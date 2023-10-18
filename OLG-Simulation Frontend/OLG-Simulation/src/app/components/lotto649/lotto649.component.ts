import { Component, OnInit } from '@angular/core';
import { filter, map } from 'rxjs';
import { LotteryTypes } from 'src/app/lottery-types';
import { LotteryService } from 'src/app/services/lottery.service';

@Component({
  selector: 'app-lotto649',
  templateUrl: './lotto649.component.html',
  styleUrls: ['./lotto649.component.css']
})
export class Lotto649Component implements OnInit {

  lotteryInfo!: LotteryTypes
  

  constructor(private lotteryService: LotteryService){}

  ngOnInit(): void {
    this.lotteryService.getLotteryInfo().pipe(map( response => response.filter((lotteryInfo ) => lotteryInfo.lotteryName === "LOTTO649")))
                                        .subscribe({
                                                    next: (filteredInfo: LotteryTypes[])=>{ this.lotteryInfo = filteredInfo[0] },
                                                    error: (error: Error)=>{ console.log(error.stack)} 
                                                  });
  }

}
