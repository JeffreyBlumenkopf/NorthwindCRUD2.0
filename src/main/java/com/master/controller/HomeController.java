package com.master.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import com.mysql.jdbc.*;

import com.test.models.Customer;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import java.sql.*;// 1
import java.sql.Connection;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;

@Controller
public class HomeController {
    String selectCustomers = "select customerid,companyname,city,country from customers";
    String deleteCustomers = "";
    String url = "jdbc:mysql://localhost:3306/northwind";
    String userName = "chirpus";
    String password = "grant";




    public void deleteCustomers(@RequestParam("id") String cid)
    {

        String deleteCustomers = String.format("delete customerid,companyname,city,country from customers where customerid=%s",cid);

        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        Connection c = null;
        try {
            c = DriverManager.getConnection(url,userName,password);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        Statement st = null;
        try {
            st = c.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        try {
            st.executeQuery(deleteCustomers);
        } catch (SQLException e) {
            e.printStackTrace();
        }


    }


    public ArrayList<Customer> getCustomers()
    {

        try {
            Class.forName("com.mysql.jdbc.Driver");

            Connection c = DriverManager.getConnection(url,userName,password);

            Statement st = c.createStatement();

            ResultSet rs =st.executeQuery(selectCustomers);
            ArrayList<Customer> customerList = new ArrayList<Customer>();

            while (rs.next() == true)
            {
                String customerID = rs.getString(1);
                String companyName = rs.getString(2);
                String city = rs.getString(3);
                String country = rs.getString(4);
                 customerList.add(new Customer(customerID,companyName,city,country));


            }
            return customerList;
        }
        catch(Exception ex)
        {

            // redirect the user to an error page!
            return null;
        }


    }

//    public void deleteCustomer{
//
//
//
//    }


    @RequestMapping("/")

    public ModelAndView helloWorld()
    {
        ArrayList<Customer> customerList = getCustomers();
        return new
                ModelAndView("customerList","cList",customerList);


    }

    @RequestMapping("welcome")

    public ModelAndView helloWorld2()
    {
        return new
                ModelAndView("welcome2","message","Hello World2");

    }

//    @RequestMapping("delCust")

//    public ModelAndView deleteCustomers(@RequestParam("id") String cid)
//    {
//
//
//
//
//
//
//
//        return new
//                ModelAndView("customerList","cList",customerList);
//
//    }

}
