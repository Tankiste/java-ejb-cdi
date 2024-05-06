package com.cesi.business.logic;


import jakarta.ejb.Local;
import jakarta.ejb.Stateful;

@Local
public interface StudentServiceLocal {

    public void addStudent(String firstname, String lastname);
    public void addAuthenticationInformations(String email, String pwd);
    public void save();
}
