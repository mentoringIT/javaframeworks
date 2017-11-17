package mx;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

@ManagedBean
@ViewScoped
public class CarDetail implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private List<Car> carShopping;

	@ManagedProperty("#{carService}")
	private CarService carService;

	@PostConstruct
	public void init() {
		setCarShopping(carService.createCars(6));
	}

	public String viewDetail() {
		System.out.println("view detail car shopping");
		return "detail";
	}

	public String continuaComprando() {
		System.out.println("continua comprando");
		return "compras";
	}

	public List<Car> getCarShopping() {
		return carShopping;
	}

	public void setCarShopping(List<Car> carShopping) {
		this.carShopping = carShopping;
	}

	public CarService getCarService() {
		return carService;
	}

	public void setCarService(CarService carService) {
		this.carService = carService;
	}

}