package edu.kiet.springfirst;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;



@RestController
public class MyController {
 
    @Autowired
    StudentService stdService;

    @GetMapping("/student")
    public List<Student> getInfo(){
        return stdService.getStudents();
    }
    @GetMapping("/student/{id}")
    public ResponseEntity<Student> getOneStudent(@PathVariable Long id){
        return stdService.getStudent(id);
    }

    @DeleteMapping("/student/{id}")
    public ResponseEntity<String> deleteInfo(@PathVariable Long id){
        stdService.deleteStudent(id);
        return ResponseEntity.ok("Student deleted!");
    }

    @PutMapping("/student/{id}")
    public Student updateStudent(@PathVariable Long id, @RequestBody Student s) {
        return stdService.updateStudent(id, s);
    }

    @PostMapping("/student")
    public Student addStudent(@RequestBody Student student) {
        return stdService.addStudent(student);
    }

    
}
