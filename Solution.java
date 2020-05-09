import java.util.ArrayList;

public class Solution {

    public int addFive(int Num) {
        int absValue = Math.abs(Num);
        String strVal = String.valueOf(absValue);
        char[] charArrVal = strVal.toCharArray();

        ArrayList strArrList = new ArrayList();

        // Did it this way because the default Arrays.asList() constructor wasn't working,
        // and debugging would take too long (for a timed test)
        for (int i = 0; i < charArrVal.length; i++) {
            strArrList.add(String.valueOf(charArrVal[i]));
        }

        int[] possibleValues = new int[charArrVal.length + 1];

        for (int j = 0; j < strArrList.size() + 1; j++) {
            strArrList.add(j, "5");

            // This was the point that I got stuck on in the online test.
            // You cannot use ArrayList.toArray() to create an array of primitive type (in my case char)
            // So I got around that by using an array of Strings instead
            String[] newStrArr = new String[strArrList.size()];
            newStrArr = (String[]) strArrList.toArray(newStrArr);

            possibleValues[j] = Integer.parseInt(String.join("", newStrArr));
            strArrList.remove(j);
        }

        if (Num < 0) {
            return findSmallest(possibleValues) * -1;
        } else {
            return findGreatest(possibleValues);
        }

    }

    private int findGreatest(int[] valArr) {
        int greatest = valArr[0];
        for (int i = 1; i < valArr.length; i++) {
            if (valArr[i] > greatest) {
                greatest = valArr[i];
            }
        }
        return greatest;
    }

    private int findSmallest(int[] valArr) {
        int smallest = valArr[0];
        for (int i = 1; i < valArr.length; i++) {
            if (valArr[i] < smallest) {
                smallest = valArr[i];
            }
        }
        return smallest;
    }

    // (Positive)Find the first number that's less than 5, and add the five to the left of it
    // (Negative)Find the first number that's greater than 5, and add the five to the left of it
    public int addFiveImproved(int Num) {

        int absValue = Math.abs(Num);
        String strVal = String.valueOf(absValue);
        char[] charArrVal = strVal.toCharArray();

        ArrayList<String> strArrList = new ArrayList<String>();

        // Did it this way because the default Arrays.asList() constructor wasn't working,
        // and debugging would take too long (for a timed test)
        for (int i = 0; i < charArrVal.length; i++) {
            strArrList.add(String.valueOf(charArrVal[i]));
        }

        boolean foundSpot = false;
        int j = 0;

        while(!foundSpot && j < strArrList.size()) {
            if (Num < 0) {
                if (Integer.parseInt(strArrList.get(j)) > 5) {
                    strArrList.add(j, "5");
                    foundSpot = true;
                }
            } else {
                if (Integer.parseInt(strArrList.get(j)) < 5) {
                    strArrList.add(j, "5");
                    foundSpot = true;
                }
            }
            j++;
        }

        if (!foundSpot) {
            strArrList.add("5");
        }


        String[] ansArr = new String[strArrList.size()];
        ansArr = (String[]) strArrList.toArray(ansArr);

        return (Num < 0) ? Integer.parseInt(String.join("", ansArr)) * -1 : Integer.parseInt(String.join("", ansArr));
    }


}
