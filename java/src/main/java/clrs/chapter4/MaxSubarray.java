package clrs.chapter4;

import java.util.Arrays;

public class MaxSubarray {
    public static void main(String[] args) {
        int[] array = new int[]{13, -3, -25, 20, -3, -16, -23, 18, 20, -7, 12, -5, -22, 15, -4, 7};
        System.out.println(Arrays.toString(maxSubarrayLinearFlat(array)));
    }

    private static int[] maxSubarray(int[] array) {
        int[] maxSubarray = maxSubarray(array, 0, array.length - 1);
        int length = maxSubarray[1] - maxSubarray[0] + 1;
        int[] result = new int[length];
        System.arraycopy(array, maxSubarray[0], result, 0, length);
        return result;
    }

    /**
     * @return int[]{right, left, length}
     */
    private static int[] maxSubarray(int[] array, int left, int right) {
        if (left < right) {
            int middle = (right + left) / 2;
            int[] leftSubarray = maxSubarray(array, left, middle);
            int[] rightSubarray = maxSubarray(array, middle + 1, right);
            int[] crossingSubarray = maxCrossingSubarray(array, left, middle, right);

            if (leftSubarray[2] > rightSubarray[2] && leftSubarray[2] > crossingSubarray[2])
                return leftSubarray;
            else if (rightSubarray[2] > leftSubarray[2] && rightSubarray[2] > crossingSubarray[2]) {
                return rightSubarray;
            }
            return crossingSubarray;
        }
        return new int[]{left, right, array[left]};
    }


    private static int[] maxCrossingSubarray(int[] array, int left, int middle, int right) {
        int i = middle, tmpSum = 0;

        int leftPos = i, leftSum = Integer.MIN_VALUE;
        while (i >= left) {
            tmpSum += array[i];
            if (tmpSum >= leftSum) {
                leftPos = i;
                leftSum = tmpSum;
            }
            i--;
        }

        i = middle + 1;
        tmpSum = 0;

        int rightPos = i, rightSum = Integer.MIN_VALUE;
        while (i <= right) {
            tmpSum += array[i];
            if (tmpSum >= rightSum) {
                rightPos = i;
                rightSum = tmpSum;
            }
            i++;
        }

        if (leftSum < 0)
            return new int[]{middle + 1, rightPos, rightSum};
        else if (rightSum < 0)
            return new int[]{leftPos, middle, leftSum};

        return new int[]{leftPos, rightPos, leftSum + rightSum};
    }

    private static int[] maxSubarrayFlat(int[] array) {
        int start = 0, end = 0, sum = Integer.MIN_VALUE;

        int tmpSum = array[0];
        for (int i = 0; i < array.length - 1; i++) {
            tmpSum = 0;
            for (int j = i; j < array.length - 1; j++) {
                tmpSum += array[j];
                if (tmpSum >= sum) {
                    start = i;
                    end = j;
                    sum = tmpSum;
                }
            }
        }

        int len = end - start + 1;
        int[] result = new int[len];
        System.arraycopy(array, start, result, 0, len);
        return result;
    }

    private static int[] maxSubarrayLinearFlat(int[] array) {
        int startMax = 0, endMax = 0;
        int sum = 0;
        int maxSum = Integer.MIN_VALUE;
        int i = 0;
        for (int j = 0; j < array.length; j++) {
            sum += array[j];
            if (sum >= maxSum) {
                endMax = j;
                startMax = i;
                maxSum = sum;
            }
            if (sum < 0) {
                i = j + 1;
                sum = 0;
            }
        }
        int[] result = new int[endMax - startMax + 1];
        System.arraycopy(array, startMax, result, 0, result.length);
        return result;
    }
}