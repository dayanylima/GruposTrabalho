package br.edu.ifnmg.web.grupostrabalho;

import br.edu.ifnmg.web.grupostrabalho.cargadados.CargaDadosLocal;
import br.edu.ifnmg.web.grupostrabalho.grupo.GrupoBeanLocal;
import br.edu.ifnmg.web.grupostrabalho.atuacao.AtuacaoBeanLocal;
import br.edu.ifnmg.web.grupostrabalho.pessoa.PessoaBeanLocal;
import br.edu.ifnmg.web.grupostrabalho.util.Util;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.Month;
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
    private GrupoBeanLocal grupoBean;

    @Inject
    private AtuacaoBeanLocal atuacaoBean;

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
            sb.append("<h1>Estudo Dirigido: Jakarta Persistence Query Language</h1>");
            sb.append("<a href=\"index.html\">Voltar</a>");

            //<editor-fold defaultstate="collapsed" desc="Consulta 1">
            sb.append("<h2>Consulta 1.A: Quais as pessoas (dados completos) cadastradas? Por meio de Query </h>");
            sb.append("<pre>");
            sb.append(Util.toJson(pessoaBean.findAllPessoaQuerry()));
            sb.append("</pre>");

            sb.append("<h2>Consulta 1.B: Quais as pessoas (dados completos) cadastradas? Por meio de TypedQuery </h>");
            sb.append("<pre>");
            sb.append(Util.toJson(pessoaBean.findAllPessoaTypedQuery()));
            sb.append("</pre>");

            sb.append("<h2>Consulta 1.C: Quais as pessoas (dados completos) cadastradas? Por meio de NamedQuery </h>");
            sb.append("<pre>");
            sb.append(Util.toJson(pessoaBean.findAllPessoaNamedQuery()));
            sb.append("</pre>");
            //</editor-fold>

            //<editor-fold defaultstate="collapsed" desc="Consulta 2">
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
            //</editor-fold>

            //<editor-fold defaultstate="collapsed" desc="Consulta 3">
            sb.append("<h2>Consulta 3.A: Quais as pessoas (nome) e seus respectivos endereços (dados completos)? Por meio de Query </h>");
            sb.append("<pre>");
            sb.append(Util.toJson(pessoaBean.fiindNomeEnderecoQuery()));
            sb.append("</pre>");

            sb.append("<h2>Consulta 3.B: Quais as pessoas (nome) e seus respectivos endereços (dados completos)? Por meio de TypedQuery </h>");
            sb.append("<pre>");
            sb.append(Util.toJson(pessoaBean.fiindNomeEnderecoTypedQuery()));
            sb.append("</pre>");

            sb.append("<h2>Consulta 3.C: Quais as pessoas (nome) e seus respectivos endereços (dados completos)? Por meio de NamedQuery </h>");
            sb.append("<pre>");
            sb.append(Util.toJson(pessoaBean.fiindNomeEnderecoNamedQuery()));
            sb.append("</pre>");
            //</editor-fold>

            //<editor-fold defaultstate="collapsed" desc="Consulta 4">
            sb.append("<h2>Consulta 4.A: Quais pessoas (dados completos) moram em avenidas? Por meio de Query </h>");
            sb.append("<pre>");
            sb.append(Util.toJson(pessoaBean.findPessoaQueMoramEmAvenidaQuery()));
            sb.append("</pre>");

            sb.append("<h2> Consulta 4.B: Quais pessoas (dados completos) moram em avenidas? Por meio de TypedQuery </h>");
            sb.append("<pre>");
            sb.append(Util.toJson(pessoaBean.findPessoaQueMoramEmAvenidaTypedQuery()));
            sb.append("</pre>");

            sb.append("<h2>Consulta 4.C: Quais pessoas (dados completos) moram em avenidas? Por meio de NamedQuery </h>");
            sb.append("<pre>");
            sb.append(Util.toJson(pessoaBean.findPessoaQueMoramEmAvenidaNamedQuery()));
            sb.append("</pre>");
            //</editor-fold>

            //<editor-fold defaultstate="collapsed" desc="Consulta 5">
            sb.append("<h2>Consulta 5.A: Quais pessoas (dados completos) não moram em praças? Por meio de Query</h>");
            sb.append("<pre>");
            sb.append(Util.toJson(pessoaBean.findPessoasQueNaoMoramEmPracaNamedQuery()));
            sb.append("</pre>");

            sb.append("<h2>Consulta 5.B: Quais pessoas (dados completos) não moram em praças? Por meio de TypedQuery </h>");
            sb.append("<pre>");
            sb.append(Util.toJson(pessoaBean.findPessoasQueNaoMoramEmPracaTypedQuery()));
            sb.append("</pre>");

            sb.append("<h2>Consulta 5.C: Quais pessoas (dados completos) não moram em praças? Por meio de NamedQuery</h>");
            sb.append("<pre>");
            sb.append(Util.toJson(pessoaBean.findPessoasQueNaoMoramEmPracaNamedQuery()));
            sb.append("</pre>");
            //</editor-fold>

            //<editor-fold defaultstate="collapsed" desc="Consulta 6">
            sb.append("<h2>Consulta 6.A: Quais os nomes das pessoas e seus respectivos telefones (dados completos)? Por meio de Query </h>");
            sb.append("<pre>");
            sb.append(Util.toJson(pessoaBean.findNomeTelefoneQuery()));
            sb.append("</pre>");

            sb.append("<h2>Consulta 6.B: Quais os nomes das pessoas e seus respectivos telefones (dados completos)? Por meio de TypedQuery</h>");
            sb.append("<pre>");
            sb.append(Util.toJson(pessoaBean.findNomeTelefoneTypedQuery()));
            sb.append("</pre>");

            sb.append("<h2>Consulta 6.C: Quais os nomes das pessoas e seus respectivos telefones (dados completos)? Por meio de NamedQuery </h>");
            sb.append("<pre>");
            sb.append(Util.toJson(pessoaBean.findNomeTelefoneNamedQuery()));
            sb.append("</pre>");
            //</editor-fold>

            //<editor-fold defaultstate="collapsed" desc="Consulta 7">
            sb.append("<h2>Consulta 7: Quais as pessoas (dados completos) que nasceram entre abril de 2001 e abril de 2004?</h>");
            sb.append("<pre>");
            sb.append(Util.toJson(pessoaBean.consulta7ByQuery(LocalDate.of(2001, Month.APRIL, 1), LocalDate.of(2004, Month.APRIL, 30))));
            sb.append("</pre>");
            //</editor-fold>

            //<editor-fold defaultstate="collapsed" desc="Consulta 8">
            sb.append("<h2> </h>");
            sb.append("<pre>");
            //sb.append(Util.toJson());
            sb.append("</pre>");
            //</editor-fold>

            //<editor-fold defaultstate="collapsed" desc="Consulta 9">
            sb.append("<h2> </h>");
            sb.append("<pre>");
            //sb.append(Util.toJson());
            sb.append("</pre>");
            //</editor-fold>

            //<editor-fold defaultstate="collapsed" desc="Consulta 10">
            sb.append("<h2> </h>");
            sb.append("<pre>");
            // sb.append(Util.toJson());
            sb.append("</pre>");
            //</editor-fold>

            //<editor-fold defaultstate="collapsed" desc="Consulta 11">
            sb.append("<h2>Consulta 11: Quais grupos (dados completos) não estão ativos? </h>");
            sb.append("<pre>");
            //sb.append(Util.toJson());
            sb.append("</pre>");
            //</editor-fold>

            //<editor-fold defaultstate="collapsed" desc="Consulta 12">
            sb.append("<h2>Consulta 12: Quais são os líderes (nomes) dos grupos (nomes)? </h>");
            sb.append("<pre>");
            sb.append(Util.toJson(grupoBean.findLiderENomeGrupoByQuery()));
            sb.append("</pre>");
            //</editor-fold>

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
