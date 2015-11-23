package com.cidx.rest.utils;

import java.io.*;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.env.Environment;


public class PropertyReader {

	private String googleAuthKey;
	public String getGoogleAuthKey() {
		return googleAuthKey;
	}
	public void setGoogleAuthKey(String googleAuthKey) {
		this.googleAuthKey = googleAuthKey;
	};

	

}
