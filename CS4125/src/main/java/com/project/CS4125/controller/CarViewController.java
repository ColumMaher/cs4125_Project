package com.project.CS4125.controller;

import com.project.CS4125.model.*;
import com.project.CS4125.service.CarService;
import com.project.CS4125.service.CustomerFactory;
import com.project.CS4125.service.OrderService;
import com.project.CS4125.service.UserService;
import com.stripe.Stripe;
import com.stripe.exception.StripeException;
import com.stripe.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/car-list")
public class CarViewController {

    @Autowired
    private CarService carService;
    @Autowired
    private UserService userService;
    @Autowired
    private CustomerFactory userFactory;
    @Autowired
    private OrderService orderService;

    @GetMapping
    public String carList(Model model) {

        SportCarBuilder sportCarBuilder = new SportCarBuilder("Ferrari 418");
        LuxuryCarBuilder luxuryCarBuilder = new LuxuryCarBuilder("Rolls Royce Ghost");
        HatchBackCarBuilder hatchBackCarBuilder = new HatchBackCarBuilder("Golf TSI");
        SUVCarBuilder suvCarBuilder = new SUVCarBuilder("Dacia Duster");

        Director director = new Director(sportCarBuilder);
        Car Ferrari = director.getCar();

        director.reset(luxuryCarBuilder);
        Car RRoyce = director.getCar();

        director.reset(hatchBackCarBuilder);
        Car VWGolf = director.getCar();

        director.reset(suvCarBuilder);
        Car SUV = director.getCar();

        if (carService.getAllCars() == null) {
            carService.saveCar(Ferrari);
            carService.saveCar(RRoyce);
            carService.saveCar(VWGolf);
            carService.saveCar(SUV);
        }

        Location limerick = new Location("Limerick");
        limerick.addCar(Ferrari);
        limerick.addCar(RRoyce);

        Location cork = new Location("Cork");
        cork.addCar(VWGolf);
        cork.addCar(SUV);

        //Drop down/table lists per location
        ArrayList<Car> location1cars = new ArrayList<>();
        ArrayList<Car> location2cars = new ArrayList<>();

        ArrayList<Car> cars = (ArrayList<Car>) carService.getAllCars();

        for (int i = 0; i < cars.size() / 2; i++) {
            location1cars.add(cars.get(i));
        }
        for (int i = cars.size() / 2; i < cars.size(); i++) {
            location2cars.add(cars.get(i));
        }

        VehicleUpdatePublisher ferrariSubject = new VehicleUpdatePublisher(Ferrari);
        VehicleUpdatePublisher rrSubject = new VehicleUpdatePublisher(RRoyce);
        VehicleUpdatePublisher golfSubject = new VehicleUpdatePublisher(VWGolf);
        VehicleUpdatePublisher suvSubject = new VehicleUpdatePublisher(SUV);

        ferrariSubject.attach(limerick);
        rrSubject.attach(limerick);

        golfSubject.attach(cork);
        suvSubject.attach(cork);

        model.addAttribute("location1", limerick);
        model.addAttribute("location2", cork);
        model.addAttribute("location1vehicles", location1cars);
        model.addAttribute("location2vehicles", location2cars);

        return "car-list";
    }

    @GetMapping("/car-list/order")
    public String orderVehicle() {
        return "order";
    }
    @GetMapping("/order")
    public String order(@CookieValue(value = "userID") String UserID, @RequestParam(value = "SelectVehicle") String vehicle, Model model){

        Car c = new Car(Integer.valueOf(vehicle));

        c = carService.findCarByID(c);

        System.out.println(c.getVehicleID());
        System.out.println(c.getName());
        System.out.println(c.getEngineSize());
        System.out.println(c.getBodyType());
        System.out.println(c.getSeatCapacity());


        User u = userFactory.createUserByID(Integer.valueOf(UserID));
        u = userService.findUserByID(u);

        Orders order = new Orders(u.getUserID(), c);
        orderService.createOrder(order);
        order = orderService.findOrderByID(order);

        System.out.println(order.getOrderID());
        System.out.println(order.getUserId());
        System.out.println(order.getPaidStatus());

        model.addAttribute("User", u);
        model.addAttribute("Car", c);
        model.addAttribute("order", order);

        System.out.println(u.getName() + u.getUserID());

        return "order";
    }

    @Value("${stripe.apikey}")
    String stripeAPIKEY;
    @GetMapping("/paymentScreen")
    public String paymentScreen(@CookieValue(value = "userID") String UserID) throws StripeException {

        Stripe.apiKey = stripeAPIKEY;

        User u = userFactory.createUserByID(Integer.valueOf(UserID));
        u = userService.findUserByID(u);

        Map<String, Object> params = new HashMap<>();
        params.put("name", u.getName());

        Customer customer = Customer.create(params);

        System.out.println(stripeAPIKEY);

        return "paymentScreen";
    }
    @GetMapping("/paid")
    public String paidScreen(){
        return "paid";
    }
}
