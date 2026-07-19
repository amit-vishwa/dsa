package prerequisites.week3.lesson1;

/**
 * 6. Number Pattern (Increasing Rows)
 * 1
 * 2 3
 * 4 5 6
 * 7 8 9 10
 * 11 12 13 14 15
 * */
public class Pattern6 {

    public static void main(String[] args) {
        printPattern(3);
        printPattern(5);
    }

    static void printPattern(int n){
        int num = 1;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < i + 1; j++){
                System.out.print(num + " ");
                num++;
            }
            System.out.println();
        }
    }

}
