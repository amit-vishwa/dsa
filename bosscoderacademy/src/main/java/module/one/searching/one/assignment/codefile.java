package module.one.searching.one.assignment;

public class codefile {

    public static void main(String[] args) {
        System.out.println(solve(new int[]{4, 14, 2}));
        System.out.println(solve(new int[]{4, 14, 4}));
    }

    static int solve(int[] input) {
        int sum = 0;
        for (int i = 0; i < input.length - 1; i++) {
            for (int j = i + 1; j < input.length; j++) {
                int bits = 0;
                while (bits < 64 && ((input[i] >> bits) > 0) && ((input[j] >> bits) > 0)) {
                    if (((input[i] >> bits) & 1) != ((input[j] >> bits) & 1)) {
                        sum++;
                    }
                    bits++;
                }
                while (bits < 64 && (input[i] >> bits) > 0) {
                    sum += ((input[i] >> bits) & 1);
                    bits++;
                }
                while (bits < 64 && (input[j] >> bits) > 0) {
                    sum += ((input[j] >> bits) & 1);
                    bits++;
                }
            }
        }
        return sum;
    }

}
