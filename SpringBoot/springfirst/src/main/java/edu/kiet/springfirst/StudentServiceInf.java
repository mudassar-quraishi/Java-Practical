package edu.kiet.springfirst;

import java.util.List;
import org.springframework.http.ResponseEntity;

public interface StudentServiceInf {
    public List<Student> getStudents();
    public Student addStudent(Student s);
    public ResponseEntity<Student> getStudent(Long id);
    public void deleteStudent(Long id);
    public Student updateStudent(Long id, Student s);
}
