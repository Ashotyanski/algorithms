package clrs.chapter3;

public class Fib {
    public static void main(String[] args) {
        int i = 30;
        double gr = goldenRatio(i);
        double gri = goldenRatioInverted(i);
        System.out.println((gr-gri)/Math.sqrt(5));
    }

    private static double goldenRatio(int i) {
        return Math.pow((1 + Math.sqrt(5)) / 2, i);
    }

    private static double goldenRatioInverted(int i) {
        return Math.pow((1 - Math.sqrt(5)) / 2, i);
    }
}
