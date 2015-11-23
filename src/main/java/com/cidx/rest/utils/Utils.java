
package com.cidx.rest.utils;
/*
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
*/
import java.beans.XMLEncoder;
import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
/**
 *
 * @author piyush
 */
import java.util.List;

import javax.xml.bind.annotation.XmlAnyElement;

import com.google.gson.Gson;

class ListWrapper<T> {

    private List<T> items;

    public ListWrapper() {
        items = new ArrayList<>();
    }

    public ListWrapper(List<T> items) {
        this.items = items;
    }

    @XmlAnyElement(lax = true)
    public List<T> getItems() {
        return items;
    }
}

public class Utils {

    public static String toXML(Object obj) {
        String xml = null;

        try {
            ByteArrayOutputStream out = new ByteArrayOutputStream();
            XMLEncoder encoder = new XMLEncoder(out);
          
            encoder.writeObject(obj); // serialize to XML
            encoder.close();
            xml = out.toString(); // stringify
        } catch (Exception e) {
        	throw new RuntimeException(e);
        	
        }
        return xml;
    }
/*
    public static String toXml(List<?> list , String listName, Class classname) {
        String xml = null ; 
        try {

            JAXBContext jc = JAXBContext.newInstance(ListWrapper.class, classname);
            Marshaller marshaller = jc.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            xml = marshal(marshaller, list, listName);
        } catch (JAXBException ex) {
            Logger.getLogger(Utils.class.getName()).log(Level.SEVERE, null, ex);
        }
        return xml ; 

    }
    */
    /*
    public static String toXml(List<Table> listTables) {
        String xml = null ; 
        try {

            JAXBContext jc = JAXBContext.newInstance(ListWrapper.class, Table.class);
            Marshaller marshaller = jc.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            xml = marshal(marshaller, listTables, "Tables");
        } catch (JAXBException ex) {
            Logger.getLogger(Utils.class.getName()).log(Level.SEVERE, null, ex);
        }
        return xml ; 

    }
    */
    

    public static String toJson(List<?> list ) { 
        
        String json = new Gson().toJson(list);
    //    System.out.println(json);
        return json;
    }
    /*
    private static String marshal(Marshaller marshaller, List<?> list, String name)
            throws JAXBException {

        QName qName = new QName(name);

        ListWrapper wrapper = new ListWrapper(list);

        JAXBElement<ListWrapper> jaxbElement = new JAXBElement<ListWrapper>(qName, ListWrapper.class, wrapper);
        StringWriter stringWriter = new StringWriter();
        marshaller.marshal(jaxbElement, stringWriter);
        return stringWriter.toString();
       
    }
    */
    /*
    public static String readSqlFromFile(String fileName) {
    	

		InputStream inputStream = Utils.class.getResourceAsStream("/" + fileName);
		BufferedReader br = new BufferedReader(new InputStreamReader(inputStream));

		StringBuilder sb = new StringBuilder();
		String line;

		try {
			while ((line = br.readLine()) != null) {
				sb.append(" " + line);
			}

		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
					br.close();
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
		return sb.toString();

	}
*/

}
