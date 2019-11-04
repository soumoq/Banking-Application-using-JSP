
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
                item.write(new File("/opt/lampp/htdocs/user_file/"+item.getName()));
                
                String itnm=item.getName();
                String file_name=itnm;
                String file_path="/opt/lampp/htdocs/user_file/"+itnm;
                Con con=new Con();
                int id=con.getId();
                con.fileUp(id, file_name, file_path);
            }
            
            PrintWriter out=response.getWriter();
            out.print("File Uploaded");
        
        } 
        catch (Exception ex) {
            Logger.getLogger(Upload.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
