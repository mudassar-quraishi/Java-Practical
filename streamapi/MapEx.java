package streamapi;

import java.util.*;

class Employee{
    private String name;
    private int empId;
    Employee(String name, int empId){
        this.name = name;
        this.empId = empId;
    }
    public String getName(){
        return name;
    }
    public int getEmpId(){
        return empId;
    }
}

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
        
        //Convert all elements to uppercase
        ArrayList<String> list1 = new ArrayList<>();
        list1.addAll(Arrays.asList("sachin", "rahul", "amit"));
        list1.stream().map(s->s.toUpperCase()).forEach(System.out::println);

        //Create new list containing squares of each number
        ArrayList<Integer> list2 = new ArrayList<>();
        list2.addAll(Arrays.asList(1,2,3,4));
        List<Integer> newList = list2.stream().map(s->s*s).toList();
        System.out.println(newList);

        //Extract first character of each string
        ArrayList<String> list3 = new ArrayList<>();
        list3.addAll(Arrays.asList("Java", "Python", "C"));
        List<Character> extracted = list3.stream().map(s->s.charAt(0)).toList();
        System.out.println(extracted);

        //Convert all integers into strings.
        ArrayList<Integer> list4 = new ArrayList<>();
        list4.addAll(Arrays.asList(10,20,30,40));
        List<String> newList1 = list4.stream().map(s->s.toString()).toList();
        System.out.println(newList1); 

        //Add prefix "Item- " to each element
        ArrayList<String> list5 = new ArrayList<>();
        list5.addAll(Arrays.asList("A", "B", "C"));
        List<String> prefixAdded = list5.stream().map(s-> "Item- " + s).toList();
        System.out.println(prefixAdded);

        //Convert each string into its length
        ArrayList<String> list6 = new ArrayList<>();
        list6.addAll(Arrays.asList("Java", "Stream", "API"));
        List<Integer> length = list6.stream().map(s-> s.length()).toList();
        System.out.println(length);

        //Extract only employee names
        ArrayList<Employee> emp = new ArrayList<>();
        emp.add(new Employee("Ankit" , 1)); 
        emp.add(new Employee("Rahul", 2));
        List<String> empList = emp.stream().map(empl->empl.getName()).toList();
        System.out.println(empList);
    }
    
}
