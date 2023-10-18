package com.Biniamlab.OLGSimulation.DataModel;

import com.Biniamlab.OLGSimulation.Constant.LotteryType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.UUID;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class WinningNumber {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id")
    private UUID id;

    @Column(name = "date_of_draw")
    private LocalDate dateOfDraw;

    @Column(name = "winning_number")
    private String winningNumber;

    @Column(name = "lottery_type")
    @Enumerated(value= EnumType.STRING)
    private LotteryType lotteryType;
}
