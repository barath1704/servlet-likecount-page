import javax.servlet.*;
import java.io.*;
import javax.servlet.http.*;
import java.util.*;
public class sessionclass extends HttpServlet
{
public void doGet(HttpServletRequest req,HttpServletResponse res) throws IOException,ServletException
{   PrintWriter out = res.getWriter();
    Integer count1 = new Integer(0);
    Integer count2 = new Integer(0);
    
 HttpSession ses = req.getSession();
 String id = req.getParameter("imgname");
out.println("<html><head></head>");
out.println("<body><h1>"+id+"was liked recently</h1><br><center><h1>Current likes count</h1>"); 
 
 
if(ses.isNew())
{
ses.setAttribute("count1",count1);
    ses.setAttribute("count2",count2);
out.println("<h1>img1 has"+count1+"likes</h1><h1>img2 has"+count2+"like(s)</h1>");
}
 

else
{   count1 = (Integer)ses.getAttribute("count1");
    count2 = (Integer)ses.getAttribute("count2");
 if(id.equals("img1"))
    {

count1++; 
ses.setAttribute("count1",count1);
}
     if(id.equals("img2"))
    {
        

count2++; 
ses.setAttribute("count2",count2);
    }
out.println("<h1>img1 has"+count1+"likes</h1><h1>img2 has"+count2+"like(s)</h1></body></html>");
}
 
 

}
   }
  
