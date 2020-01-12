package CodesquadCS.OOP;

import java.util.List;

public class Inputer {
    public List<Points> start() {
        InputUtilty inputUtilty = new InputUtilty();
        int[] integerCoordinates = inputUtilty.inputParser(inputUtilty.askCoordinate());
        List<Points> pointsList = inputUtilty.returnPointsArr(integerCoordinates);
        return pointsList;
    }
}
