package com.capston.v2psmombie.riskCalculate;

import com.capston.v2psmombie.domain.User;
import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Builder
@Getter
public class RiskCalculator {
    private List<User> smombieDataList;
    private User carData;

    @Builder
    public RiskCalculator(
            List<User> smombieDataList,
            User carData
    ) {
        this.smombieDataList = smombieDataList;
        this.carData = carData;
    }

    public static RiskCalculatorBuilder builder(List<User> users, User car){
        RiskCalculatorBuilder calculatorBuilder = new RiskCalculatorBuilder();
        calculatorBuilder.smombieDataList(users);
        calculatorBuilder.carData(car);
        return calculatorBuilder;
    }


    public int riskCheck() {
        double dif = findMinTime();
        if (dif > 30) {
            return 3;
        } else if (dif > 10) {
            return 2;
        } else {
            return 1;
        }
    }
    private double findMinTime() {
        double minMeetingTime = Double.MAX_VALUE;
        for (User user : smombieDataList) {
            double tmp = MeetingCalculator.timeToMeet(user, carData);
            if(tmp>0) minMeetingTime = Double.min(minMeetingTime, tmp);
        }
        return minMeetingTime;
    }

}
