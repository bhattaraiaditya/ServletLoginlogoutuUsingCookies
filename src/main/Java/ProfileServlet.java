import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
public class ProfileServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out=response.getWriter();

        request.getRequestDispatcher("link.html").include(request, response);

        Cookie ck[]=request.getCookies();
        if(ck!=null){
            for(Cookie cookie:ck){
                if(cookie.getName().equals("name")){
                    if(!cookie.getValue().equals("")||cookie.getValue()!=null){
                        out.print("<b>Welcome to Profile</b>");
                        out.print("<br>Welcome, "+cookie.getValue());
                        break;
                    }else{
                        out.print("Please login first");
                        request.getRequestDispatcher("login.html").include(request, response);

                    }
                }

                }

            }
        else{
            out.print("Please login first");
            request.getRequestDispatcher("login.html").include(request, response);
        }
        }
}
