package services.students;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;

@WebServlet("/DownloadServlet")
public class StudentDownloadMaterials extends HttpServlet {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static final String FILE_DIRECTORY = "C:\\Users\\Lenovo\\Desktop\\uploads\\"; // Adjust this to your file directory

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String fileName = request.getParameter("fileName");

        if (fileName == null || fileName.isEmpty()) {
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "File name is missing!");
            return;
        }

        // Sanitize the file name to prevent directory traversal attacks
        fileName = fileName.replaceAll("[^a-zA-Z0-9.\\-_]", "");
        String filePath = FILE_DIRECTORY + fileName;

        File downloadFile = new File(filePath);
        if (!downloadFile.exists() || downloadFile.length() == 0) {
            response.sendError(HttpServletResponse.SC_NOT_FOUND, "File not found or is empty");
            return;
        }

        response.setContentType("application/octet-stream");
        response.setHeader("Content-Disposition", "attachment; filename=\"" + downloadFile.getName() + "\"");
        response.setContentLength((int) downloadFile.length());

        try (FileInputStream inStream = new FileInputStream(downloadFile);
             OutputStream outStream = response.getOutputStream()) {

            byte[] buffer = new byte[40096];
            int bytesRead;
            while ((bytesRead = inStream.read(buffer)) != -1) {
                outStream.write(buffer, 0, bytesRead);
            }
        } catch (IOException e) {
            // Log the exception
            e.printStackTrace();
        }
    }
}