package com.jeido.rest.resources;

import com.jeido.rest.entities.Car;
import com.jeido.rest.services.CarService;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.List;

@Path("/carsresp")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class CarResponse {
    private CarService carService;

    @Inject
    public CarResponse(CarService carService) {
        this.carService = carService;
    }

    @POST
    public Response create(Car car) {
        carService.save(car.getModel(), car.getYear(), car.getColor());
        return Response.status(Response.Status.CREATED).entity(car).build();
    }

    @GET
    public List<Car> getAll() {
        return carService.getCars();
    }

    @GET
    @Path("/{id}")
    public Response get(@PathParam("id") int id) {
        Car car = carService.getCar(id);
        if (car == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        return Response.ok(car).build();
    }

    @PUT
    @Path("/{id}")
    public Response update(@PathParam("id") int id, Car car) {
        Car carUpdated = carService.update(id, car.getModel(), car.getYear(), car.getColor());
        if (carUpdated == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        return Response.ok(carUpdated).build();
    }

    @DELETE
    @Path("/{id}")
    public Response delete(@PathParam("id") int id) {
        boolean deleted = carService.delete(id);
        if (deleted) {
            return Response.status(Response.Status.NO_CONTENT).build();
        }
        return Response.status(Response.Status.NOT_FOUND).build();
    }

}
