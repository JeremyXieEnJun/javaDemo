package com.jersey.server;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import com.alibaba.fastjson.JSON;
import com.jersey.client.User;
import com.jersey.client.UserDao;

// @Path here defines class level path. Identifies the URI path that 
// a resource class will serve requests for.
@Path("UserInfoService")
public class UserInfo {
	 private UserDao userDao = new UserDao();


 // add
 @POST
 @Path("/adduser")
 @Consumes({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
 @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
 public List<User> createUser(@QueryParam("id") String id, @QueryParam("name") String name) {
	 User user =new User(Integer.valueOf(id), name, null);
     userDao.addUser(user);
     return userDao.getAllUsers();
 }

 // delete
 @DELETE
 @Path("{id}")
 @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
 public List<User> deleteUser(@PathParam("id") String id) {
     userDao.deleteUserById(Integer.valueOf(id));
	 return userDao.getAllUsers();
 }

 // alter
 @PUT
 @Path("/updateUser")
 @Consumes(MediaType.APPLICATION_XML)
 @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
 public List<User> updateUser() {
	 User user  = new User(6,"lily","student");
     userDao.addUser(user);
     return userDao.getAllUsers();
 }

 // query
 @GET
 @Path("/getall")
 @Produces({ MediaType.APPLICATION_JSON })
 public String getAllUsers() {
	 System.out.println(userDao.getAllUsers());
     return JSON.toJSONString(userDao.getAllUsers());
 }

 // query
 @GET
 @Path("/name/{name}")
 @Produces({MediaType.TEXT_XML })
 public String getName(@PathParam("name") String name) {
	 System.out.println("get name");
      return "<User>" + "<Name>" + name + "</Name>" + "</User>";
 }
 // query by id
 @GET
 @Path("getUserById/{id}")
 @Produces({MediaType.TEXT_XML })
 public User getUser(@PathParam("id") String id) {
     return userDao.getUserById(Integer.valueOf(id));
 }
}