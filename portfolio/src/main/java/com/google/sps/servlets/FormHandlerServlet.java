package com.google.sps.servlets;
 
import java.io.IOException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
 
@WebServlet("/form-handler")
public class FormHandlerServlet extends HttpServlet {
 
    /**
     *
     */
    private static final long serialVersionUID = 1L;
 
    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
 
        // Get the value entered in the form.
        String textValue = request.getParameter("text-input");
 
        // Print the value so you can see it in the server logs.
        System.out.println("You submitted: " + textValue);
 
        // Redirect back to homepage
        response.sendRedirect(request.getContextPath());    // returns to homepage + "/SERVLET_NAME" 
    }
}