package br.edu.ifnmg.web.grupostrabalho;

import br.edu.ifnmg.web.grupostrabalho.cargadados.CargaDadosLocal;
import br.edu.ifnmg.web.grupostrabalho.pessoa.PessoaBeanLocal;
import br.edu.ifnmg.web.grupostrabalho.util.Util;
import java.io.IOException;
import java.io.PrintWriter;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.transaction.Transactional;

/**
 *
 * @author dayan
 */
@Transactional
@WebServlet(name = "Relatorios", urlPatterns = {"/Relatorios"})
public class Relatorios extends HttpServlet {

    @Inject
    private PessoaBeanLocal pessoaBean;
    
    @Inject
    private CargaDadosLocal cargaDadosBean;
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
        try ( PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */

            StringBuilder sb = new StringBuilder();

            sb.append("<!DOCTYPE html>");
            sb.append("<html>");
            sb.append("<head>");
            sb.append("<title>Servlet Relatorios</title>");
            sb.append("</head>");
            sb.append("<body>");
            sb.append("<h1>Relatórios</h1>");
            sb.append("<a href=\"index.html\">Voltar</a>");
            sb.append("<h2>Consulta 1.A: Quais as pessoas (dados completos) cadastradas? Por meio de Query </h>");

            
            sb.append("<h2>Consulta 1.C: Quais as pessoas (dados completos) cadastradas? Por meio de TypedQuery </h>");
            

            
            sb.append("<h2>Consulta 1.C: Quais as pessoas (dados completos) cadastradas? Por meio de NamedQuery </h>");
            
            
            
            
            sb.append("<h2>Consulta 2.A: Quais os nomes das pessoas? Por meio de Query </h>");
            sb.append("<pre>");
            sb.append(Util.toJson(pessoaBean.findNomeQuery()));
            sb.append("</pre>");
            
            sb.append("<h2>Consulta 2.B: Quais os nomes das pessoas? Por meio de TypedQuery </h>");
            sb.append("<pre>");
            sb.append(Util.toJson(pessoaBean.findNomeTypedQuery()));
            sb.append("</pre>");
            
            sb.append("<h2>Consulta 2.C: Quais os nomes das pessoas? Por meio de NamedQuery </h>");
            sb.append("<pre>");
            sb.append(Util.toJson(pessoaBean.findNomeNamedQuery()));
            sb.append("</pre>");
            
            sb.append("<a href=\"index.html\">Voltar</a>");
            sb.append("</body>");
            sb.append("</html>");

            out.print(sb.toString());

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
