package sit.int202.classicmodelweb.repositories;

import jakarta.persistence.EntityManager;
import sit.int202.classicmodelweb.entities.Office;
import sit.int202.classicmodelweb.services.EntityManagerService;

import java.util.List;

public class OfficeRepository {

    private EntityManager getEntityManager() {
        return EntityManagerService.getEntityManager();
    }

    public Office find(String officeCode){
        EntityManager entityManager = getEntityManager();
        Office office = entityManager.find(Office.class, officeCode);
        entityManager.close(); // ถ้าใช้ LAZY ไม่ควรปิด entityManager.close(); เพราะจะไปดึงข้อมูลอีกรอบไม่ได้
        return  office;
    }

    public List<Office> findAll() {
        EntityManager entityManager = getEntityManager();
        List<Office> offices = entityManager.createNamedQuery("Office.FindALl").getResultList();
        entityManager.close();
        return offices;
    }

    public boolean save(Office office){
        try {
            EntityManager entityManager = getEntityManager();
            entityManager.getTransaction().begin();
            // persist = insert
            entityManager.persist(office);
            entityManager.getTransaction().commit();
            entityManager.close();
        }catch (Exception e){
            return false;
        }
        return true;
    }

    public boolean update(Office office){
        try {
            EntityManager entityManager = getEntityManager();
            entityManager.getTransaction().begin(); // contact database
            entityManager.merge(office); // merge = update
            entityManager.getTransaction().commit();
            entityManager.close();
        }catch (Exception e){
            return false;
        }
        return true;
    }

    public boolean delete(Office office) {
        return delete(office.getId());
    }

    public boolean delete(String officeCode) {
        try {
            EntityManager entityManager = getEntityManager();
            entityManager.getTransaction().begin();
            Office office = find(officeCode); // เรียกใช้ method find ข้างบน
            entityManager.remove(entityManager.contains(office) ? office : entityManager.merge(office));
            entityManager.getTransaction().commit();
            entityManager.close();
        } catch (Exception e) {
            return false;
        }
        return true;
    }

}
