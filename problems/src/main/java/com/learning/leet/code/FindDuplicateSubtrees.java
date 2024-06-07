package com.learning.leet.code;


import com.learning.scaler.advance.module3.TreeNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FindDuplicateSubtrees {

    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        List<TreeNode> result = new ArrayList<>();
        Map<String, Integer> countMap = new HashMap<>();
        Map<String, TreeNode> nodeMap = new HashMap<>();
        serialize(root, countMap, nodeMap, result);
        return result;
    }

    private String serialize(TreeNode node, Map<String, Integer> countMap,
                             Map<String, TreeNode> nodeMap, List<TreeNode> result) {
        if (node == null) {
            return "#";
        }

        StringBuilder sb = new StringBuilder();
        sb.append(node.val).append(",");
        sb.append(serialize(node.left, countMap, nodeMap, result)).append(",");
        sb.append(serialize(node.right, countMap, nodeMap, result));
        String serial = sb.toString();

        countMap.put(serial, countMap.getOrDefault(serial, 0) + 1);

        if (countMap.get(serial) == 2) {  // Add to result only the first time we encounter a duplicate
            result.add(nodeMap.get(serial));
        } else if (countMap.get(serial) == 1) {
            nodeMap.put(serial, node);
        }

        return serial;
    }

}
