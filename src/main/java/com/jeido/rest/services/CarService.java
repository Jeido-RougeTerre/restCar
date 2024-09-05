package com.jeido.rest.services;

import com.jeido.rest.entities.Car;
import jakarta.enterprise.context.ApplicationScoped;

import java.util.ArrayList;
import java.util.List;

@ApplicationScoped
public class CarService {
    private final List<Car> cars;

    public CarService() {
        cars = new ArrayList<Car>();

        cars.add(new Car( cars.size(),"subaru-legacy awd turbo", 1993, "Cobalt"));
        cars.add(new Car( cars.size(),"toyota-camry", 1993, "Navy"));
        cars.add(new Car( cars.size(),"ferrari-testarossa", 1985, "Red"));

    }

    public Car save(String model, int year, String color) {

        Car car = new Car(cars.size(), model, year, color);
        cars.add(car);
        return car;
    }

    public Car getCar(int id) {
        return cars.stream().filter( car -> car.getId() == id).findFirst().orElse(null);
    }

    public List<Car> getCars() {
        return cars;
    }

    public Car update(int id, String model, int year, String color) {
        Car car = getCar(id);

        if (car == null) {
            return null;
        }

        car.setModel(model);
        car.setYear(year);
        car.setColor(color);
        return car;
    }

    public boolean delete(int id) {
        Car car = getCar(id);
        if (car == null) {
            return false;
        }
        cars.remove(car);
        return true;
    }
}
