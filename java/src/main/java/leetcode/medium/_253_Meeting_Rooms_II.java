package leetcode.medium;

import java.util.PriorityQueue;

class _253_Meeting_Rooms_II {
	public static void main(String[] args) {
		_253_Meeting_Rooms_II rooms = new _253_Meeting_Rooms_II();
		int res = rooms.rooms(new int[][]{
			new int[]{0,20},
			new int[]{5,10},
			new int[]{10,20},
			new int[]{20,21},
		});
		System.out.println(res);
	}

	class Entry {
		final boolean start;
		final int time;

		public Entry(int time, boolean start) {
			this.start = start;
			this.time = time;
		}
	}

	public int rooms(int[][] intervals) {
		PriorityQueue<Entry> q = new PriorityQueue<>(intervals.length * 2, (Entry a, Entry b) -> {
			if (a.time == b.time) {
				if (a.start == b.start) {
					return 0;
				} else if (a.start) {
					return 1;
				} else {
					return -1;
				}
			}
			return Integer.compare(a.time, b.time);
		});
		for (int i = 0; i < intervals.length; i++) {
			q.add(new Entry(intervals[i][0], true));
			q.add(new Entry(intervals[i][1], false));
		}

		int res = 0;
		int curr = 0;
		while (q.size() > 0) {
			Entry e = q.poll();
			System.out.println(e.time);
			if (e.start) {
				curr++;
				if (curr > res) {
					res = curr;
				}
			} else {
				curr--;
			}
		}

		return res;
	}
}