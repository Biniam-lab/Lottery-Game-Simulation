package com.Biniamlab.OLGSimulation.UtilityClasses;

import com.Biniamlab.OLGSimulation.Constant.LotteryType;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class LottoMaxTicketGenerator extends RandomLotteryNumberGenerator{

    public LottoMaxTicketGenerator(){
        super(LotteryType.LOTTOMAX);
    }

    @Override
    public String[] generateTicket(List<Integer> generatedLine) {
        String[] ticket = new String[LotteryType.LOTTOMAX.getNumberOfLines()];
        for(int i = 0; i < ticket.length; i++){
            if (i == 0){
                ticket[i] = generatedLine.toString();
                continue;
            }
            ticket[i] = super.generateLine().toString();
        }
        return ticket;
    }
}
