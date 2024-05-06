package com.cesi.integration;

import com.cesi.business.domain.Student;

import jakarta.ejb.Stateless;

import jakarta.persistence.*;

// Cette classe est un EJB (Enterprise JavaBean) qui ne
// conservera pas d'état entre les appels de méthodes.
@Stateless
public class StudentDAO {

    // Injection de l'EntityManager, qui sera utilisé pour persister l'étudiant.
    @PersistenceContext(unitName = "bigAppPU")
    private EntityManager em;

    // Cette méthode permet d'insérer un étudiant dans la base de données.
    public void insert(Student student){
        em.persist(student);
    }
}
