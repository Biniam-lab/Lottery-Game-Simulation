package com.Biniamlab.OLGSimulation.Repository;

import com.Biniamlab.OLGSimulation.Constant.LotteryType;
import com.Biniamlab.OLGSimulation.DataModel.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;
import java.util.UUID;

@Repository
public interface TicketRepository extends JpaRepository<Ticket, UUID> {
    List<Ticket> findAllTicketsByLotteryType(LotteryType lottomax);
}
