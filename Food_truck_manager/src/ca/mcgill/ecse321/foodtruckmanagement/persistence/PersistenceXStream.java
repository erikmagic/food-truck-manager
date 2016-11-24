package ca.mcgill.ecse321.foodtruckmanagement.persistence;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import com.thoughtworks.xstream.XStream;

public class PersistenceXStream {
	
	private static XStream xstream = new XStream();
	private static String filename = "manager.xml"; // default name
	
	public static boolean saveToXMLwithXStream(Object o)
	{
		xstream.setMode(XStream.ID_REFERENCES);
		String xml = xstream.toXML(o);
		
		try {
			FileWriter writer = new FileWriter(filename);
			writer.write(xml);
			writer.close();
			return true;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}
	
	public static Object loadFromXMLwithXStream()
	{
		xstream.setMode(XStream.ID_REFERENCES);
		try {
			FileReader file_reader = new FileReader(filename); // load xml
			return xstream.fromXML(file_reader);
		} catch (IOException e) {
			System.out.println("error here");
			e.printStackTrace();
			return null;
		}
	}
	
	public static void setAlias(String xmlTagName,
			Class<?> class_name)
	{
		xstream.alias(xmlTagName, class_name);
	}
	public static void setFileName(String fn)
	{
		filename = fn;
	}
	public static String getFileName(){
		return filename;
	}
	
}
