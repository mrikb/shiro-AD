package com.cidx.rest.mfa;

import java.util.Date;
import java.util.concurrent.TimeUnit;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.PathParam;

import com.cidx.ad.ActiveDirectorySvc;
import com.cidx.okta.*;
import com.cidx.rest.dto.Person;
import com.cidx.rest.utils.PropertyReader;
import com.cidx.db.service.OptOut;
import com.cidx.db.service.OptOutServiceImpl;
import com.warrenstrange.googleauth.GoogleAuthenticator;
import com.warrenstrange.googleauth.GoogleAuthenticatorKey;
import com.warrenstrange.googleauth.KeyRepresentation;
import com.warrenstrange.googleauth.GoogleAuthenticatorConfig.GoogleAuthenticatorConfigBuilder;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.Factory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

@Component
@Path("/v1")
public class MfaWSImpl {

	
	private static final Logger log = LoggerFactory.getLogger(MfaWSImpl.class);

	
    @Autowired
	private ActiveDirectorySvc adSvc;
    @Autowired
	private Environment env;
    
    @Autowired
    private OktaSvc oktaSvc ; 
    
    @Autowired 
    private OptOutServiceImpl optOutSvc;
    
	public MfaWSImpl() {
	}
	
	@Bean
    public PropertyReader testBean() {
		PropertyReader testBean = new PropertyReader();
        testBean.setGoogleAuthKey(env.getProperty("GoogleAuthKey"));
        log.info("prop" + testBean.getGoogleAuthKey());
        return testBean;
    }
	
	@GET
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces({ MediaType.APPLICATION_JSON })
	@Path("/tomcat")
	public String adCheck() {
		log.info("inside tomcat auth");
		return "Only tomcat roles should see this.";

	}
	
	
	
	@POST
	@Produces({ MediaType.APPLICATION_JSON })
	@Path("/logon") 
	public Response login(Person person) {
		log.info("Inside login" + person.toString());
		if (!authorize(Integer.parseInt(person.getCode()) )){
			if (SecurityUtils.getSubject()!=null) {
				log.info("Inside get subjects");
				SecurityUtils.getSubject().logout();
			}
			return Response.status(Status.UNAUTHORIZED).build();
		}
        UsernamePasswordToken token = new UsernamePasswordToken(person.getUsername(), person.getPassword());
        Subject currentUser = SecurityUtils.getSubject();
        log.info("Here " + currentUser + ":" + env.getProperty("GoogleAuthKey"));
        
        try {
            currentUser.login(token);
            log.info("We've authenticated! :)");
        } catch (UnknownAccountException ex) {
        	log.info("Unknown user");
        	return Response.ok().build();
        } catch (IncorrectCredentialsException ex) {
        	log.info("Incorrect credentials");
        } catch (LockedAccountException ex) {
        	log.info("Account is Locked");
        } catch (AuthenticationException ex) {
        	log.info("Authentication Exception");
        	ex.printStackTrace();
        	return Response.status(Status.UNAUTHORIZED).build();
        }
        
        if (currentUser.hasRole("tomcat")) {
            log.info("We're authorized! :)");
        } else {
            log.info("We are not authorized :(");
        }
        return Response.ok().build();
	}
	
	
	@GET
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces({ MediaType.APPLICATION_JSON })
	@Path("/admins")
	public String adCheckAdmins() {
		log.info("inside admin");
		
		
		return "Only domain admins should see this.";

	}
	
	@GET
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces({ MediaType.APPLICATION_JSON })
	@Path("/admins/getKey")
	public String generateKey() {
		log.info("inside admin");
		GoogleAuthenticatorConfigBuilder gacb =
				new GoogleAuthenticatorConfigBuilder()
		.setKeyRepresentation(KeyRepresentation.BASE32);
		GoogleAuthenticator googleAuthenticator = new GoogleAuthenticator(gacb.build());

		final GoogleAuthenticatorKey key =
				googleAuthenticator.createCredentials();
		final String secret = key.getKey();

		return secret;

	}
	
	@GET
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces({ MediaType.APPLICATION_JSON })
	@Path("/admins/authorize/{code}")
	public Boolean authorize(@PathParam("code") Integer code) {
		log.info("Inside authorize " + code);
        GoogleAuthenticatorConfigBuilder gacb =
                new GoogleAuthenticatorConfigBuilder()
                        .setTimeStepSizeInMillis(TimeUnit.SECONDS.toMillis(30))
                        .setWindowSize(5);
        GoogleAuthenticator ga = new GoogleAuthenticator(gacb.build());

        boolean isCodeValid = ga.authorize("B2DY5GURXD6CUC5S", code);

        return isCodeValid;
    }
	
	
}
