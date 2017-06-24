package servlets;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;


@WebServlet("/changeProfile")
@MultipartConfig
public class ChangeProfileServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
         Part file = request.getPart("profilePicture");
         InputStream is  = file.getInputStream();
        
         
         String path = getServletContext().getRealPath("");
         SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
         
         String timestamp = sdf.format(new Date()) + ".jpg";
         String filename = path  + timestamp;
         System.out.println(filename);

         FileOutputStream os = new FileOutputStream(filename);
         
         int b;
         while(true) {
        	 b = is.read();
        	 if ( b == -1) break;
        	 os.write(b);
         }
         os.close();
         
	}

}
