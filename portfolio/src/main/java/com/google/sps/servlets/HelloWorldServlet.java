package com.google.sps.servlets;

import java.io.IOException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/** Handles requests sent to the /hello URL. Try running a server and navigating to /hello! */
@WebServlet("/hello")
public class HelloWorldServlet extends HttpServlet {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    @Override
    public void doGet(final HttpServletRequest request, final HttpServletResponse response) throws IOException {
        response.setContentType("text/html;");
        response.getWriter().println("<h1>Hello Tristram Dacayan!</h1>");
    }
}
