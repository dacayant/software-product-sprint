package com.google.sps.servlets;

import java.io.IOException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/** Handles requests sent to the /hello URL. Try running a server and navigating to /hello! */
@WebServlet("/more-about")
public class JSONServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    @Override
    public void doGet(final HttpServletRequest request, final HttpServletResponse response) throws IOException {
        
        String[] categories = {"Food", "Show","Movie","Band"};
        String[] favorites = {"Shiopao","Gravity Falls", "500 Days of Summer", "Mom Jeans."};
        
        String json = jsonStringBuilder(categories, favorites);        
        
        // Sends JSON as the response type for the servlet
        response.setContentType("application/json;");
        response.getWriter().println(json);
    }

    private String jsonStringBuilder(String[] keys, String[] vals){
        String json = "{";
        
        for(int i = 0; i < keys.length; i++){
            json += "\""+ keys[i] +"\":";
            json += "\""+ vals[i] + "\"";
            if(i < keys.length - 1)
            	json += ",";
            else
            	json += "}";
        }
        
        return json;
    }
}

