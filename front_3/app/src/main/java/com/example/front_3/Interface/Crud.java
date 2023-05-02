package com.example.front_3.Interface;

import com.example.front_3.Modelo.Employee;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface Crud {

    @GET("/api/getAllEmployees")
    Call<List<Employee>> getAllEmployees();


    @POST("/api/saveEmployee")
    Call<Employee> saveEmployee(@Body Employee employee);




    @GET("/api/getEmployeeById/{id}")
    Call<Employee> getEmployeeById(@Path("id") Long id);


    @DELETE("/api/deleteEmployee/{id}")
    Call<Employee> deleteEmployee(@Path("id") Long id);


    @PUT("/updateEmployee/{id}")
    Call<Employee> updateEmployee(@Path("id") long id, @Body Employee employee);





}
