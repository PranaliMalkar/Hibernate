package com.avekshaa.traning.test;
import net.javaguides.hibernate.dao.StudentDao;
import net.javaguides.hibernate.entity.Student;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

public class StudentDaoTest {
    private StudentDao studentDao;

    @BeforeEach
    public void setup() {
        // Initialize the StudentDao instance
        studentDao = new StudentDao();
    }

    @Test
    public void testSaveStudent() {
        // Create a new student
        Student student = new Student("John", "Doe", "johndoe@example.com");

        // Save the student
        studentDao.saveStudent(student);

        // Get the saved student from the database
        Student savedStudent = studentDao.getStudent(student.getId());

        // Assert that the saved student matches the original student
        Assertions.assertEquals(student, savedStudent);
    }

    @Test
    public void testUpdateStudent() {
        // Create a new student
        Student student = new Student("Jane", "Smith", "janesmith@example.com");

        // Save the student
        studentDao.saveStudent(student);

        // Update the student's first name
        student.setFirstName("Jane");

        // Update the student in the database
        studentDao.updateStudent(student);

        // Get the updated student from the database
        Student updatedStudent = studentDao.getStudent(student.getId());

        // Assert that the student's first name has been updated
        Assertions.assertEquals("Jane", updatedStudent.getFirstName());
    }

    @Test
    public void testGetStudents() {
        // Get the list of students from the database
        List<Student> students = studentDao.getStudents();

        // Assert that the list is not empty
        Assertions.assertFalse(students.isEmpty());
    }

    @Test
    public void testDeleteStudent() {
        // Create a new student
        Student student = new Student("Mark", "Johnson", "markjohnson@example.com");

        // Save the student
        studentDao.saveStudent(student);

        // Delete the student from the database
        studentDao.deleteStudent(student.getId());

        // Get the deleted student from the database
        Student deletedStudent = studentDao.getStudent(student.getId());

        // Assert that the deleted student is null
        Assertions.assertNull(deletedStudent);
    }
}
