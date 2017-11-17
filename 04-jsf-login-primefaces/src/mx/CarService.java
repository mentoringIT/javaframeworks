package mx;
 
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
 
@ManagedBean(name = "carService")
@ApplicationScoped
public class CarService {
     
    private final static String[] colors;
     
    private final static String[] brands;
     
    static {
        colors = new String[10];
        colors[0] = "Black";
        colors[1] = "gray";
        colors[2] = "Green";
        colors[3] = "Red";
        colors[4] = "Blue";
        colors[5] = "Orange";
         
        brands = new String[10];
        brands[0] = "hibernate";
        brands[1] = "javaee";
        brands[2] = "jsf";
        brands[3] = "maven";
        brands[4] = "primefaces";
        brands[5] = "spring";
    }
     
    public List<Car> createCars(int size) {
        List<Car> list = new ArrayList<Car>();
        for(int i = 0 ; i < size ; i++) {
            list.add(new Car(getRandomId(), getRandomBrand(), getRandomYear(), getRandomColor(), getRandomPrice(), getRandomSoldState()));
        }
         
        return list;
    }
     
    private String getRandomId() {
        return UUID.randomUUID().toString().substring(0, 4);
    }
     
    private int getRandomYear() {
        return (int) (Math.random() * 50 + 1960);
    }
     
    private String getRandomColor() {
        return colors[(int) (Math.random() * 6)];
    }
     
    private String getRandomBrand() {
        return brands[(int) (Math.random() * 6)];
    }
     
    public int getRandomPrice() {
        return (int) (Math.random() * 10);
    }
     
    public boolean getRandomSoldState() {
        return (Math.random() > 0.5) ? true: false;
    }
 
    public List<String> getColors() {
        return Arrays.asList(colors);
    }
     
    public List<String> getBrands() {
        return Arrays.asList(brands);
    }
}