/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.kardexDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.kardex;

/**
 *
 * @author Giovani
 */
@WebServlet(name = "controller_kardex", urlPatterns = {"/controller_kardex"})
public class controller_kardex extends HttpServlet {

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
            throws ServletException, IOException, ParseException {
        response.setContentType("text/html;charset=UTF-8");
        
        String mensagem = "";
        //Calendar data = null;
        
        try {
            kardexDAO kardDAO = new kardexDAO();
            kardex kard = new kardex();

            String operacao = request.getParameter("bntkardex");                      
            
            SimpleDateFormat datamov = new SimpleDateFormat("yyyy-MM-dd");
            
            
            
            if (operacao.equals("Cadastrar")) {
                                    
                int codigo_user = Integer.parseInt(request.getParameter("codigo_user"));                
                int tipomovimento_id = Integer.parseInt(request.getParameter("tipomovimento_id"));
                double codigoproduto_id = Double.parseDouble(request.getParameter("codigoproduto_id"));
                double qtdproduto = Integer.parseInt(request.getParameter("qtdproduto"));
                double vlrproduto = Double.parseDouble(request.getParameter("vlrproduto"));
                double vlrmovimento = Double.parseDouble(request.getParameter("vlrmovimento"));
                               
                
                kard.setCodigo_user(codigo_user);
                kard.setDatamovimento(datamov.parse(request.getParameter("datamovimento")));                               
                kard.setTipomovimento_id(tipomovimento_id);
                kard.setCodigoproduto_id(codigoproduto_id);
                kard.setQtdproduto(qtdproduto);
                kard.setVlrproduto(vlrproduto);
                kard.setVlrmovimento(vlrmovimento);

                kardDAO.cadastrar(kard);

                mensagem = "Cadastrado com sucesso!";

            } else if (operacao.equals("Deletar")) {
                int codigo = Integer.parseInt(request.getParameter("codigo"));
                kard.setCodigo(codigo);

                kardDAO.deletar(kard);
                mensagem = "Deletado com sucesso!";

            } else if (operacao.equals("Alterar")) {

                int codigo = Integer.parseInt(request.getParameter("codigo"));
                int codigo_user = Integer.parseInt(request.getParameter("codigo_user"));
                //datamovimento = datamov.parse(request.getParameter("datamovimento"));
                int tipomovimento_id = Integer.parseInt(request.getParameter("tipomovimento_id"));
                double codigoproduto_id = Double.parseDouble(request.getParameter("codigoproduto_id"));
                int qtdproduto = Integer.parseInt(request.getParameter("qtdproduto"));
                double vlrproduto = Double.parseDouble(request.getParameter("vlrproduto"));
                double vlrmovimento = Double.parseDouble(request.getParameter("vlrmovimento"));

                kard.setCodigo(codigo);
                kard.setCodigo_user(codigo_user);
                kard.setDatamovimento(datamov.parse(request.getParameter("datamovimento")));                               
                kard.setTipomovimento_id(tipomovimento_id);
                kard.setCodigoproduto_id(codigoproduto_id);
                kard.setQtdproduto(qtdproduto);
                kard.setVlrproduto(vlrproduto);
                kard.setVlrmovimento(vlrmovimento);

                kardDAO.atualizar(kard);
                mensagem = "Atualizado com sucesso!";

            } else if (operacao.equals("Listar")) {
                //List<kardex> lista = kardDAO.consultar();

                //request.setAttribute("listaitens", lista);
                //request.getRequestDispatcher("/itensLista.jsp").forward(request, response);

                mensagem = "Utilize Relatório de Entrada e Saída";
            }

        } catch (ClassNotFoundException ex) {
            mensagem = "Erro: " + ex.getMessage();
        } catch (SQLException ex) {
            mensagem = "Erro com banco de dados!: " + ex.getMessage();
        }
        request.setAttribute("MensagemKardex", mensagem);
        request.getRequestDispatcher("/kardex.jsp").forward(request, response);
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
        try {
            processRequest(request, response);
        } catch (ParseException ex) {
            Logger.getLogger(controller_kardex.class.getName()).log(Level.SEVERE, null, ex);
        }
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
        try {
            processRequest(request, response);
        } catch (ParseException ex) {
            Logger.getLogger(controller_kardex.class.getName()).log(Level.SEVERE, null, ex);
        }
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
