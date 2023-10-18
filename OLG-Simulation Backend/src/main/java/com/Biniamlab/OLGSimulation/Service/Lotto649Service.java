package com.Biniamlab.OLGSimulation.Service;

import com.Biniamlab.OLGSimulation.Constant.LotteryType;
import com.Biniamlab.OLGSimulation.Constant.Status;
import com.Biniamlab.OLGSimulation.DataModel.Ticket;
import com.Biniamlab.OLGSimulation.Repository.TicketRepository;
import com.Biniamlab.OLGSimulation.UtilityClasses.DrawDateCalculator;
import com.Biniamlab.OLGSimulation.UtilityClasses.Lotto649TicketGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class Lotto649Service implements TicketService {

    private final Lotto649TicketGenerator lotto649TicketGenerator;
    private final TicketRepository ticketRepository;

    @Autowired
    public Lotto649Service(Lotto649TicketGenerator lotto649TicketGenerator, TicketRepository ticketRepository) {
        this.lotto649TicketGenerator = lotto649TicketGenerator;
        this.ticketRepository = ticketRepository;
    }

    @Override
    public List<Integer> generateLine() {
        return lotto649TicketGenerator.generateLine();
    }

    @Override
    public Ticket generateTicket(List<Integer> generatedLine) {
        Ticket ticket = new Ticket();
        DrawDateCalculator drawDateCalculator = new DrawDateCalculator();
        String selectedTicket = lotto649TicketGenerator.generateTicket(generatedLine).toString();
        ticket.setSelectedLine(selectedTicket);
        ticket.setLotteryType(LotteryType.LOTTO649);
        ticket.setDateOfDraw(drawDateCalculator.calculateDateOfDrawForLotto649(LocalDateTime.now()));
        ticket.setStatus(Status.WAITING_FOR_DRAW);

        return ticketRepository.save(ticket);

    }

    @Override
    public List<Ticket> findAllTicketsByLotteryType() {
        return ticketRepository.findAllTicketsByLotteryType(LotteryType.LOTTO649);
    }
}
