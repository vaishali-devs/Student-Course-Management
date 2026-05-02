package com.example.studentcourse;

import com.example.studentcourse.model.Course;
import com.example.studentcourse.model.Student;
import com.example.studentcourse.repository.StudentRepository;
import com.example.studentcourse.service.StudentCourseService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@SpringBootTest
public class StudentCourseServiceTest {

    @Mock
    private StudentRepository studentRepository;

    @InjectMocks
    private StudentCourseService studentCourseService;

    @Test
    public void testGetAllStudents() {
        List<Student> list = new ArrayList<>();
        Course course = new Course("Test Course", "TC101");
        list.add(new Student("Test Student", "test@example.com", course));

        when(studentRepository.findAll()).thenReturn(list);

        List<Student> students = studentCourseService.getAllStudents();

        assertEquals(1, students.size());
        assertEquals("Test Student", students.get(0).getName());
        verify(studentRepository, times(1)).findAll();
    }

    @Test
    public void testSaveStudent() {
        Course course = new Course("Test Course", "TC101");
        Student student = new Student("Test Student", "test@example.com", course);

        when(studentRepository.save(student)).thenReturn(student);

        Student saved = studentCourseService.saveStudent(student);

        assertEquals("Test Student", saved.getName());
        verify(studentRepository, times(1)).save(student);
    }
}
