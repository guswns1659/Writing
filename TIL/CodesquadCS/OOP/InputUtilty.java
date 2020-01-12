package CodesquadCS.OOP;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class InputUtilty {

    private static final int MAX_NUMBER = 24;
    private static final int MIN_NUMBER = 0;

    
    public String askCoordinate() {
        System.out.println("값을 입력하세요. ex) (1,2)-(3,4)-(5,6)");
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

    
    public int[] inputParser(String coordinates) {
        String replacedCoordinates= coordinates.replaceAll("[()]", "").replace("-", ",");
        String[] splitCoordinates = replacedCoordinates.split(",");
        int[] integerCoordinates = Arrays.stream(splitCoordinates).mapToInt(Integer::parseInt).toArray();
        return integerCoordinates;
    }

    
    public boolean isVaildCoordinate(int[] integerCoordinates) {
        for (int coordinate : integerCoordinates) {
            if ( coordinate > MAX_NUMBER && coordinate < MIN_NUMBER) {
                return false;
            }
        }
        return true;
    }

    public List<Points> returnPointsArr(int[] integerCoordinates) {
        List<Points> points = new ArrayList<>();
        if(isVaildCoordinate(integerCoordinates)) {
            return points = checkCountOfCoordinate(integerCoordinates);
        } else {
            return points;
        }

    }

    public List<Points> checkCountOfCoordinate(int[] integerCoordinates) {
        PointsChanger pointsChanger = new PointsChanger();
        List<Points> points = new ArrayList<>();
        if (integerCoordinates.length == 4) {
            return points = pointsChanger.fourCoordinatesToTwoPoints(integerCoordinates);
        } else if (integerCoordinates.length == 6) {
            return points = pointsChanger.sixCoordinatesToThreePoints(integerCoordinates);
        } else {
            return points = pointsChanger.eightCoordinatesToFourPoints(integerCoordinates);
        }

    }

}
