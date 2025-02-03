package com.learning.leet.code;

import java.util.Arrays;
import java.util.Stack;

public class AsteroidCollision {

    public static void main(String[] args) {
        AsteroidCollision a = new AsteroidCollision();
        System.out.println(Arrays.toString(a.asteroidCollision(new int[]{10, 2, -5})));
        /*System.out.println(Arrays.toString(a.asteroidCollision(new int[]{5, 10, -5})));
        System.out.println(Arrays.toString(a.asteroidCollision(new int[]{8, -8})));*/
    }

    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<>();
        for (int asteroid : asteroids) {
            if (stack.isEmpty()) {
                stack.push(asteroid);
            } else {
                int last = stack.peek();
                if ((asteroid > 0 && last > 0) || (asteroid < 0 && last < 0)) {
                    stack.push(asteroid);
                } else {
                    if (Math.abs(asteroid) == Math.abs(last)) {
                        stack.pop();
                    } else if (Math.abs(asteroid) > Math.abs(last)) {
                        stack.pop();
                        stack.push(asteroid);
                    }
                }
            }
        }
        int[] result = new int[stack.size()];
        while (!stack.isEmpty()) {
            result[stack.size() - 1] = stack.pop();
        }
        return result;
    }
}
