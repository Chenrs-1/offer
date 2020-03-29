package meituan;

import java.util.HashMap;
import java.util.Scanner;

public class Demo2 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str1 = null;
        String str2 = null;
        int i = 0;
        while(scanner.hasNext()){
            i++;
            if(i==1){
                str1 = scanner.nextLine();
            }else if(i==2){
                str2 = scanner.nextLine();
                break;
            }
        }

        String[] arr1 = str1.split(" ");
        String[] arr2 = str2.split(" ");

        String[] arr3 = new String[Integer.valueOf(arr1[0])];

        for(int j = 0;j<Integer.valueOf(arr1[0]);j++){
            arr3[j] = arr2[j];
        }

        Integer b = Integer.valueOf(arr1[1]);

        HashMap<Integer,Integer> map = new HashMap();

        for(int k = 0;k<Integer.valueOf(arr1[0]);k++){
            Integer a = Integer.valueOf(arr3[k]);
            int huo = (a|b);
            if(map.get(huo) == null){
                map.put(huo,1);
            }else{
                int count = (map.get(huo) + 1);
                map.put(huo,count);
            }
        }
        int zui = 0;
        for(int key : map.keySet()){
            int value = map.get(key);
            if(value>zui){
                zui = value;
            }
        }
        System.out.println(zui);
    }


}
