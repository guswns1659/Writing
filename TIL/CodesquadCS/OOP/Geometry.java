package CodesquadCS.OOP;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Geometry {

    public String command() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("> 좌표");
        String coordinate = scanner.nextLine();
        return coordinate;
    }

    public int[] coordinate2Num(String coordinate){
        int[] numArr;
        if(coordinate.length() > 6) {
            numArr = doubleCoordinate2Num(coordinate);
        } else {
            numArr = singleCoordinate2Num(coordinate);
        }
        return numArr;
    }

    public int[] singleCoordinate2Num(String coordinate) {
        String replaceStr = coordinate.replace("(", "");
        String replaceStr2 = replaceStr.replace(")", "");
        String[] splitStr = replaceStr2.split(",");
        int[] numStr = Arrays.stream(splitStr).mapToInt(Integer::parseInt).toArray();
        return numStr;
    }

    public int[] doubleCoordinate2Num(String coordinate) {
        String replaceStr= coordinate.replace("(", "");
        replaceStr = replaceStr.replace(")", "");
        replaceStr = replaceStr.replace("-", ",");
        String[] splitStr = replaceStr.split(",");
        int[] numStr = Arrays.stream(splitStr).mapToInt(Integer::parseInt).toArray();
        return numStr;
    }

    public ArrayList<Double> getDistance(int[] numArr) {
        ArrayList<Double> distances;
        if ( numArr.length == 4) {
             distances = getDistanceOfTwoCoordinate(numArr);
        } else if (numArr.length == 6 ) {
            distances = getDistanceOfThreeCoordinate(numArr);
        } else {
            distances = getDistanceOfFourCoordinate(numArr);

        }
        return distances;
    }

    public ArrayList<Double> getDistanceOfTwoCoordinate(int[] numArr) {
        ArrayList<Double> answer = new ArrayList<>();
        int x1 = numArr[0];
        int y1 = numArr[1];
        int x2 = numArr[2];
        int y2 = numArr[3];
        double result = Math.pow(Math.abs((x2-x1)),2) + Math.pow(Math.abs((y2-y1)),2);
        double distance = Math.sqrt(result);
        answer.add(distance);
        return answer;

    }

    public ArrayList<Double> getDistanceOfThreeCoordinate(int[] numArr) {
        ArrayList<Double> answer = new ArrayList<>();
        int x1 = numArr[0];
        int y1 = numArr[1];
        int x2 = numArr[2];
        int y2 = numArr[3];
        int x3 = numArr[4];
        int y3 = numArr[5];
        double distanceA = Math.sqrt(Math.pow(Math.abs((x2-x1)),2) + Math.pow(Math.abs((y2-y1)),2));
        double distanceB = Math.sqrt(Math.pow(Math.abs((x3-x1)),2) + Math.pow(Math.abs((y3-y1)),2));
        double distanceC = Math.sqrt(Math.pow(Math.abs((x3-x2)),2) + Math.pow(Math.abs((y3-y2)),2));

        answer.add(distanceA);
        answer.add(distanceB);
        answer.add(distanceC);
        return answer;
    }
    public ArrayList<Double> getDistanceOfFourCoordinate(int[] numArr) {
        ArrayList<Double> answer = new ArrayList<>();
        int x1 = numArr[0];
        int y1 = numArr[1];
        int x2 = numArr[2];
        int y2 = numArr[3];
        int x3 = numArr[4];
        int y3 = numArr[5];
        int x4 = numArr[6];
        int y4 = numArr[7];
        double distanceA = Math.sqrt(Math.pow(Math.abs((x2-x1)),2) + Math.pow(Math.abs((y2-y1)),2));
        double distanceB = Math.sqrt(Math.pow(Math.abs((x3-x1)),2) + Math.pow(Math.abs((y3-y1)),2));
        double distanceC = Math.sqrt(Math.pow(Math.abs((x4-x1)),2) + Math.pow(Math.abs((y4-y1)),2));
        double distanceD = Math.sqrt(Math.pow(Math.abs((x3-x2)),2) + Math.pow(Math.abs((y3-y2)),2));
        double distanceE = Math.sqrt(Math.pow(Math.abs((x4-x2)),2) + Math.pow(Math.abs((y4-y2)),2));
        double distanceF = Math.sqrt(Math.pow(Math.abs((x4-x3)),2) + Math.pow(Math.abs((y4-y3)),2));

        answer.add(distanceA);
        answer.add(distanceB);
        answer.add(distanceC);
        answer.add(distanceD);
        answer.add(distanceE);
        answer.add(distanceF);
        return answer;
    }


    public void printCoordinate(int x, int y) {
        for (int i = 24; i > y; i--) {
            System.out.printf("%3d|\n", i);
        }
        System.out.printf("%3d|", y);

        for (int i = 0; i < x; i++) {
            System.out.print("   ");
        }
        System.out.println("●");
        for (int i = y-1; i > 0; i--) {
            System.out.printf("%3d|\n", i);
        }
        System.out.print("   +");
        for (int i = 0; i < 95; i++) {
            System.out.print("-");
        }
        System.out.println();
        for (int i = 0; i < 25; i++) {
            System.out.printf("%4d", i);
        }
    }

}


