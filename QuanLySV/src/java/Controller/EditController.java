/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controller;

import Dao.SinhVienDBContext;
import Model.Student;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author DELL
 */
public class EditController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        SinhVienDBContext sinhVienDBContext = new SinhVienDBContext();
        if (request.getParameter("id") != null) {
            Student student = sinhVienDBContext.getStudentById(Integer.parseInt(request.getParameter("id")));
            request.setAttribute("student", student);
            request.getRequestDispatcher("Edit.jsp").forward(request, response);
        }

        // nếu ko có id truyền vào về trang home
        response.sendRedirect("HomeServler");
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
        PrintWriter out = response.getWriter();
        try {
            int idSt = Integer.parseInt(request.getParameter("idSt"))  ;
            String hoTen = request.getParameter("hoTen");
            String ngaySinh = request.getParameter("ngaySinh");
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            Date date = dateFormat.parse(ngaySinh);

            boolean gioiTinh = Boolean.parseBoolean(request.getParameter("gioiTinh"));
            float diemTB = Float.parseFloat(request.getParameter("diemTB"));

            SinhVienDBContext sinhVienDBContext = new SinhVienDBContext();
            Student student = new Student(idSt, hoTen, date, gioiTinh, diemTB);
            sinhVienDBContext.updateStudent(student);
//            out.print(student.toString());
        } catch (Exception e) {
            out.print(e.getMessage());
        }

        response.sendRedirect("HomeServler");
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
