package utils;

import java.util.Random;

/**
 * Created with IntelliJ IDEA.
 * User: ng1
 * Date: 6/13/13
 * Time: 6:34 PM
 * To change this template use File | Settings | File Templates.
 */
public class GetRandomsUtils {
    public static int getRandomNumber(int startNumber, int endNumber) {
        Random randomGenerator = new Random();
        long range = (long) startNumber- (long) endNumber+1;

        long fraction = (long) (range * randomGenerator.nextDouble());
        int randomNumber = (int) (fraction + startNumber);
        return (Math.abs(randomNumber)==0)?getRandomNumber(startNumber, endNumber):Math.abs(randomNumber);

    }

}
