package com.jeido.rest;

import jakarta.ws.rs.container.ContainerRequestContext;
import jakarta.ws.rs.container.ContainerResponseContext;
import jakarta.ws.rs.container.ContainerResponseFilter;
import jakarta.ws.rs.ext.Provider;

@Provider
public class CorsFilter implements ContainerResponseFilter {
    @Override
    public void filter(ContainerRequestContext requestContext, ContainerResponseContext responseContext) {
        responseContext.getHeaders().add("Access-Control-Allow-Origin", "*"); // allows all origins
        responseContext.getHeaders().add("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE"); // allows those methods
        responseContext.getHeaders().add("Access-Control-Allow-Header", "Content-Type, Authorization"); // for cross-origin
    }
}
