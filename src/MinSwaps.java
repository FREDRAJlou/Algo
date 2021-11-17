import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class MinSwaps {

    public static void main(String[] a){
        List<Integer> l = List.of(5,5,6,6,6);
        List<Integer> l1 = new ArrayList<>();
        l1.addAll(l);
        int swap = 0;
        List<Integer> sorted = l.stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList());
        for(int i =0; i< l.size();i++){
            if(sorted.get(i)!=l1.get(i)){
                System.out.println("Swapping "+sorted.get(i)+" -> "+l1.get(i));
                int minIndex = l1.indexOf(sorted.get(i));
                l1.set(minIndex,l1.get(i));
                l1.set(i,sorted.get(i));
               System.out.println(String.join(", ",l1.stream().map(String::valueOf).collect(Collectors.toList())));
                swap++;
            }
        }
       System.out.println(" out " + swap);
    }
}
