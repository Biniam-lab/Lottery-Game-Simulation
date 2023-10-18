package com.Biniamlab.OLGSimulation.UtilityClasses;

import com.Biniamlab.OLGSimulation.Constant.LotteryType;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class Lotto649TicketGenerator extends RandomLotteryNumberGenerator{

    public Lotto649TicketGenerator() {
        super(LotteryType.LOTTO649);
    }

    @Override
    public String[] generateTicket(List<Integer> generatedLine) {
        String[] ticket = new String[LotteryType.LOTTO649.getNumberOfLines()];
        ticket[0] = generatedLine.toString();
        return ticket;
    }
}
