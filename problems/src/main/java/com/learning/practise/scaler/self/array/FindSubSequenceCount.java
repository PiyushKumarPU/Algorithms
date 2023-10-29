package com.learning.practise.scaler.self.array;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class FindSubSequenceCount {

    public static void main(String[] args) throws IOException {
        String str = new String(new FileInputStream(new File("src/longstring.txt")).readAllBytes());
        int result = solve(str);
        System.out.println(result);
        System.out.println(499999986-result);
    }

    //499999986

    public static int solve(String A) {
        System.out.println(System.currentTimeMillis());
        int count = 0,aCount = 0;
        for(int index = 0; index < A.length(); index++){
            if(A.charAt(index) == 'A') aCount++;
            else if(A.charAt(index) == 'G' && aCount > 0){
                count+= aCount;
            }
        }
        System.out.println(System.currentTimeMillis());
        return count;
    }
}
