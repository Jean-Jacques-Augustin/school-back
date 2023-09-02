package com.apprendre.myproject.controllers;


import com.apprendre.myproject.entity.StudentEntity;
import com.apprendre.myproject.service.StudentService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping(path = "/student")
public class StudentController {

    private final StudentService studentService;


    /**
     *
     * Stucture:
     *  - Controller use service.
     *  Si on veut utiliser le service, on doit l'injecter dans le controller :
     *  ex : public StudentController(StudentService studentService) {
     *         this.studentService = studentService;
     *     }
     * <p>
     *     //@GetMapping: pour recuperer les donnees
     *     //@PostMapping: pour ajouter les donnees
     *     //@PutMapping: pour modifier les donnees
     *     //@DeleteMapping: pour supprimer les donnees
     * <p>
     *    Si on a une methode qui retourne une liste, on doit utiliser le @ResponseBody
     *    ex: @GetMapping
     *    public @ResponseBody List<StudentEntity> getStudent() {
     *     return this.studentService.getStudent();
     *     }
     *
     */

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping
    public List<StudentEntity> getStudent() {
        return this.studentService.getStudent();
    }

    @PostMapping
    public void registerNewStudent(StudentEntity studentEntity) {
        this.studentService.addNewStudent(studentEntity);
    }


    @PutMapping(path = "{studentId}")
    public void updateStudent(@PathVariable("studentId") Long studentId, @RequestParam(required = false) String name, @RequestParam(required = false) String email, @RequestParam(required = false) String niveau) {
        this.studentService.updateStudent(new StudentEntity(studentId, name, email, niveau));
    }

    @DeleteMapping(path = "{studentId}")
    public void deleteStudent(@PathVariable("studentId") Long studentId) {
        this.studentService.deleteStudent(studentId);
    }
}
