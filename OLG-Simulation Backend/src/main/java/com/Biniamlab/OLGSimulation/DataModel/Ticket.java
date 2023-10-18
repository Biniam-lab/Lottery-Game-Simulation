package com.Biniamlab.OLGSimulation.DataModel;

import com.Biniamlab.OLGSimulation.Constant.LotteryType;
import com.Biniamlab.OLGSimulation.Constant.Status;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Ticket {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "ticket_id")
    private UUID ticketID;

    @Column(name = "date_of_purchase")
    @CreationTimestamp
    private LocalDateTime dateOfPurchase;

    @Column(name = "date_of_draw")
    private LocalDate dateOfDraw;

    @Column(name = "selected_line")
    private String selectedLine;

    @Column(name = "lottery_type")
    @Enumerated(value= EnumType.STRING)
    private LotteryType lotteryType;

    @Column(name = "status")
    @Enumerated(value= EnumType.STRING)
    private Status status;

}
