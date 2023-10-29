package com.learning.practise.scaler.self;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        /*System.out.println( "Hello World!" );
        List<Integer> A = List.of(1,2,3,4);

        List<List<Integer>> arr = List.of(List.of(1,2,3), List.of(4,5,6), List.of(7,8,9));


        System.out.println(hourglassSum(arr));
        System.out.println(kangaroo(0 ,2 ,5 ,3));
        System.out.println(reverseArray(A));

        System.out.println(isPrime(27));

        System.out.println(findAllDivisior(24));
        System.out.println(findAllPrimeDivisior(24));*/

        //System.out.println(findGCD(80,60));
        //System.out.println(findLCM(10,15));
    }
    /*public static List<Integer> reverseArray(List<Integer> a) {
        int[] result = a.stream().mapToInt(Integer::intValue).toArray();
        int startIndex = 0;
        int endIndex = a.size()-1;
        while(startIndex < endIndex){
            int temp = result[endIndex];
            result[endIndex] = result[startIndex];
            result[startIndex] = temp;
            startIndex++;
            endIndex--;
        }
        return Arrays.stream(result).boxed().collect(Collectors.toList());
    }

    public static int hourglassSum(List<List<Integer>> arr) {
        int maxSum = Integer.MIN_VALUE;
        for(int i = 1 ; i < arr.size()-1; i++){
            for(int j =1 ; j< arr.size()-1; j++){
                List<Integer> prevRow = arr.get(i-1);
                List<Integer> nextRow = arr.get(i+1);
                List<Integer> currentRow = arr.get(i);
                int sum = prevRow.get(j-1) +prevRow.get(j)+prevRow.get(j+1) + currentRow.get(j) +
                nextRow.get(j-1) +nextRow.get(j)+nextRow.get(j+1);
                if(sum > maxSum) maxSum = sum;
            }
        }
        return maxSum;
    }

    public static String kangaroo(int x1, int v1, int x2, int v2) {
        // Write your code here
        int firstJump = x1 + v1;
        int secondJump = x2+v2;
        int lcm = Math.max(firstJump, secondJump);
        while (lcm % firstJump != 0 || lcm % secondJump != 0) {
            ++lcm;
        }
        return lcm / firstJump == lcm / secondJump ?  "YES" : "NO";
    }
    public static boolean isPrime(int number){
        for(int index = 2 ; index <= number/2; index++){
            if(number%2 ==0) return false;
        }
        return true;
    }

    public static List<Integer> findAllDivisior(int number){
        if (number <= 1) return List.of(number);
        List<Integer> result = new ArrayList<>();
        for(int i = 1; i <= number / 2; i++){
            if(number % i ==0) result.add(i);
        }
        return result;
    }

    public static Set<Integer> findAllPrimeDivisior(int number){
        Set<Integer> result = new HashSet<>();
        for(int i = 1; i <= number / 2; i++){
            if(number % i ==0) result.addAll(findAllDivisior(i).stream().map(App::findAllDivisior).flatMap(List::stream).toList());
        }
        return result;
    }

    public static int findGCD(int firstNumber, int secondNumber){
        int gcd = Integer.MIN_VALUE;
        for(int i = 1; i <= Math.min(firstNumber,secondNumber); i++){
            if(firstNumber % i ==0 && secondNumber % i ==0){
                if(i > gcd) gcd = i;
            }
        }
        return gcd == Integer.MIN_VALUE ? -1 : gcd;
    }

    public static int findLCM(int firstNumber, int secondNumber){
        int max = Math.max(firstNumber,secondNumber);
        int min = Math.min(firstNumber,secondNumber);
        for(int i = 2; ;i++){
            if( ((max * i) % min) ==0){
                return max * i;
            }
        }
    }*/
}
