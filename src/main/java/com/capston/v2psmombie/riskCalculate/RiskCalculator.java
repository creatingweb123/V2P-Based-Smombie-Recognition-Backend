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


    public List<Integer> riskCheck() {
        List<Integer> riskList = new ArrayList<>();
        for (User user : smombieDataList) {
            double time = MeetingCalculator.timeToMeet(user, carData);
            if(time<=0||time>40) riskList.add(100);
            else if(time<15) riskList.add(1);
            else if(time<25) riskList.add(2);
            else riskList.add(3);
        }
    }
}
