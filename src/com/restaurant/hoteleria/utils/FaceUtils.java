package com.restaurant.hoteleria.utils;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ResourceBundle;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

public class FaceUtils {
	
	public static void saveSession(String session, Object object) throws Exception {
		FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put(session, object);
	}

	public static Object loadSession(String session) throws Exception {
		return FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get(session);
	}

	public static void removeSession(String session) throws Exception {
		FacesContext.getCurrentInstance().getExternalContext().getSessionMap().remove(session);
	}

	public static void setMessage(String component, String message) {
		FacesContext.getCurrentInstance().addMessage(component, new FacesMessage(message));
	}

	public static String getMessage(String key) {
		ResourceBundle bundle = ResourceBundle.getBundle("ApplicationResources");
		return bundle.getString(key);
	}
	
	public static void log(String clase, String metodo, Object...variables) {
		Date date = new Date();
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		String fechaHora = dateFormat.format(date);		
		System.out.println("<" + fechaHora + ">" + clase + " >> " + metodo);
		for(int index = 0; index < variables.length; index++) {
			if(variables[index] != null) {
				System.out.println("\tVariable[" + index + "] --> " + variables[index]);
			}
		}
	}

	public static void redirectToPage(String page) throws Exception {	
		FacesContext.getCurrentInstance().getExternalContext().redirect(page);
	}
}