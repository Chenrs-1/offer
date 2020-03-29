package bilibili;

import java.util.Scanner;

public class Demo {
    public static void main(String[] args) {

        Scanner scn = new Scanner(System.in);
        String str ="";

        while(scn.hasNext()) {
            str = scn.nextLine();
            String[] s = str.split(" ");
            for(int i = s.length-1;i >= 0;i--) {
                System.out.print(s[i]+" ");
            }
        }
        scn.close();
    }
}
