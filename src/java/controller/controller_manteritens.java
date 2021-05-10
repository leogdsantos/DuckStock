/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.itensEstoqueDAO;
import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import model.itensestoque;

/**
 *
 * @author Giovani
 */
@WebServlet(name = "controller_manteritens", urlPatterns = {"/controller_manteritens"})
public class controller_manteritens extends HttpServlet {

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
        String mensagem = "";
        try {

            itensEstoqueDAO itensDAO = new itensEstoqueDAO();
            itensestoque itens = new itensestoque();

            String operacao = request.getParameter("btnoperacao");

            if (operacao.equals("Cadastrar")) {
                Double id_ie = Double.parseDouble(request.getParameter("id_ie"));
                int codigogp_id = Integer.parseInt(request.getParameter("codigogp_id"));
                int marca_id = Integer.parseInt(request.getParameter("marca_id"));
                String descricaocurta = request.getParameter("descricaocurta");
                String descricaodetalhada = request.getParameter("descricaodetalhada");

                itens.setId_ie(id_ie);
                itens.setCodigogp_id(codigogp_id);
                itens.setMarca_id(marca_id);
                itens.setDescricaocurta(descricaocurta);
                itens.setDescricaodetalhada(descricaodetalhada);
                itensDAO.cadastrar(itens);

                mensagem = "Cadastrado com sucesso!";

            } else if (operacao.equals("Deletar")) {
                Double id_ie = Double.parseDouble(request.getParameter("id_ie"));
                itens.setId_ie(id_ie);

                itensDAO.deletar(itens);
                mensagem = "Deletado com sucesso!";
                
            } else if (operacao.equals("Alterar")) {
                
                Double id_ie_consulta = Double.parseDouble(request.getParameter("id_ie_consulta"));                
                Double id_ie = Double.parseDouble(request.getParameter("id_ie"));
                int codigogp_id = Integer.parseInt(request.getParameter("codigogp_id"));
                int marca_id = Integer.parseInt(request.getParameter("marca_id"));
                String descricaocurta = request.getParameter("descricaocurta");
                String descricaodetalhada = request.getParameter("descricaodetalhada");

                itens.setId_ie_consulta(id_ie_consulta);
                itens.setId_ie(id_ie);
                itens.setCodigogp_id(codigogp_id);
                itens.setMarca_id(marca_id);
                itens.setDescricaocurta(descricaocurta);
                itens.setDescricaodetalhada(descricaodetalhada);

                itensDAO.atualizar(itens);
                mensagem = "Atualizado com sucesso!";
                
            } else if (operacao.equals("Listar")) {
                List<itensestoque> lista = itensDAO.consultarItens();               

                request.setAttribute("listaitens", lista);
                request.getRequestDispatcher("/itensLista.jsp").forward(request, response);

                mensagem = "Consulta";

            }
        } catch (ClassNotFoundException ex) {
            mensagem = "Erro! " + ex.getMessage();
        } catch (SQLException ex) {
            mensagem = "Erro com o banco de dados! " + ex.getMessage();
        }

        request.setAttribute("Mensagem", mensagem);
        request.getRequestDispatcher("/itens.jsp").forward(request, response);
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
