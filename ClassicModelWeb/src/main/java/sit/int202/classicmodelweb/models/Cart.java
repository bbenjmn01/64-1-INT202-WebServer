package sit.int202.classicmodelweb.models;

import sit.int202.classicmodelweb.entities.Product;
import sit.int202.classicmodelweb.repositories.ProductRepository;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class Cart<K, V extends CartItem /* type ของ V ให้เป็น object ของ CartItem */> {
    private Map<K, V> map; // V: object ของ product ที่อยู่ในตะกร้า

    public Cart() {
        this.map = new HashMap<>();
    }

    public int countItem() {
        return map.size(); // นับจำนวนรายการสินค้า
    }

    public int countPiece() {
        return map.values().stream().mapToInt(o -> o.getQuantity()).sum(); // นับจำนวนชิ้นของสิ้นค้า
    }

    public double getTotalPrice() {
        return map.values().stream().mapToDouble(o -> o.getTotal()).sum(); // คำนวณราคาสิ้นค้าทั้งหมดในตะกร้า
    }

    public void addItem(K key, V value) {
        V item = map.get(key);
        if (item == null) {
            map.put(key, value); // เพิ่มสินค้าเข้าไปใหม่
        } else {
            item.setQuantity(item.getQuantity() + value.getQuantity()); // เพิ่มจำนวนสินค้ารายการนั้น ๆ ที่มีอยู่แล้ว
        }
    }

    public V removeItem(K key) {
        return map.remove(key);
    }

    public void clear() {
        map.clear();
    }

    public Collection<V> getAllItem() {
        return Collections.unmodifiableCollection(map.values()); // ดึงข้อมูลทุกรายการที่อยู่ในตะกร้าออกไปแสดงผล แสดงอย่างเดียว ห้ามแก้ไข
    }
}
