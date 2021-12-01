package sit.int202.classicmodelweb.servlets;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import sit.int202.classicmodelweb.repositories.OfficeRepository;

import java.io.IOException;

@WebServlet(name = "OfficeEmployeeListServlet", value = "/office-list")
public class OfficeEmployeeListServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        OfficeRepository officeRepository = new OfficeRepository(); // สร้าง OfficeRepository() เพื่อเรียกใช้ .findAll()
        request.setAttribute("offices", officeRepository.findAll());
        String officeCode = request.getParameter("officeCode"); // get id ของ office เพื่อส่งไปใช้ select employee
        if (officeCode != null) {
            request.setAttribute("selectedOffice", officeRepository.find(officeCode)); // set find(officeCode) เพื่อส่งไปใช้ select employee ของ office นั้น
        }

        Cookie ck = new Cookie("lastpage", "office-list");
        ck.setMaxAge(7*24*60*60);
        response.addCookie(ck);

        getServletContext().getRequestDispatcher("/OfficeEmployeeList.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
