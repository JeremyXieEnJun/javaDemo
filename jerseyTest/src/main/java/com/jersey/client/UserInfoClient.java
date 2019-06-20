package com.jersey.client;

import javax.ws.rs.core.MediaType;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;

public class UserInfoClient {

 public static final String BASE_URI = "http://localhost:8080/jerseyTest";
 public static final String PATH_AGE = "/UserInfoService/age/";


 
 public static void main(String[] args) {
	    addUser();
	    queryByName();
        queryUsers();
        delUser(1);
        queryUsers();
        updateUser();
        queryUsers();
        queryById(3);
 }


 private static void queryByName() {
	  String name = "Lily";
	  WebResource resource = getResource();
	  WebResource nameResource = resource.path("rest").path("/UserInfoService/name/" + name);
	  System.out.println("按姓名查找 \n"
	    + getClientResponse(nameResource));
	  System.out.println("Response \n" + getResponse(nameResource) + "\n\n");
	
}




private static void queryById(int id) {
	  WebResource resource = getResource();
	  WebResource nameResource = resource.path("rest").path("/UserInfoService/getUserById").path(String.valueOf(id));
	  System.out.println("按ID查找\n"
	    + getClientResponse(nameResource));
	  System.out.println("Response \n" + getResponse(nameResource) + "\n\n");
	
	
}


private static void updateUser() {
	  WebResource resource = getResource();
	  WebResource nameResource = resource.path("rest").path("/UserInfoService").path("updateUser");
	  System.out.println("更新用户\n"
	    + nameResource.accept(MediaType.TEXT_XML,MediaType.APPLICATION_JSON).put(ClientResponse.class));
	  System.out.println("Response \n" + nameResource.accept(MediaType.TEXT_XML,MediaType.APPLICATION_JSON).put(Object.class) + "\n\n");
	
}


private static void delUser(int id) {
	WebResource resource = getResource();
	  WebResource nameResource = resource.path("rest").path("/UserInfoService").path(String.valueOf(id));
	  System.out.println("删除用户：\n"
	    + nameResource.accept(MediaType.TEXT_XML,MediaType.APPLICATION_JSON).delete(ClientResponse.class));
	  System.out.println("Response \n" + nameResource.accept(MediaType.APPLICATION_JSON,MediaType.TEXT_XML).delete(Object.class) + "\n\n");
	
}


private static void queryUsers() {
	  WebResource resource = getResource();
	  WebResource nameResource = resource.path("rest").path("/UserInfoService/getall");
	  System.out.println("查询所有用户:\n"
	    + getClientResponse(nameResource));
	  System.out.println("Response \n" + nameResource.accept(MediaType.APPLICATION_JSON,MediaType.TEXT_XML).get(String.class) + "\n\n");
	
}


private static void addUser() {
	  WebResource resource = getResource();
	  WebResource nameResource = resource.path("rest").path("/UserInfoService/adduser").queryParam("id", "5").queryParam("name", "nn");
	  System.out.println("增加用户: \n"
	    + nameResource.accept(MediaType.APPLICATION_JSON, MediaType.TEXT_XML).post(ClientResponse.class));
	  System.out.println("Response \n" + nameResource.accept(MediaType.APPLICATION_JSON, MediaType.TEXT_XML).post(Object.class) + "\n\n");
	
}


private static String getClientResponse(WebResource resource) {
  return resource.accept(MediaType.APPLICATION_JSON,MediaType.TEXT_XML).get(ClientResponse.class)
    .toString();
 }


 public static String getResponse(WebResource resource) {
  return resource.accept(MediaType.TEXT_XML).get(String.class);
 }
 
 private static WebResource getResource() {
		ClientConfig config = new DefaultClientConfig();
		  Client client = Client.create(config);
		  WebResource resource = client.resource(BASE_URI);
		return resource;
	}

}