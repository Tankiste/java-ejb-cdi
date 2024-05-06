package com.cesi.presentation.model;



import com.cesi.business.logic.StudentServiceLocal;
import jakarta.faces.context.FacesContext;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import jakarta.enterprise.context.SessionScoped;
import jakarta.servlet.http.HttpSession;

import java.io.Serializable;





/**
 *
 * @author TANKWA PRINCE JORDAN
 */

// Cette classe est un bean géré par JSF (JavaServer Faces) de sorte à pouvoir être accessible depuis les vues JSF.
// Aussi l'instance de la classe sera conservée pendant toute la durée de la session de l'utilisateur puis détruite.
@Named(value = "studentModel")
@SessionScoped
public class StudentBean implements Serializable {

    /**
     * Creates a new instance of StudentBean
     */

    private String firstname,lastname,email, password;

    // Injection de la dépendance du service métier StudentService, qui sera utilisée pour manipuler les données de l'étudiant.
    @Inject
    private StudentServiceLocal studentService;


    //méthodes d'action
    //Méthode appelée lorsque l'utilisateur veut ajouter les informations d'identité de l'étudiant et renvoie
    //une chaîne de caractère qui indique la prochaine vue à afficher
    public String addIdentity(){
        System.out.println(firstname+" "+lastname);
        studentService.addStudent(firstname, lastname);
        return "authentification";
    }

    // Méthode appelée lorsque l'utilisateur veut ajouter les informations d'authentification de l'étudiant et renvoie
    //une chaîne de caractère qui indique la prochaine vue à afficher
    public String addAuthentication(){
        System.out.println(email+" "+password);
        studentService.addAuthenticationInformations(email, password);
        return "summary";
    }

    // Méthode appelée lorsque l'utilisateur veut créer l'étudiant, ce qui persiste l'étudiant en base de données et
    // renvoie une chaîne de caractère qui indique la prochaine vue à afficher
    public String create(){
        System.out.println("création de l'étudiant");
        studentService.save();
        // Invalidation de la session de l'utilisateur, ce qui entraînera la destruction de l'instance.
        HttpSession session = (HttpSession)
                FacesContext.getCurrentInstance().getExternalContext().getSession(false);
        session.invalidate();
        return "index";
    }

    //getters & setters
    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }



    public String getLastname() {
        return lastname;
    }



    public void setLastname(String lastname) {
        this.lastname = lastname;
    }



    public String getEmail() {
        return email;
    }



    public void setEmail(String email) {
        this.email = email;
    }



    public String getPassword() {
        return password;
    }



    public void setPassword(String password) {
        this.password = password;
    }

    public StudentBean() {
    }
}

