/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package minav1.repository;

import java.util.List;
import minav1.domain.Student;

/**
 *
 * @author aleks
 */
public interface IStudentRepository {
    List<Student> vratiSve() throws Exception;
    Student sacuvaj(Student student)throws Exception;
    Student izmeni(Student student)throws Exception;
    void izbrisi(Student student)throws Exception;
}
