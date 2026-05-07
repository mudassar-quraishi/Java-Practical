package edu.kiet.springfirst;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class StudentService implements StudentServiceInf {

    @Autowired
    StudentDAO std;
    
    @Override
    public List<Student> getStudents(){
        return std.findAll();
    }

    @Override
    public Student addStudent(Student s){
        return std.save(s);
    }

    @Override
    public ResponseEntity<Student> getStudent(Long id){
        return std.findById(id)
        .map(ResponseEntity::ok)
        .orElseThrow(()-> new RuntimeException("ID not found"));
    }

    @Override
    public void deleteStudent(Long id){
        std.deleteById(id);
    }

    @Override
    public Student updateStudent(Long id, Student s){
        // Student ss=std.findById(id)
        // .orElseThrow(()-> new RuntimeException("ID not found"));
        // ss.setId(id);
        // ss.setMarks(s.getMarks());;
        // ss.setName(s.getName());
        // ss.setCourse(s.getCourse());
        // return std.save(ss);

        ResponseEntity<Student> ss= std.findById(id)
                                    .map(ResponseEntity::ok)
                                    .orElse(ResponseEntity.notFound().build());
        ss.getBody().setId(id);
        ss.getBody().setMarks(s.getMarks());
        ss.getBody().setCourse(s.getCourse());
        ss.getBody().setName(s.getName());
        return std.save(ss.getBody());
    }
}
