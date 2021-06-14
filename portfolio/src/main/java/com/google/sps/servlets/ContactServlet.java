package com.google.sps.servlets;

import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/contact-me")
public class ContactServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        // Gets input from the contact-input form
        String name = getParameter(request, "name", "");
        String phone = getParameter(request, "number", "");
        String email = getParameter(request, "email", "");
        ArrayList<Person> contactList = new ArrayList<Person>();
        
        Person newContact = new Person(name, phone, email);

        // Temp. Storage for information
        // In the future, add a file or something of the sort to store contacts
        contactList.add(newContact);

        response.setContentType("text/html;");
        // Prints only in the Console
        System.out.println(newContact.toString());
        
        // Redirect back to homepage
        response.sendRedirect(request.getContextPath() );
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
    String name, phone, email;

    Person(String name, String phone, String email){
        this.name = name;
        this.phone = phone;
        this.email = email;
    }

    @Override
    public String toString(){
        return "{\"" + this.name + "\", \"" + this.phone + "\", \"" + this.email + "\"}";
    }
}