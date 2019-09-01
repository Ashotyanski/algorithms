package leetcode.medium;

import java.util.*;
import java.lang.*;

class _681_Next_Closest_Time {
	public static void main(String[] args) {
		System.out.println(new _681_Next_Closest_Time().nextTime("19:34"));
	}
	
	int getNextDigit(int d, int[] time, int max) {
		int res = 10;
		for (int i = 0; i < time.length; i++) {
			if (time[i] > d && time[i] <= max && time[i] < res) {
				res = time[i];
			}
		}
		return res == 10 ? -1 : res;
	}

	public String nextTime(String t) {
		String[] splitted = t.split(":");
		int[] time = new int[4];
		time[0] = Integer.parseInt(String.valueOf(splitted[0].charAt(0)));
		time[1] = Integer.parseInt(String.valueOf(splitted[0].charAt(1)));
		time[2] = Integer.parseInt(String.valueOf(splitted[1].charAt(0)));
		time[3] = Integer.parseInt(String.valueOf(splitted[1].charAt(1)));
		System.out.println(Arrays.toString(time));

		int max = 0;
		int min = 9;
		for (int i = 0; i < time.length; i++) {
			if (time[i] > max) {
				max = time[i];
			}
			if (time[i] < min) {
				min = time[i];
			}
		}

		int[] maxForPos = new int[]{2, 9, 5, 9};


		System.out.println(max);
		int incr = -1;
		for (int i = time.length - 1; i >= 0; i--) {
			if (time[i] < maxForPos[i] && time[i] < max) {
				// increase
				int possibleNext = -1;
				if (i == 1) {
					if (time[0] < 2) {
						possibleNext = getNextDigit(time[1], time, 9);
					} else {
						possibleNext = getNextDigit(time[1], time, 3);
					}
				} else if (i == 0) {
					if (time[1] < 3) {
						possibleNext = getNextDigit(time[0], time, 2);
					} else {
						possibleNext = getNextDigit(time[0], time, 1);
					}
				} else {
					possibleNext = getNextDigit(time[i], time, maxForPos[i]);
				}
				if (possibleNext > -1) {
					time[i] = possibleNext;
					incr = i;
					break;
				}
			}
		}
		System.out.println(incr);
		for (int i = incr + 1; i < time.length; i++) {
			time[i] = min;
		}
		System.out.println(Arrays.toString(time));
		return String.valueOf(time[0]) + String.valueOf(time[1]) + ":" + String.valueOf(time[2]) + String.valueOf(time[3]);
	}
}