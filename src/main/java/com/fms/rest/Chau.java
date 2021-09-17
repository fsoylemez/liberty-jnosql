package com.fms.rest;

import com.fms.jnosql.HeroService;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

@Path("/chau")
public class Chau {

    @Inject
    HeroService service;

    @GET
    @Produces
    public String sayChau() {
        service.create();
        return "Chau mau";
    }
}
