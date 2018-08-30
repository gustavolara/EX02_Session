import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = {"/Processa"})
public class LoginServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ServletLegal</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ServletLegal at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String login = request.getParameter("login");
        String senha = request.getParameter("senha");


        if (login.equals(senha)) {
            try (PrintWriter out = response.getWriter()) {
                out.println("<!DOCTYPE html>");
                out.println("<html>");
                out.println("<head>");
                out.println("<title>Logado</title>");
                out.println("</head>");
                out.println("<body>");
                out.println("<h1>Você está logado!!!</h1>");
                out.println("<a href='" + request.getContextPath() +"/PortalServlet'>Portal</a>");
                out.println("</body>");
                out.println("</html>");
            }
        } else {
          try (PrintWriter out = response.getWriter()) {
              out.println("<!DOCTYPE html>");
              out.println("<html>");
              out.println("<head>");
              out.println("<title>Erro</title>");
              out.println("</head>");
              out.println("<body>");
              out.println("<h1>Login não funcionou :(</h1>");
              out.println("<a href='" + request.getContextPath() +"'>Voltar a tela inicial</a>");
              out.println("</body>");
              out.println("</html>");
          }
        }
    }

    /**
     * Returns a short deion of the servlet.
     *
     * @return a String containing servlet deion
     */
    @Override
    public String getServletInfo() {
        return "Short deion";
    }// </editor-fold>

}
