package sit.int202.classicmodelweb.repositories;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import sit.int202.classicmodelweb.entities.Product;
import sit.int202.classicmodelweb.services.EntityManagerService;

import java.util.List;

public class ProductRepository {
    private static final int PAGE_SIZE = 10;

    private EntityManager getEntityManager() {
        return EntityManagerService.getEntityManager();
    }

    public int getDefaultPageSize() {
        return PAGE_SIZE;
    }

    public Product find(String productCode) {
        EntityManager entityManager = getEntityManager();
        Product product = entityManager.find(Product.class, productCode);
        entityManager.close();
        return product;
    }

    public List<Product> findAll(int page, int pageSize) {
        int startPosition = (page - 1) * pageSize; // หาตำแหน่งเริ่มต้น
        EntityManager entityManager = getEntityManager();
        Query query = entityManager.createNamedQuery("Product.FindAll"); // query ที่เขียนไว้แล้ว
        query.setFirstResult(startPosition); // หาตำแหน่งเริ่มต้นใน page นั้น
        query.setMaxResults(pageSize); // แสดงกี่รายการ
        List<Product> productList = query.getResultList(); // generate สิ่งที่จะแสดง
        entityManager.close();
        return productList; // ออกไปตามที่เราต้องการ
    }

    public int countAll() {
        EntityManager entityManager = getEntityManager();
        int number = ((Number) entityManager.createNamedQuery("Product.Count").getSingleResult()).intValue(); // นับจำนวนรายการที่มี
        entityManager.close();
        return number;
    }

}
