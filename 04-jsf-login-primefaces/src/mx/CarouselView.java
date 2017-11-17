package mx;
 
import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
 
@ManagedBean
@ViewScoped
public class CarouselView implements Serializable {
     
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private List<Car> cars;
     
    private Car selectedCar;
     
    @ManagedProperty("#{carService}")
    private CarService carService;
     
    @PostConstruct
    public void init() {
        cars = carService.createCars(6);
    }
 
    public List<Car> getCars() {
        return cars;
    }
 
    public Car getSelectedCar() {
        return selectedCar;
    }
 
    public void setSelectedCar(Car selectedCar) {
        this.selectedCar = selectedCar;
    }

	public CarService getCarService() {
		return carService;
	}

	public void setCarService(CarService carService) {
		this.carService = carService;
	}
}