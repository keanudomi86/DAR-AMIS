/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import dao.Wfp;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;

/**
 * REST Web Service
 *
 * @author BavarianHotdog
 */
@Path("WFP")
public class WFPQuarterService {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of WFPQuarterService
     */
    public WFPQuarterService() {
    }

    /**
     * Retrieves representation of an instance of services.WFPQuarterService
     * @return an instance of dao.Wfp
     */
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Path("Quarterly/{id}")
    public Wfp getJson(@PathParam("id") int id) {
        int quarter = 1;
        //find wfp fata based on id
        //get the data for current quarter
        //return data
        return null;
    }

}
