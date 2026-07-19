package prerequisites.week3.lesson1;

/**
 * 3. Pyramid Pattern (Centered)
 *     *
 *    ***
 *   *****
 *  *******
 * *********
 * */
public class Pattern3 {

    public static void main(String[] args) {
        printPattern(3);
        printPattern(5);
    }

    static void printPattern(int n){
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n - i - 1; j++){
                System.out.print(" ");
            }
            for(int j = 0; j < i * 2 + 1; j++){
                System.out.print("*");
            }
            System.out.println();
        }
    }

}
