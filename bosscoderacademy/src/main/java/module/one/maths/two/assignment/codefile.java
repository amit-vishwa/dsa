package module.one.maths.two.assignment;


import java.util.ArrayList;
import java.util.List;

public class codefile {

    public static void main(String[] args) {
        System.out.println(solve(3, 3));
        System.out.println(solve(4, 9));
    }

    private static String solve(int n, int k) {
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= n; i++) {
            sb.append(i);
        }
        List<String> permutationList = permutations("", sb.toString());
        permutationList.sort(null);
        return permutationList.get((k - 1) % permutationList.size());
    }

    private static List<String> permutations(String p, String up) {
        if (up.isEmpty()) {
            return new ArrayList<String>(List.of(p));
        }
        List<String> list = new ArrayList<>();
        for (int i = 0; i <= p.length(); i++) {
            String s = p.substring(0, i);
            char m = up.charAt(0);
            String e = p.substring(i);
            list.addAll(permutations(s + m + e, up.substring(1)));
        }
        return list;
    }

}