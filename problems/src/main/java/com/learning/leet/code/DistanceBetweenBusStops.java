package com.learning.leet.code;

public class DistanceBetweenBusStops {

    public static void main(String[] args) {
        DistanceBetweenBusStops busStops = new DistanceBetweenBusStops();
        /*System.out.println(busStops.distanceBetweenBusStops(new int[]{1, 2, 3, 4}, 0, 1));
        System.out.println(busStops.distanceBetweenBusStops(new int[]{1, 2, 3, 4}, 0, 2));
        System.out.println(busStops.distanceBetweenBusStops(new int[]{1, 2, 3, 4}, 0, 3));*/
        System.out.println(busStops.distanceBetweenBusStops(new int[]{7, 10, 1, 12, 11, 14, 5, 0}, 7, 2));
    }

    public int distanceBetweenBusStops(int[] distance, int start, int destination) {

        // calculate forward distance
        int index = destination, forwardDistance = 0, backwardDistance = 0, length = distance.length;
        while (index != start) {
            forwardDistance += distance[index++];
            index = index % length;
        }

        // calculate backward distance
        index = destination;
        while (index != start) {
            if(index == 0) index = length;
            backwardDistance += distance[--index];
        }

        return Math.min(backwardDistance, forwardDistance);
    }
}
