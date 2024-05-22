package numarraylist;

import java.util.ArrayList;

public class NumArrayList {
    public int[] numbers;

    public NumArrayList(int[] initialNumbers){
        numbers = initialNumbers;
    }

    public ArrayList<Integer> work(){
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] >= 5000) {
                list.add(numbers[i]);
            }
        }
        return list;
    }
}