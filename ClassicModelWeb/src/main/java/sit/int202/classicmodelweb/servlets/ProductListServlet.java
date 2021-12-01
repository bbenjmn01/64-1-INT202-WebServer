package sit.int202.classicmodelweb.servlets;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import sit.int202.classicmodelweb.entities.Product;
import sit.int202.classicmodelweb.repositories.ProductRepository;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "ProductListServlet", value = "/product-list")
public class ProductListServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ProductRepository productRepository = new ProductRepository(); // ต้องการเรียกใช้ getDefaultPageSize() ผ่าน method ที่อยู่ใน ProductRepository()
        String pageParam = request.getParameter("page"); // get ตัวแปรจาก request เพื่อเอามาใช้ใน servlet
        String pageSizeParam = request.getParameter("pageSize");
        int page = pageParam == null ? 1 : Integer.valueOf(pageParam); // default page=1 ถ้าส่งมาจะใช้เลขนั้น
        int pageSize = pageSizeParam == null ? productRepository.getDefaultPageSize() : Integer.valueOf(pageSizeParam); // default page=10 ถ้าส่งมาจะใช้เลขนั้น
        List<Product> productList = productRepository.findAll(page, pageSize); // เรียก method findAll() เพื่อให้แสดงข้อมูลตามที่ต้องการ
        request.setAttribute("products", productList); // ส่งตัวแปรไปกับ request เพื่อเอาไปใช้ใน .jsp
        request.setAttribute("page", page); // แสดง page ที่เท่าไหร่
        request.setAttribute("pageSize", pageSize); // จำนวนสินค้าในแต่ละหน้า
        request.setAttribute("itemCount", productRepository.countAll()); // จำนวนสิ้นค้า
        int itemCount = productRepository.countAll();
        int totalPage = itemCount/pageSize + (itemCount%pageSize==0 ? 0 : 1); // จำนวนสิ้นค้า/จำนวนสินค้าในแต่ละหน้า + เศษที่เหลือมีไหม ถ้ามีก็บวกเพิ่มไปอีกหน้า แต่ไม่เต็มหน้า
        request.setAttribute("totalPage", totalPage); // จำนวนหน้า

        Cookie ck = new Cookie("lastpage", "product-list");
        ck.setMaxAge(7*24*60*60);
        response.addCookie(ck);

        getServletContext().getRequestDispatcher("/ProductList.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
