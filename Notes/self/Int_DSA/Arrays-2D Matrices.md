
## Day 7 Arrays : 2D Matrix

## Scope / Agenda
- [Arrays 2D Matrix](#arrays-2d-matrix)
- [Print Row/column wise Sum](#print-rowcolumn-wise-sum)
- [Principle Diagonal](#principle-diagonal)
- [Print all anti diagonal of matrix](#print-all-anti-diagonal-of-matrix)
- [Matrix Transpose](#matrix-transpose)
- [Matrix Inverse](#matrix-inverse)

## Problems and solutions

1. [Assignments]()
2. [Additional Problems]()
3. [Self Practise Problems]()

## Class Notes and Videos

1. [Class Notes](../../class_Notes/DSA%20Intermediate%20Notes/7%20Two%20Dimensional%20Matrices(6-09-23).pdf)
2. [Class/Lecture Video](https://www.youtube.com/watch?v=lTUAccv62x0)


## Arrays 2D Matrix
* [Refer Here for more details](https://www.geeksforgeeks.org/multidimensional-arrays-in-java/)
## Print Row/column wise Sum   
    Problem description
        Given a N*M matrix find sum of each row and column separetely.
### Solution
```java
    public List<List<Integer>> findRowWiseSum(List<List<Integer>> inputs) {
        List<List<Integer>> result = new ArrayList<>(inputs.size());
        for (List<Integer> input : inputs) {
            int currentRowSum = 0;
            for (Integer integer : input) {
                currentRowSum += integer;
            }
            result.add(new ArrayList<>(List.of(currentRowSum)));
        }
        return result;
    }

    public List<Integer> findColumnWiseSum(List<List<Integer>> inputs) {
        List<Integer> result = new ArrayList<>(inputs.get(0).size());
        for (int i = 0; i < inputs.get(0).size(); i++) {
            int currentRowSum = 0;
            for (List<Integer> input : inputs) {
                currentRowSum += input.get(i);
            }
            result.add(currentRowSum);
        }
        return result;
    }
```
## Principle Diagonal
> Principle diagonal of any 2D matrix start from left top corner and it goes till right bottom corner. i.e. choose each element with row = column


    The primary diagonal is formed by the elements A00, A11, A22, A33.
    i.e. row column condition would be row = column
### Solution
```java
    public List<Integer> printPrincipleDiagonal(List<List<Integer>> inputs) {
        List<Integer> result = new ArrayList<>(inputs.size());
        for (int i = 0; i < inputs.get(0).size(); i++) {
            for (int j = 0; j < inputs.get(i).size(); j++) {
                if (i == j) result.add(inputs.get(i).get(j));
            }
        }
        return result;
    }
```
### Print all anti diagonal of matrix
![Anti diagonal](../../images/prinnt_anti_diagonal.png)

## Matrix Transpose

## Matrix Inverse