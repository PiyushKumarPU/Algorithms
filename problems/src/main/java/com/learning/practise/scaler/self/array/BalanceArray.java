package com.learning.practise.scaler.self.array;

public class BalanceArray {

    /*public static void main(String[] args) {

       // System.out.println(getSpecialElementCount(List.of(2, 1, 6, 4)));
        System.out.println(getSpecialElementCountShort(List.of(2, 1, 6, 4)));
    }

    private static int getSpecialElementCount(List<Integer> arr) {
        int specialElementCount = 0;
        for (int index = 0; index < arr.size(); index++) {
            int leftEven = 0, leftOdd = 0, rightEven = 0, rightOdd = 0;
            for (int i = 0; i < index; i++) {
                if (i % 2 == 0) {
                    leftEven += arr.get(i);
                } else {
                    leftOdd += arr.get(i);
                }
            }
            for (int i = index + 1; i < arr.size(); i++) {
                if (i % 2 == 0) {
                    rightEven += arr.get(i);
                } else {
                    rightOdd += arr.get(i);
                }
            }
            if (leftOdd + rightEven == rightOdd + leftEven) specialElementCount++;
        }
        return specialElementCount;
    }

    private static int getSpecialElementCountShort(List<Integer> arr) {
        int specialElementCount = 0;
        for (int index = 0; index < arr.size(); index++) {
            int evenSum =0, oddSum =0;
            for (int i = 0; i < arr.size(); i++) {
                if(i == index) continue;
                if (i % 2 == 0) {
                    evenSum += arr.get(i);
                } else {
                    oddSum += arr.get(i);
                }
            }
            if (evenSum == oddSum) specialElementCount++;
        }
        return specialElementCount;
    }

    private static boolean isBalanceArray(List<Integer> integerList, List<Integer> indexToIgnore) {
        int evenSum = 0;
        int oddSum = 0;
        for (int i = 0; i < integerList.size(); i++) {
            if (indexToIgnore.contains(i)) {
                continue;
            }
            if (i % 2 == 0) {
                evenSum += integerList.get(i);
            } else {
                oddSum += integerList.get(i);
            }
        }
        return evenSum == oddSum;
    }

    private static int calculateDifference(List<Integer> integerList) {
        int oddSum = 0;
        int evenSum = 0;
        for (int index = 0; index < integerList.size(); index++) {
            if (index % 2 == 0) {
                evenSum += integerList.get(index);
            } else {
                oddSum += integerList.get(index);
            }
        }

        if (oddSum == evenSum) {
            System.out.println("Balanced array");
        } else {
            int diff = evenSum > oddSum ? evenSum - oddSum : oddSum - evenSum;
            if (integerList.indexOf(diff) > -1) {
                integerList.remove(diff);
                return 1;
            }
        }
        return 0;

    }*/
}
