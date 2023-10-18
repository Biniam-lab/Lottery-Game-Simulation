import { Component, Input, OnInit } from '@angular/core';
import { LotteryService } from 'src/app/services/lottery.service';

@Component({
  selector: 'app-grid',
  templateUrl: './grid.component.html',
  styleUrls: ['./grid.component.css']
})
export class GridComponent implements OnInit {

  @Input() upperLimit!: number;
  @Input() numberOfNumbers!: number;
  @Input() lotteryName!: string;
  numbers: number[] = [];
  selectedNumbers: number[] = [];
  selectionsCount: number = this.selectedNumbers.length;

  constructor(private lotteryService: LotteryService){}

  ngOnInit(): void {
    this.numbers = Array.from({ length: this.upperLimit }, (_, i) => i + 1);
  }

  selectNumber(number: number){
    const index = this.selectedNumbers.indexOf(number);

    if (index === -1){
      if (this.selectionsCount < this.numberOfNumbers){
        this.selectedNumbers.push(number);
        this.selectionsCount++;
      }
    }
    else{
      this.selectedNumbers.splice(index,1);
      this.selectionsCount--;
    }
      
    if (this.selectionsCount === this.numberOfNumbers) {
        this.sendSelectedNumbers();
    }
  }

  getRandomGeneratedNumbers(){
    this.lotteryService.getGeneratedLine(this.lotteryName).subscribe({
                                                                      next: (response: number[]) =>{ this.selectedNumbers = response; this.selectionsCount = response.length},
                                                                      error: (error: Error) => console.log(error.stack)
                                                                    });
                                                                    
                                                                                  
  }

  sendSelectedNumbers(){}
  
  
  

}
