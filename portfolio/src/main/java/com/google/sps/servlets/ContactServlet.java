package com.google.sps.servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/contact")
public class ContactServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        // Gets input from the contact-input form
        String name = getParameter(request, "name-input", "");
        String phone = getParameter(request, "phone-input", "");
        String email = getParameter(request, "email-input", "");
        ArrayList<Person> contactList = new ArrayList<Person>();
        
        Person newContact = new Person(name);

        // Add contact information based on 
        if(phone != "" && email == "")
            newContact.addPhone(phone);
        else if(phone == "" && email != "")
            newContact.addEmail(email);
        else if (phone != "" && email == ""){
            newContact.addPhone(phone);
            newContact.addEmail(email);
        }
        // No condition for no email or phone

        // Temp. Storage for information
        // In the future, add a file or something of the sort to store contacts
        contactList.add(newContact);

        response.setContentType("text/html;");
        response.getWriter().println(newContact.toString());
    }

    // Borrowed from the TextProcessorServlet example
    // Evaluates the text as parameters and returns the default values if returned as null
    private String getParameter(HttpServletRequest request, String name, String defaultValue) {
        String value = request.getParameter(name);
        
        if (value == null) {
            return defaultValue;
        }
        
        return value;
    }
}

// Separate class to make storing contact information easier
class Person {
    private String name, phone, email;

    Person(String name){
        this.name = name;
    }

    // Name Getter
    public String getName(){
        return name;
    }
    
    // Phone Getter and Setters
    public String getPhone(){
        return phone;
    }
    public void addPhone(String phone){
        this.phone = phone;
    }

    // Email Getter and Setters
    public String getEmail(){
        return email;
    }    
    public void addEmail(String email){
        this.email = email;
    }

    @Override
    public String toString(){
        return "{\"" + this.name + "\", \"" + this.phone + "\", \"" + this.email + "\"}";
    }
}