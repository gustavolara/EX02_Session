import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;


@WebServlet(urlPatterns = {"/PortalServlet"})
public class PortalServlet extends HttpServlet {
      static ArrayList<Usuario> usuarios = new ArrayList();

      Usuario a = new Usuario("Daniel", "daniel", "daniel");
      Usuario b = new Usuario("Gustavo", "gustavo", "gustavo");
      Usuario c = new Usuario("Matheus", "matheus", "matheus");
        
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
        if (usuarios.isEmpty()) {
            usuarios.add(a);
            usuarios.add(b);
            usuarios.add(c);
        }
        
        try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet PortalServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Cadastrar</h1>");
            out.println("<form action='CadastrarUsuarioServlet' method='POST'>" +
                          "Nome: <input type='text' name='nome'><br>" +
                          "Login: <input type='text' name='login'><br>" +
                          "Senha: <input type='password' name='senha'><br>" +
                          "<button type='submit'>Salvar</button><br>" +
                        "</form>");
            out.println("<h1>Usuarios</h1>");
            out.println("<style>"
                            + "table, td, th {"
                                + "border: 1px solid black;"
                                + "padding: 5px;"
                                + "border-collapse: collapse;"
                            + "}"
                            + "</style>");
            out.println("<table>" +
                            "<tr>" +
                                "<th>Nome</th>" +
                                "<th>Login</th>" +
                                "<th>Senha</th>" +
                            "</tr>"
            );

            for (int i=0; i<usuarios.size(); i++) {
                out.println("<tr>");
                    out.println("<td>" + usuarios.get(i).getNome() + "</td>");
                    out.println("<td>" + usuarios.get(i).getLogin() + "</td>");
                    out.println("<td>" + usuarios.get(i).getSenha() + "</td>");
                out.println("</tr>");
            }
            out.println("</table>");
            out.println("<a href='" + request.getContextPath() + "/LogoutServlet'>Logout</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
