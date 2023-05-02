package com.example.front_3;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.example.front_3.Interface.Crud;
import com.example.front_3.Modelo.Employee;

import java.io.IOException;
import java.util.List;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        //getALL();


     //crearEmpleado();



       // buscar_empleado_id();










       //eliminar_empleado_id();
       /** revisar este metodo */

      // actulizar_empleado();
/**  no funciona */


    }// fn main

    private void actulizar_empleado() {

        long id=146;


        Employee employee = new Employee(146, "nuevo", "nuevo@nuevo.com", "nuevo");



        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://192.168.101.76:8080")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        Crud employeeApi = retrofit.create(Crud.class);



        Call<Employee> call = employeeApi.updateEmployee(id,employee);


        call.enqueue(new Callback<Employee>() {
            @Override
            public void onResponse(Call<Employee> call, Response<Employee> response) {
                if (response.isSuccessful()) {


                    Employee updatedEmployee = response.body();
                    Toast.makeText(getApplicationContext(), "Empleado actualizado: " + updatedEmployee.getFirst_name(), Toast.LENGTH_SHORT).show();

                } else {
                    // Manejar errores
                    Toast.makeText(getApplicationContext(), "Error al actualizar empleado", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<Employee> call, Throwable t) {
                // Manejar errores
                Toast.makeText(getApplicationContext(), "Error al conectar con el servidor", Toast.LENGTH_SHORT).show();
            }
        });




    }


    private void eliminar_empleado_id() {


        long id=1;



        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://192.168.101.76:8080")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        Crud employeeApi = retrofit.create(Crud.class);



        Call<Employee> call = employeeApi.deleteEmployee(id);


        call.enqueue(new Callback<Employee>() {
            @Override
            public void onResponse(Call<Employee> call, Response<Employee> response) {
                if (response.isSuccessful()) {

                    Toast.makeText(getApplicationContext(), "SE ELIMINO", Toast.LENGTH_SHORT).show();


                } else {
                    // Manejar errores
                    Toast.makeText(getApplicationContext(), "no SE ELIMINO", Toast.LENGTH_SHORT).show();
                }
            }



            @Override
            public void onFailure(Call<Employee> call, Throwable t) {
                // Manejar errores
                Toast.makeText(getApplicationContext(), "Error al conectar con el servidor", Toast.LENGTH_SHORT).show();
            }



        });












    }


    private void buscar_empleado_id() {

        long id=2;



        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://192.168.101.76:8080")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        Crud employeeApi = retrofit.create(Crud.class);



        Call<Employee> call = employeeApi.getEmployeeById(id);


        call.enqueue(new Callback<Employee>() {
            @Override
            public void onResponse(Call<Employee> call, Response<Employee> response) {
                if (response.isSuccessful()) {
                    Toast.makeText(getApplicationContext(), "Existe", Toast.LENGTH_SHORT).show();
                    // Hacer algo con el nuevo empleado agregado

                    Employee employee = response.body();


                    String message = "ID: " + employee.getId() + "\n"
                            + "Email: " + employee.getEmail() + "\n"
                            + "First name: " + employee.getFirst_name() + "\n"
                            + "Last name: " + employee.getLast_name();
                    Toast.makeText(MainActivity.this, message, Toast.LENGTH_LONG).show();



                } else {
                    // Manejar errores
                    Toast.makeText(getApplicationContext(), "no existe", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<Employee> call, Throwable t) {
                // Manejar errores
                Toast.makeText(getApplicationContext(), "Error al conectar con el servidor", Toast.LENGTH_SHORT).show();
            }
        });



    }

















    private void crearEmpleado() {


        Employee employee = new Employee(1, "Doe", "johndoe@example.com", "3");


        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://192.168.101.76:8080")
                .addConverterFactory(GsonConverterFactory.create())
                .build();


        Crud employeeApi = retrofit.create(Crud.class);

        Call<Employee> call = employeeApi.saveEmployee(employee);

        call.enqueue(new Callback<Employee>() {
            @Override
            public void onResponse(Call<Employee> call, Response<Employee> response) {
                if (response.isSuccessful()) {
                    Toast.makeText(getApplicationContext(), "Empleado guardado correctamente", Toast.LENGTH_SHORT).show();
                    // Hacer algo con el nuevo empleado agregado
                } else {
                    // Manejar errores
                    Toast.makeText(getApplicationContext(), "Error al guardar empleado", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<Employee> call, Throwable t) {
                // Manejar errores
                Toast.makeText(getApplicationContext(), "Error al conectar con el servidor", Toast.LENGTH_SHORT).show();
            }
        });

    }


    private void getALL() {

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://192.168.101.76:8080")
                .addConverterFactory(GsonConverterFactory.create())
                .build();


        Crud employeeApi = retrofit.create(Crud.class);

        Call<List<Employee>> call = employeeApi.getAllEmployees();


        call.enqueue(new Callback<List<Employee>>() {

            @Override
            public void onResponse(Call<List<Employee>> call, Response<List<Employee>> response) {
                // Crear una instancia de la clase Toast y mostrar el mensaje


                if (response.isSuccessful()) {
                    Toast.makeText(getApplicationContext(), "Entro", Toast.LENGTH_SHORT).show();


                    Employee employee = response.body().get(1);
                    String message = "ID: " + employee.getId() + "\n"
                            + "Email: " + employee.getEmail() + "\n"
                            + "First name: " + employee.getFirst_name() + "\n"
                            + "Last name: " + employee.getLast_name();
                    Toast.makeText(MainActivity.this, message, Toast.LENGTH_LONG).show();










                    // Hacer algo con el nuevo empleado agregado
                } else {
                    // Manejar errores



                    Toast.makeText(getApplicationContext(), "Error: " + response.code(), Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<List<Employee>> call, Throwable t) {
// Crear una instancia de la clase Toast y mostrar el mensaje
                Toast.makeText(getApplicationContext(), "erorr de conexcion", Toast.LENGTH_SHORT).show();

            }
        });


    }








}