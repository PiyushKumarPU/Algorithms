package com.learning.leet.code;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class MergeKSortedArray {

    public static void main(String[] args) {
        List<List<Integer>> A = List.of(
                List.of(2352, 2422, 5410, 6259, 9703, 10665, 13549, 15794, 16341, 16543, 16618, 16654, 20586, 21422, 21833, 22638, 23695, 24407, 27244, 30472),
                List.of(4531, 10726, 12694, 13979, 14267, 16675, 17325, 17467, 20431, 21420, 21715, 22203, 22412, 24409, 25316, 26780, 27053, 27770, 28215, 31585),
                List.of(3440, 3592, 6578, 8797, 10249, 11455, 12973, 17470, 17714, 18728, 20834, 21389, 23397, 23490, 23606, 26174, 28132, 28357, 28452, 29548),
                List.of(3, 2064, 2071, 3869, 5097, 5697, 8046, 9180, 10697, 11472, 12389, 14720, 17559, 19171, 21098, 22840, 25765, 28134, 31267, 31394),
                List.of(1390, 2271, 3736, 7530, 7845, 8922, 9017, 14731, 17111, 19579, 21056, 21155, 22261, 25914, 26300, 26840, 27451, 29494, 31819, 32450),
                List.of(125, 2324, 2801, 3364, 8390, 11818, 12070, 12426, 15565, 19402, 21549, 21805, 23781, 24900, 25016, 25469, 26852, 27561, 27710, 28048),
                List.of(388, 1253, 2802, 3429, 4570, 6348, 7829, 9211, 13385, 14122, 15531, 16103, 16686, 17227, 17724, 18376, 22380, 24323, 26023, 26782),
                List.of(6708, 7382, 10506, 11236, 12078, 13276, 13746, 15606, 19638, 20148, 20188, 22860, 23447, 24007, 24336, 26868, 27117, 27535, 28490, 29712),
                List.of(269, 4024, 5874, 6919, 8773, 9040, 9972, 10640, 11633, 15314, 17182, 20336, 20442, 24380, 25747, 26560, 27386, 29607, 30809, 31166),
                List.of(1317, 1629, 5622, 5969, 7009, 7509, 8288, 9227, 13323, 14924, 15805, 18582, 20014, 23164, 23380, 26517, 26872, 28309, 30775, 32513),
                List.of(4038, 6397, 9156, 9693, 12646, 14336, 14510, 14582, 15092, 16143, 19732, 20936, 21206, 22951, 25038, 26896, 29652, 30419, 31546, 32331),
                List.of(951, 1600, 2349, 2519, 2537, 5087, 6163, 9486, 10066, 15561, 15659, 21572, 23338, 23676, 23846, 25407, 25753, 26680, 31318, 32366),
                List.of(1981, 4064, 5184, 5292, 5567, 5677, 6153, 7125, 9706, 10641, 11013, 11148, 15972, 17988, 23915, 26918, 27108, 28596, 28737, 29894),
                List.of(5895, 7101, 7851, 13789, 14101, 16925, 17379, 17742, 17864, 19780, 20334, 21236, 22914, 23677, 23713, 24074, 25599, 27470, 29248, 31009),
                List.of(1115, 5394, 6041, 6502, 7232, 7787, 11695, 12283, 13033, 15422, 15539, 18903, 19535, 19624, 20035, 24166, 25051, 29998, 30707, 31678),
                List.of(2442, 3873, 3917, 7493, 8774, 9580, 9598, 10715, 11094, 12450, 12891, 14197, 17380, 17860, 19580, 21347, 22124, 26183, 26710, 31501),
                List.of(3103, 3166, 5109, 5822, 7337, 9278, 12707, 12727, 13847, 15586, 18946, 19742, 20433, 21912, 22634, 23926, 24529, 28198, 28848, 29660),
                List.of(1727, 3457, 3488, 4019, 7109, 7520, 8718, 12962, 13819, 13945, 14149, 16146, 16379, 21244, 21724, 21803, 22166, 26598, 28315, 30965),
                List.of(954, 2350, 2506, 3376, 3559, 4426, 8826, 15239, 18722, 21449, 21782, 23589, 23622, 24211, 25163, 26780, 28287, 29144, 29218, 29978)
        );

        System.out.println(solveClassApproach(A));
    }

    public static ArrayList<Integer> solve(List<List<Integer>> A) {
        ArrayList<Integer> result = new ArrayList<>();
        PriorityQueue<Pair> minHeap =
                new PriorityQueue<>(Comparator.comparing(p -> A.get(p.valIndex).get(p.index)));
        for (int i = 0; i < A.size(); i++) minHeap.add(new Pair(0, i));
        while (!minHeap.isEmpty()) {
            Pair current = minHeap.poll();
            result.add(A.get(current.valIndex).get(current.index));
            int nextIndex = current.index + 1;
            if (nextIndex < A.get(current.valIndex).size()) {
                current.index = nextIndex;
                minHeap.offer(current);
            }
        }
        return result;
    }

    public static ArrayList<Integer> solveClassApproach(List<List<Integer>> A) {
        ArrayList<Integer> result = new ArrayList<>();
        PriorityQueue<PairWithRef> minHeap =
                new PriorityQueue<>(Comparator.comparing(p -> p.currentVal));
        for (List<Integer> integers : A) minHeap.add(new PairWithRef(integers.get(0), integers, 0));
        while (!minHeap.isEmpty()) {
            PairWithRef current = minHeap.poll();
            result.add(current.currentVal);
            int nextIndex = current.index + 1;
            if (nextIndex < current.ref.size()) {
                current.index = nextIndex;
                current.currentVal = current.ref.get(nextIndex);
                minHeap.offer(new PairWithRef(current.ref.get(nextIndex), current.ref, nextIndex));
            }
        }
        return result;
    }

}


class Pair {
    int index;
    int valIndex;

    public Pair(int index, int valIndex) {
        this.index = index;
        this.valIndex = valIndex;
    }
}

class PairWithRef {
    int currentVal;
    List<Integer> ref;
    int index;

    public PairWithRef(int currentVal, List<Integer> ref, int index) {
        this.currentVal = currentVal;
        this.ref = ref;
        this.index = index;
    }
}
