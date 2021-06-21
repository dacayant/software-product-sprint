package com.google.sps.servlets;

import com.google.cloud.storage.Blob;
import com.google.cloud.storage.BlobId;
import com.google.cloud.storage.BlobInfo;
import com.google.cloud.storage.Storage;
import com.google.cloud.storage.StorageOptions;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
 
@WebServlet("/upload-image")
@MultipartConfig
public class ImageFormHandler extends HttpServlet {
 
    private static final long serialVersionUID = 1L;
 
    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) 
        throws IOException, ServletException {
        
        // Get the file chosen by the user.
        Part filePart = request.getPart("image");
        
        // TODO: Change FileName generation
        String fileName = filePart.getSubmittedFileName();
        InputStream fileInputStream = filePart.getInputStream();

        String uploadedFileUrl = uploadToCloudStorage(fileName, fileInputStream);


        // Output some HTML that shows the data the user entered.
        // You could also store the uploadedFileUrl in Datastore instead.
        // TODO: Add datastore library to store image URL from CloudStorage
        PrintWriter out = response.getWriter();
        out.println("<p>Here's the image you uploaded:</p>");
        out.println("<a href=\"" + uploadedFileUrl + "\">");
        out.println("<img src=\"" + uploadedFileUrl + "\" />");
        out.println("</a>");
    }
    /** Uploads a file to Cloud Storage and returns the uploaded file's URL. */
    private static String uploadToCloudStorage(String fileName, InputStream fileInputStream) {
        String projectId = "tdacayan-sps-summer21";
        String bucketName = "tdacayan-sps-summer21.appspot.com";
        Storage storage =
            StorageOptions.newBuilder().setProjectId(projectId).build().getService();
        BlobId blobId = BlobId.of(bucketName, fileName);
        BlobInfo blobInfo = BlobInfo.newBuilder(blobId).build();

        // Upload the file to Cloud Storage.
        Blob blob = storage.create(blobInfo, fileInputStream);

        // Return the uploaded file's URL.
        return blob.getMediaLink();
    }
}
 