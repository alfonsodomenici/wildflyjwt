package com.airhacks.ping.boundary;

import java.security.Principal;
import javax.annotation.PostConstruct;
import javax.annotation.security.DenyAll;
import javax.annotation.security.RolesAllowed;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import org.eclipse.microprofile.jwt.JsonWebToken;

/**
 *
 * @author airhacks.com
 */
@Path("ping")
@DenyAll
@RequestScoped
public class PingResource {

    @Inject
    Principal principal;

    @Inject
    JsonWebToken jwt;
    
    @PostConstruct
    public void init(){
        
    }
    
    @GET
    @RolesAllowed("hacker")
    public String ping() {
        return String.format("principal: %s groups: %s", principal, jwt.getGroups());
    }

}
