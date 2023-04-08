package com.revature.daos;


import com.revature.models.Employee;
import com.revature.utils.ConnectionUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDAOImpMySQL implements EmployeeDAO {
    private Connection conn;

    public EmployeeDAOImpMySQL(){
        conn = ConnectionUtils.getConnection();
    }
    //This file wasn't used in lecture, but all our JDBC stuff from the Main file would usually go here, it was just put in Main for the sake of time
    public  List<Employee> getAllEmployees(Connection conn){
        String sql = "select * from employee;";
        ArrayList<Employee> employees = new ArrayList<>();
        try{
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while(rs.next()){
                Employee emp = new Employee(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getInt("salary"),
                        rs.getString("job_title")
                );

                employees.add(emp);
            }

        }catch(SQLException e){
            e.printStackTrace();
            return null;
        }
        return employees;
    }

    public  boolean addEmployee(Connection conn, String name, int salary, String jobTitle){
        String sql = "insert into employee(id, name, salary, job_title) values(default, ?,?,?);";

        try{
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, name);
            ps.setInt(2, salary);
            ps.setString(3, jobTitle);

            ps.execute();
        }catch(SQLException e){
            e.printStackTrace();
            return false;
        }
        return true;
    }

    public  void createEmployeeTable(Connection conn){
        String sql = "create table if not exists employee(\n" +
                        "id serial primary key,\n" +
                        "name varchar(100),\n" +
                        "salary numeric,\n" +
                        "job_title varchar(100)\n" +
                    ");";
        try{
          //Either of these work, PreparedStatement is usually preferred
//            PreparedStatement ps = conn.prepareStatement(sql);
//            ps.execute();
            Statement stmt = conn.createStatement();
            stmt.execute(sql);

            System.out.println("Success!");
        }catch(SQLException e){
            e.printStackTrace();
        }
    }
    public  boolean deleteEmployeeById(int id){
//        String sql = "insert into employee(id, name, salary, job_title) values(default, ?,?,?);";
        String sql = "delete from employee where id=?";
        try{
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            ps.execute();
        }catch(SQLException e){
            e.printStackTrace();
            return false;
        }
        return true;
    }
    public  boolean updateEmployeeById(Connection conn, String name, int salary, String jobTitle, int id){
    	  String sql = "update employee set salary=? where id= ?;";
        try{
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, salary);
            ps.setInt(2, id);

            ps.execute();
        }catch(SQLException e){
            e.printStackTrace();
            return false;
        }
        return true;
    }

}

