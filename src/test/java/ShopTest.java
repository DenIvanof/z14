import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.netology.zadanie.NotFoundException;
import ru.netology.zadanie.Product;
import ru.netology.zadanie.ShopRepository;

public class ShopTest {
    @Test
    public void errorsFind(){
        Product product = new Product(1," Шоколад Milka ",100);
        int extended = 1;
        int actual = product.getId();
        Assertions.assertEquals(extended,actual);
    }
    @Test
    public void removeExistingElement() {
        ShopRepository repository = new ShopRepository();
        Product product1 = new Product(1," Шоколад Milka ",100);
        Product product2 = new Product(2," Шоколад Аленка ",90);
        repository.add(product1);
        repository.add(product2);
        repository.remove(1);
        Product[] products = repository.findAll();
        Assertions.assertEquals(1,products.length);
        Assertions.assertEquals(product2, products[0]);
    }
    @Test
    public void removeNonExistingElement() {
        ShopRepository repository = new ShopRepository();
        Product product1 = new Product(1, " Шоколад Milka ", 100);
        repository.add(product1);

        Assertions.assertThrows(NotFoundException.class, () -> repository.remove(2));
    }
}
