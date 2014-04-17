package main.java.com.lenzi.cookie;

/**
 * @author rlenzi
 */
public class CookieFarm {

    private final double C;
    private final double F;
    private final double X;

    private final int P;

    public CookieFarm(double farmValue, double farmProduction, double goal) {
        C = farmValue;
        F = farmProduction;
        X = goal;

        P = 2;
    }

    public double calculate() {
        return timeToGoal(0.0, 0.0, 0);
    }

    private double timeToGoal(Double accSeconds, Double accCookies, Integer farms) {
        if (accCookies >= X) {
            return accSeconds;
        }
        else {
            double productionPerSecond = (P + (farms * F));
            double secondsToFarm = C / productionPerSecond;
            double secondsToGoal = (X - accCookies) / productionPerSecond;

            if (secondsToFarm <= secondsToGoal) {

                double keepClicking = timeToGoal(accSeconds + secondsToFarm, accCookies + C, farms);
                double buyFarm;
                if (accSeconds + secondsToFarm > ( X / P ))
                    buyFarm = timeToGoal(accSeconds + secondsToFarm, accCookies, farms + 1);
                else
                    buyFarm = Double.MAX_VALUE;

                if (buyFarm < keepClicking)
                    return buyFarm;
                else
                    return keepClicking;
            }
            else {
                return accSeconds + secondsToGoal;
            }

        }
    }

}
