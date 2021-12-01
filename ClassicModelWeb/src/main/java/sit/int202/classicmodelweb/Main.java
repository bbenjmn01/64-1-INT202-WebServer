package sit.int202.classicmodelweb;

import at.favre.lib.crypto.bcrypt.BCrypt;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import sit.int202.classicmodelweb.entities.Customer;
import sit.int202.classicmodelweb.entities.Office;
import sit.int202.classicmodelweb.entities.Product;
import sit.int202.classicmodelweb.models.Cart;
import sit.int202.classicmodelweb.models.ClassicModelLineItem;
import sit.int202.classicmodelweb.repositories.CustomerRepository;
import sit.int202.classicmodelweb.repositories.OfficeRepository;
import sit.int202.classicmodelweb.repositories.ProductRepository;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // สร้าง EntityManagerService แทน line: 16-17
//        EntityManagerFactory emf = Persistence.createEntityManagerFactory("classic-model");
//        EntityManager em = emf.createEntityManager();
//        em.close();

        // test OfficeRepository
//        Office office = em.find(Office.class, "2");
//        OfficeRepository officeRepository = new OfficeRepository();
//        Office office = officeRepository.find("2");
//        if(office.getCity().equalsIgnoreCase("bangkok")){
//            office.setCity("Vientiane");
//        }else {
//            office.setCity("Bangkok");
//        }
//        officeRepository.update(office);
//        saveOffice(officeRepository); //<-- call saveOffice
//        deleteOffice(officeRepository);
//        System.out.println(office);
//        System.out.println("--------------------");
//        office.getEmployeeList().forEach(employee -> {
//            System.out.printf("%10d %-10s %-12s %s\n", employee.getId(), employee.getFirstName(), employee.getLastName(), employee.getEmail());
//        });

        // test ProductRepository
//        ProductRepository productRepository = new ProductRepository();
//        System.out.println(productRepository.countAll());
//        System.out.println(productRepository.findAll(1, 15));

        // test Cart
//        Cart<String, ClassicModelLineItem> cart = new Cart<>();
//        ProductRepository productRepository = new ProductRepository();
//        Product product = productRepository.find("S10_1678");
//        cart.addItem(product.getId(), new ClassicModelLineItem(product, 5));
//        product = productRepository.find("S12_3380");
//        cart.addItem(product.getId(), new ClassicModelLineItem(product));
//        System.out.println(cart.countItem());
//        System.out.println(cart.countPiece());
//        System.out.println(cart.getTotalPrice());
//        System.out.println(cart.getAllItem());
//        cart.removeItem("S10_1678");
//        System.out.println(cart.countItem());
//        System.out.println(cart.countPiece());
//        System.out.println(cart.getTotalPrice());
//        System.out.println(cart.getAllItem());

//        test Customer
        CustomerRepository customerRepository = new CustomerRepository();
        String password1 = "1234";
        String password2 = "1235";
        Customer customer = customerRepository.findByName("Jean King");
        System.out.println(customer);
        BCrypt.Result result = BCrypt.verifyer().verify(password1.toCharArray(), customer.getPassword());
        System.out.println("Password "+ password1 + (result.verified ? " is Matched" : " is NOT matched"));
        result = BCrypt.verifyer().verify(password2.toCharArray(), customer.getPassword());
        System.out.println("Password "+ password2 + (result.verified ? " is Matched" : " is NOT matched"));
    }

    private static void saveOffice(OfficeRepository officeRepository) { //<-- สำหรับ insert office ใหม่
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter new office id: ");
        String officeCode = sc.next();
        System.out.print("Enter new office city: ");
        String city = sc.next();

        Office newOffice = new Office();
        newOffice.setId(officeCode);
        newOffice.setCity(city);

        newOffice.setCountry("TH");
        newOffice.setAddressLine1("126 Pracha-utit");
        newOffice.setPhone("012-345-6789");
        newOffice.setPostalCode("10140");
        newOffice.setTerritory("NA");
        if (!officeRepository.save(newOffice)) {
            System.out.println("Error: Can't insert new office");
        }
    }

    private static void deleteOffice(OfficeRepository officeRepository) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter office id to delete: "); //<-- อยากลบ office เบอร์ไหน
        String officeCode = sc.next();
        if (!officeRepository.delete(officeCode)) {
            System.out.println("Error: Can't delete office id: " + officeCode);
        } else {
            System.out.println("Office id " + officeCode + " has been deleted !!");
        }
    }

}
