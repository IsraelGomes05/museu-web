/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifmt.java.main;

import br.edu.ifmt.java.main.obradearte.ObraDeArte;
import br.edu.ifmt.java.main.services.ObraDeArteServico;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Israel 1846
 */
public class ObraDeArteServlet extends HttpServlet {

    private static final ObraDeArteServico obraDeArteServico;

    static {
        obraDeArteServico = new ObraDeArteServico();
    }

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

        ObraDeArte obraDeArte = new ObraDeArte();
        obraDeArte.setAutor(request.getParameter("autor"));
        obraDeArte.setTecnica(request.getParameter("tecnica"));
        obraDeArte.setData(request.getParameter("data"));
        obraDeArte.setTitulo(request.getParameter("titulo"));
        obraDeArte.setProcedencia(request.getParameter("procedencia"));
        obraDeArte.setTipo(request.getParameter("tipo"));

        Boolean cadastrado = obraDeArteServico.cadastrarObraDeArte(obraDeArte);

        response.addHeader("secesso", cadastrado.toString());
        
        response.sendRedirect("CadastrarObrasDeArtes.jsp");
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
