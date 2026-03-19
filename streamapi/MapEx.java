//package streamapi;

import java.util.*;

public class MapEx {
    public static void main(String[] args){
        ArrayList<Integer> list = new ArrayList<>();
        list.addAll(Arrays.asList(10,45,35,75,80,91,67,76));
        list.stream().map(s-> s+5).forEach(s-> System.out.print(s + " "));
        System.out.println();
        list.stream()
            .filter(s->s<40)
            .map(marks->marks+5)
            .forEach(mark->System.out.print(mark + " "));
    }
    
}
