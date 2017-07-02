package leetcode.easy;

//  https://en.wikipedia.org/wiki/Digital_root
public class AddDigits {
    public int addDigits(int num) {
        return 1 + ((num - 1) % 9);
    }
}
