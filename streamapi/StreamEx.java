package streamapi;
import java.util.*;
import java.util.stream.*;

public class StreamEx {
    public static void main(String[] args){
        List data = Arrays.asList(23,45,52,68,12,19,25);
       // List data = List.of(23,45,52,68,12,19,25);
       Stream info = Stream.of(23,45,65,85,952,3.5,"info");
       ArrayList<Integer> list = new ArrayList<>();
       list.addAll(data);
       System.out.println(list);
       Stream listStream = data.stream();
    }
}
