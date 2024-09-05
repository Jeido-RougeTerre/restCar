package com.jeido.rest.resources;

import com.jeido.rest.entities.Car;
import com.jeido.rest.services.CarService;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;

import java.util.List;


@Path("/cars")
public class CarResource {
    private final CarService carService;

    @Inject
    public CarResource(CarService carService) {
        this.carService = carService;
    }

    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Car> getCars() {
        return carService.getCars();
    }
    
    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Car getCar(@PathParam("id") int id) {
        return carService.getCar(id);
    }
    
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Car postCar(Car car) {
        return carService.save(car.getModel(), car.getYear(), car.getColor());        
    }
    
    @PUT
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Car updateCar(@PathParam("id") int id, Car car) {
        return carService.update(id, car.getModel(), car.getYear(), car.getColor());
    }
    
    @DELETE
    @Path("/{id}")
    public int deleteCar(@PathParam("id") int id) {
        return carService.delete(id)? id : -1;
    }
    
    
}