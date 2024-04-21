import java.util.List;

public class RiskCalculator {
    private List<User> smombieDataList;
    private User carData;
    private double carDeceleration;

    public RiskCalculator(List<User> smombieDataList, User carData, double carDeceleration) {
        this.smombieDataList = smombieDataList;
        this.carData = carData;
        this.carDeceleration = carDeceleration;
    }

    public int riskCheck() {
        double dif = findMinTime()
                - calculateTimeToStop(calculateTotalStoppingDistance(carData.getSpeed(), 1), carDeceleration);
        if (dif > 30) {
            return 3;
        } else if (dif > 10) {
            return 2;
        } else {
            return 1;
        }
    }

    /* speed: km/h, reactionTime: s */
    public double calculateBrakeReactionDistance(double speed, double reactionTime) {
        return (speed * reactionTime * 3.6) / 1000;
        // Convert km/h to m/s
    }

    // Function to calculate Braking Distance
    public double calculateBrakingDistance(double speed) {
        return (speed * speed * 0.4) / 1000;
        // Convert km/h to m/s
    }

    public double calculateTotalStoppingDistance(double speed, double reactionTime) {
        double brakeReactionDistance = calculateBrakeReactionDistance(speed, reactionTime);
        double brakingDistance = calculateBrakingDistance(speed);
        return brakeReactionDistance + brakingDistance;
    }

    public double calculateTimeToStop(double totalStoppingDistance, double deceleration) {
        return Math.sqrt((-2 * totalStoppingDistance) / deceleration);
    }

    public double findMinTime() {
        double minMeetingTime = Double.MAX_VALUE;
        for (User user : smombieDataList) {
            double tmp = MeetingCalculator.timeToMeet(user, carData);
            if(tmp>0) minMeetingTime = Double.min(minMeetingTime, tmp);
        }
        return minMeetingTime;
    }

}
