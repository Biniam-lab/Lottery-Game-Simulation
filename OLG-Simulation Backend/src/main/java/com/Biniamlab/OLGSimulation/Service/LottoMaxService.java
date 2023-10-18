package com.Biniamlab.OLGSimulation.Service;

import com.Biniamlab.OLGSimulation.Constant.LotteryType;
import com.Biniamlab.OLGSimulation.Constant.Status;
import com.Biniamlab.OLGSimulation.DataModel.Ticket;
import com.Biniamlab.OLGSimulation.Repository.TicketRepository;
import com.Biniamlab.OLGSimulation.UtilityClasses.DrawDateCalculator;
import com.Biniamlab.OLGSimulation.UtilityClasses.LottoMaxTicketGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class LottoMaxService implements TicketService{

    private final LottoMaxTicketGenerator lottoMaxTicketGenerator;
    private final TicketRepository ticketRepository;

    @Autowired
    public LottoMaxService(LottoMaxTicketGenerator lottoMaxTicketGenerator, TicketRepository ticketRepository) {
        this.lottoMaxTicketGenerator = lottoMaxTicketGenerator;
        this.ticketRepository = ticketRepository;
    }

    @Override
    public List<Integer> generateLine() {
        return lottoMaxTicketGenerator.generateLine();
    }

    @Override
    public Ticket generateTicket(List<Integer> generatedLine) {
        Ticket ticket = new Ticket();
        DrawDateCalculator drawDateCalculator = new DrawDateCalculator();
        String selectedTicket = String.join(",", lottoMaxTicketGenerator.generateTicket(generatedLine));
        ticket.setSelectedLine(selectedTicket);
        ticket.setLotteryType(LotteryType.LOTTOMAX);
        ticket.setDateOfDraw(drawDateCalculator.calculateDateOfDrawForLottoMax(LocalDateTime.now()));
        ticket.setStatus(Status.WAITING_FOR_DRAW);

        return ticketRepository.save(ticket);
    }

    @Override
    public List<Ticket> findAllTicketsByLotteryType() {
        return ticketRepository.findAllTicketsByLotteryType(LotteryType.LOTTOMAX);
    }
}
