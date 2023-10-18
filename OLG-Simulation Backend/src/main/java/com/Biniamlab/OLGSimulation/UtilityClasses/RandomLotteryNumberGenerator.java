package com.Biniamlab.OLGSimulation.UtilityClasses;

import com.Biniamlab.OLGSimulation.Constant.LotteryType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

@Component
@Data
@AllArgsConstructor
@NoArgsConstructor
public abstract class RandomLotteryNumberGenerator {
    private LotteryType lotteryType;

    public List<Integer> generateLine() {
        List<Integer> generatedLine = new ArrayList<>();
        int randomNumber = getRandomNumber();
        while (generatedLine.size() < lotteryType.getNumberOfNumbers()) {

            if (generatedLine.contains(randomNumber))
                randomNumber = getRandomNumber();
            else
                generatedLine.add(randomNumber);

        }
        Collections.sort(generatedLine);
        return generatedLine;
    }

    private int getRandomNumber() {
        Random random = new Random();
        return (lotteryType.getLowerLimit() + random.nextInt(lotteryType.getUpperLimit()));
    }

    abstract String[] generateTicket(List<Integer> generatedLine);
}
