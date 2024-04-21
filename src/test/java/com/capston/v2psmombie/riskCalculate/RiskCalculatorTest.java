package com.capston.v2psmombie.riskCalculate;

import com.capston.v2psmombie.domain.User;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

class RiskCalculatorTest {
    List<User> users;
    User car;

    @BeforeEach
    public void setRiskCalculatorTestBasicData() {
        users = createSmombiesTestData();
        car = createCarTestData();
    }


    @DisplayName("생성자 빌더패턴 적용 테스트")
    @Test
    public void riskCalculatorBuilderTest() {
        // given
        RiskCalculator calculator = RiskCalculator.builder(users, car)
                .carDeceleration(2.0)
                .build();

        // when
        Double decelerationValue = calculator.getCarDeceleration();

        // then
        Assertions.assertThat(decelerationValue).isEqualTo(2.0);
    }



    private List<User> createSmombiesTestData() {
        List<User> smombies = new ArrayList<>();
        User user1 = User.builder(UUID.randomUUID().toString(), false)
                .latitude(37.1234)
                .longitude(127.5678)
                .speed(30)
                .direction(30)
                .mode(false)
                .smombie(true)
                .build();
        smombies.add(user1);

//        User user2 = User.builder(UUID.randomUUID().toString(), false)
//                .latitude(37.1234)
//                .longitude(127.5678)
//                .speed(30)
//                .direction(480)
//                .mode(false)
//                .smombie(true)
//                .build();
//        smombies.add(user2);

        return smombies;
    }

    private User createCarTestData() {
        return User.builder(UUID.randomUUID().toString(), true)
                .latitude(37.5678)
                .longitude(127.1234)
                .speed(30)
                .direction(120)
                .mode(true)
                .smombie(false)
                .build();
    }

}