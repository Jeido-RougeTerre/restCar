package com.jeido.rest;

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
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Car getCar(@QueryParam("id") int id) {
        return carService.getCar(id);
    }
    
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Car postCar(Car car) {
        return carService.save(car.getModel(), car.getYear(), car.getColor());        
    }
    
    @POST
    @Path("{id}{name}{year}{color}")
    @Produces(MediaType.APPLICATION_JSON)
    public Car updateCar(@QueryParam("id") int id, @QueryParam("model") String model, @QueryParam("year") int year, @QueryParam("color") String color) {
        return carService.update(id, model, year, color);
    }
    
    @DELETE
    @Path("{id}")
    public int deleteCar(@PathParam("id") int id) {
        return carService.delete(id)? id : -1;
    }
    
    
}