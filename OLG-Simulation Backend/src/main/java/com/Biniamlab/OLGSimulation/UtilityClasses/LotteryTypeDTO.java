package com.Biniamlab.OLGSimulation.UtilityClasses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@Data
@NoArgsConstructor
@AllArgsConstructor
public class LotteryTypeDTO {
    private String lotteryName;
    private int lowerLimit;
    private int upperLimit;
    private int numberOfNumbers;
    private int numberOfLines;
}
