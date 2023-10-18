package com.Biniamlab.OLGSimulation.Constant;

import lombok.*;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public enum LotteryType {
    LOTTOMAX(1, 50, 7, 3),
    LOTTO649(1,49,6,1);

    private int lowerLimit;
    private int upperLimit;
    private int numberOfNumbers;
    private int numberOfLines;

    @Override
    public String toString() {
        return "LotteryType{" +
                "lowerLimit=" + lowerLimit +
                ", upperLimit=" + upperLimit +
                ", numberOfNumbers=" + numberOfNumbers +
                ", numberOfLines=" + numberOfLines +
                '}';
    }
}
