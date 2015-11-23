package com.cidx.rest.mfa;

import java.util.Set;
import java.util.HashSet;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;


@ApplicationPath("/api")

public class MfaWS extends Application {
	
	    @Override
	    public Set<Class<?>> getClasses() {
	    	
		Set<Class<?>> set = new HashSet<Class<?>>();
	        set.add(MfaWSImpl.class);
	        return set;
	    }
	    
	
}
/*
public class CidxMfa extends ResourceConfig {
	
    @Override
    public Set<Class<?>> getClasses() {
    	
	Set<Class<?>> set = new HashSet<Class<?>>();
        set.add(CidxMfaWS.class);
        return set;
    }
 
}
 */  


