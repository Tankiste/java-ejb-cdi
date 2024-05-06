package com.cesi.business.logic;

import com.cesi.business.domain.Student;
import com.cesi.integration.StudentDAO;
import jakarta.ejb.Remove;
import jakarta.ejb.Stateful;
import jakarta.inject.Inject;

// Cette classe est un EJB (Enterprise JavaBean) qui permet de conserver
// l'état de l'objet étudiant entre les appels de méthodes.
@Stateful
public class StudentService implements StudentServiceLocal {

    // Injection de la dépendance StudentDAO, qui sera utilisée pour persister l'étudiant.
    @Inject
    StudentDAO studentDAO;

    // Création d'un nouvel étudiant
    private final Student student = new Student();

    // Cette méthode permet d'ajouter les informations d'identité de l'étudiant.
    @Override
    public void addStudent(String firstname, String lastname) {
        student.setFirstname(firstname);
        student.setLastname(lastname);
        System.out.println("identité de l'etudiant "+firstname+" "+lastname);
    }


    // Cette méthode permet d'ajouter les informations d'authentification de l'étudiant.
    @Override
    public void addAuthenticationInformations(String email, String pwd) {
        student.setEmail(email);
        student.setPassword(pwd);
        System.out.println("ajout des informations d'authentification : "+email+" - "+pwd);
    }

    // L'annotation @Remove indique que cette méthode détruira l'instance de l'EJB en effectuant la persistance de l'étudiant
    @Override
    @Remove
    public void save() {
        studentDAO.insert(student);
        System.out.println("sauvegarde de l'étudiant créé");
    }
}
