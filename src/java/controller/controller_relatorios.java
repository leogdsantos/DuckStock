/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.kardexDAO;
import dao.relatoriosDAO;
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
import javax.swing.JOptionPane;
import model.itensestoque;
import model.kardex;
import model.relatorios;

/**
 *
 * @author Giovani
 */
@WebServlet(name = "controller_relatorios", urlPatterns = {"/controller_relatorios"})
public class controller_relatorios extends HttpServlet {

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
            throws ServletException, IOException, SQLException, ClassNotFoundException, ParseException {
        response.setContentType("text/html;charset=UTF-8");

        String mensagem = "";

        relatoriosDAO relat = new relatoriosDAO();
        relatorios kard = new relatorios();

        String operacao = request.getParameter("btnListaRel");

        try {
            if (operacao.equals("Listar")) {

                SimpleDateFormat datainicio = new SimpleDateFormat("yyyy-MM-dd");
                SimpleDateFormat datafinal = new SimpleDateFormat("yyyy-MM-dd");

                kard.setDatamovimento(datainicio.parse(request.getParameter("datainicio")));
                kard.setDatamovimento2(datafinal.parse(request.getParameter("datafinal")));

                List<relatorios> lista = relat.relatEntradaSaida(kard);

                request.setAttribute("RelEntradaSaida", lista);
                request.getRequestDispatcher("/relEntrdaSaidaLista.jsp").forward(request, response);

            } else if (operacao.equals("vlrestoque")) {

                List<relatorios> lista = relat.relatvlrestoque(kard);

                request.setAttribute("relvalorestoque", lista);
                request.getRequestDispatcher("/relvalorestoqueLista.jsp").forward(request, response);

            } else if (operacao.equals("baixogiro")) {

                SimpleDateFormat datainicio = new SimpleDateFormat("yyyy-MM-dd");
                SimpleDateFormat datafinal = new SimpleDateFormat("yyyy-MM-dd");

                kard.setDatamovimento(datainicio.parse(request.getParameter("datainicio")));
                kard.setDatamovimento2(datafinal.parse(request.getParameter("datafinal")));

                List<relatorios> lista = relat.relatBaixoGiro(kard);

                request.setAttribute("RelBaixoGiroLista", lista);
                request.getRequestDispatcher("/relbaixogiroLista.jsp").forward(request, response);

            }

        } catch (ClassNotFoundException ex) {
            mensagem = "Erro! " + ex.getMessage();
            //String titleBar = "ATENÇÃO";
            //JOptionPane.showMessageDialog(null, mensagem, "InfoBox: " + titleBar, JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException ex) {
            mensagem = "Erro com o banco de dados! " + ex.getMessage();
            //String titleBar = "ATENÇÃO";
            //JOptionPane.showMessageDialog(null, mensagem, "InfoBox: " + titleBar, JOptionPane.INFORMATION_MESSAGE);
        }
        request.setAttribute("Mensagem", mensagem);
        request.getRequestDispatcher("/Relatorios.jsp").forward(request, response);
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
        } catch (SQLException ex) {
            Logger.getLogger(controller_relatorios.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(controller_relatorios.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ParseException ex) {
            Logger.getLogger(controller_relatorios.class.getName()).log(Level.SEVERE, null, ex);
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
        } catch (SQLException ex) {
            Logger.getLogger(controller_relatorios.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(controller_relatorios.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ParseException ex) {
            Logger.getLogger(controller_relatorios.class.getName()).log(Level.SEVERE, null, ex);
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
