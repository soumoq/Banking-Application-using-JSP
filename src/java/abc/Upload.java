
package abc;

import java.io.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;
import org.apache.commons.fileupload.*;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.*;

@WebServlet("/upload")


public class Upload extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        ServletFileUpload sf=new ServletFileUpload(new DiskFileItemFactory());
        
        try {
            List<FileItem> file= sf.parseRequest(request);
            for(FileItem item : file)
            {
                item.write(new File("/home/mr3o5/NetBeansProjects/web2/user_files/"+item.getName()));
            }
            
            PrintWriter out=response.getWriter();
            out.print("File Uploaded");
        
        } 
        catch (Exception ex) {
            Logger.getLogger(Upload.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
