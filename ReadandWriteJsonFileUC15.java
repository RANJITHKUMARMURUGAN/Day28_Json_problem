package com.json;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import mygroup.myproject.model.Address;
import mygroup.myproject.model.Person;

public class ReadandWriteJsonFileUC15 {
  public static void main(String[] args)  {
	  
	  try {
		ObjectMapper mapper = new ObjectMapper();//convert json string to java object
		InputStream inputStream = new FileInputStream(new File("C:\\Users\\hp\\Desktop\\file.json"));//use to read data from source
		TypeReference<List<Person>> typeReference = new TypeReference<List<Person>>() {};//it indicate the list of person in object
		List<Person> persons = mapper.readValue(inputStream, typeReference);
		for(Person p : persons) {
			System.out.println("\nFirstName is: " + p.getFirstName() + p.getLastName() + "\nCity is: " + p.getAddress().getCity() + "\nAll details is: " + p.getDetails());
		
		}
		
		//To write data
		Person person = new Person();
		person.setFirstName("Kiran");
		person.setLastName("Kumar");
		person.setAge(22);
		person.setAddress(new Address("vijay", "Karnataka", 9885663, "9943312185", "kiran@gmail.com"));
		person.setDetails("This is My Details");
		mapper.writeValue(new File("C:\\Users\\hp\\Desktop\\Outputfile.json"), person);
		inputStream.close();
		
	  	} catch (FileNotFoundException e) {
	  		e.printStackTrace();
	  	} catch (JsonParseException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
  	}
}
