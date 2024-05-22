package numtreeset;

import java.util.TreeSet;

public class NumTreeSet{
    public int[] numbers;
    public NumTreeSet(int[] nums){
        numbers = nums;
    }

    public int work(){
        TreeSet<Integer> set = new TreeSet<>();

        for(int i=0;i<numbers.length;i++){
            if(!set.contains(numbers[i])){
                set.add(numbers[i]);
            }
        }

        return set.size();
    }
}