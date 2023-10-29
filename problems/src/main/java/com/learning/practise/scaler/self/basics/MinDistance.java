package com.learning.practise.scaler.self.basics;

public class MinDistance {

    public static void main(String[] args) {
        System.out.println(findMinDistance("o..o.xx.ooo.x.o.o"));
        System.out.println(findMinDistanceShort("o..o.xx.ooo.x.o.o"));
    }

    private static int findMinDistance(String str){
        if(str.indexOf('x') >=0 && str.indexOf('o') >=0){
            int startIndex = -1;
            char startElement = ' ';
            int minDistance = Integer.MAX_VALUE;
            char[] chars = str.toCharArray();
            for(int i = 0; i< chars.length;i++){
                if('x' == chars[i] && (startElement == ' ' || startElement == 'x')){
                   startElement = 'x';
                   startIndex = i;
                }
                else if('o' == chars[i] && (startElement == ' ' || startElement == 'o')){
                    startElement = 'o';
                    startIndex = i;
                }
                else if('x' == chars[i] &&  startIndex > -1 && startElement != 'x'){
                    int distance = Math.abs(i-startIndex);
                    minDistance =  distance < minDistance ? distance : minDistance;
                    startIndex = i;
                    startElement = 'x';
                }
                else if('o' == chars[i] && startIndex > -1 && startElement != 'o'){
                    int distance = Math.abs(i-startIndex);
                    minDistance =  distance < minDistance ? distance : minDistance;
                    startIndex = i;
                    startElement = 'o';
                }
            }
            return minDistance;
        }
        return -1;
    }

    private static int findMinDistanceShort(String str){
        if(str.indexOf('x') >=0 && str.indexOf('o') >=0){
            int startIndex = -1;
            char startElement = ' ';
            int minDistance = Integer.MAX_VALUE;
            char[] chars = str.toCharArray();
            for(int i = 0; i< chars.length;i++){
                if('x' == chars[i] && (startElement == ' ' || startElement == 'x')){
                    startElement = 'x';
                    startIndex = i;
                }
                else if('o' == chars[i] && (startElement == ' ' || startElement == 'o')){
                    startElement = 'o';
                    startIndex = i;
                }
                else if(startIndex > -1 && startElement != ' ' && (chars[i] == 'x' || chars[i] == 'o' )){
                    if(chars[i] != startElement){
                        int distance = Math.abs(i-startIndex);
                        minDistance =  distance < minDistance ? distance : minDistance;
                        startIndex = i;
                    }
                    startElement = chars[i];
                }
            }
            return minDistance;
        }
        return -1;
    }
}
