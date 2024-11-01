/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package control;

import dal.ProductDAO;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Product;

/**
 *
 * @author asus
 */
@WebServlet(name = "UpdateServlet", urlPatterns = {"/update"})
public class UpdateServlet extends HttpServlet {

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
            out.println("<title>Servlet UpdateServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet UpdateServlet at " + request.getContextPath() + "</h1>");
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
        
           int id = Integer.parseInt(request.getParameter("id"));
            ProductDAO pd = new ProductDAO();
//            Product old = pd.getProductByID(id);
//            request.setAttribute("old", old);
            request.getRequestDispatcher("update.jsp").forward(request, response);
                    
       
////        processRequest(request, response);
//        ProductDAO pd = new ProductDAO();
//        int id;
//        try {
//            id = Integer.parseInt(request.getParameter("id"));
//            Product oldProduct = pd.getProductByID(id);
//            PrintWriter out = response.getWriter();
////out.println(oldProduct.getDescription());
//            request.setAttribute("oldProduct", oldProduct);
//            request.getRequestDispatcher("update.jsp").forward(request, response);
//
//        } catch (Exception e) {
//        }
//  request.getRequestDispatcher("update.jsp").forward(request, response);
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
//        processRequest(request, response);
        int id;
        String name = request.getParameter("name");
        int category_id;
        int price;
        String description = request.getParameter("desc");
        String image = request.getParameter("image");
        int quantity;
        ProductDAO pd = new ProductDAO();
        try {
            id = Integer.parseInt(request.getParameter("id"));
            category_id = Integer.parseInt(request.getParameter("category_id"));
            price = Integer.parseInt(request.getParameter("price"));
//               id = Integer.parseInt(request.getParameter("id"));
            quantity = Integer.parseInt(request.getParameter("quantity"));
//            pd.update(new Product(id, name, category_id, price, description, image, quantity));
            response.sendRedirect("dashboard");

        } catch (Exception e) {
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
