package streamapi;
import java.util.*;

class Student{
    private String name;
    private int marks;
    Student(String name, int marks){
        this.name=name;
        this.marks=marks;
    }
    public String getName(){
        return name;
    }
    public int getMarks(){
        return marks;
    }
    @Override
    public String toString(){
    return "Student [name =" + name + " marks = "+ marks+ "]";
    }
}


public class Filters {
    public static void main(String[] args) {
        // Check & print even number
        ArrayList<Integer> list = new ArrayList<>();
        list.addAll(List.of(10, 15, 20, 25, 30, 11, 17, 16));
        list.stream().filter(n -> n % 2 == 0).forEach(System.out::println);

        //Print names starting with "A"
        ArrayList<String> list1 = new ArrayList<>();
        list1.addAll(List.of("Amit", "Anil", "Vikas", "Ashok", "Rahul"));
        list1.stream().filter(n-> (n.charAt(0)=='A') || (n.charAt(0)=='a')).forEach(System.out::println);
        list1.stream().filter(n-> n.startsWith("A")).forEach(System.out::println);

        //Print whose string length is greater than 4
        ArrayList<String> list2 = new ArrayList<>();
        list2.addAll(List.of("Java", "Python", "C", "React", "NextJs"));
        list2.stream().filter(n -> n.length()>4).forEach(System.out::println);

        //Remove null values from the list
        ArrayList<String> list3 = new ArrayList<>();
        list3.addAll(Arrays.asList("Java", null, "Spring", null, "React"));
        list3.stream().filter(n -> n!=null).forEach(System.out::println);

        //Distinct & greater than 15
        ArrayList<Integer> list4 = new ArrayList<>();
        list4.addAll(List.of(10, 20,20,30,30));
        list4.stream().distinct().filter(n -> n>15).forEach(System.out::println);

        //Print all strings containing with the letter 'o'
        ArrayList<String> list5 = new ArrayList<>();
        list5.addAll(List.of("Java", "Python", "Go", "React", "NextJs"));
        list5.stream().filter(n -> n.contains("o")).forEach(System.out::println);

        //Print students whose marks are greater than 60.
        ArrayList<Student> list6 = new ArrayList<>();
        list6.add(new Student("Mohan", 50));
        list6.add(new Student("Sohan", 70));
        list6.add(new Student("Rohan", 80));

        list6.stream().filter(Student->Student.getMarks()>60).forEach(System.out::println);

        }
}
