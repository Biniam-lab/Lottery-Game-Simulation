package com.Biniamlab.OLGSimulation.Service;

import com.Biniamlab.OLGSimulation.Constant.LotteryType;
import com.Biniamlab.OLGSimulation.DataModel.Ticket;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface TicketService {
    List<Integer> generateLine();
    Ticket generateTicket(List<Integer> generatedLine);

    List<Ticket> findAllTicketsByLotteryType();
}
