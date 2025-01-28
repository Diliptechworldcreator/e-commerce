package com.jsp.ecommerce_jee_project.controller;

import java.io.IOException;
import java.io.InputStream;

import com.jsp.ecommerce_jee_project.dao.CustomerDao;
import com.jsp.ecommerce_jee_project.dao.impl.CustomerDaoImpl;
import com.jsp.ecommerce_jee_project.entity.Customer;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;

@SuppressWarnings("serial")
@WebServlet(value="/customerRegister")
@MultipartConfig
public class RegisterCustomerController extends HttpServlet{
	CustomerDao dao = new CustomerDaoImpl();
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String  name= req.getParameter("customerName");
		String email= req.getParameter("customerEmail");
		String password= req.getParameter("customerPassword");
		Part image = req.getPart("customerImage");
		
		InputStream stream =image.getInputStream();
		
		byte[] image1 =stream.readAllBytes();
		
		System.out.println(stream+" "+image);
		System.out.println(password);
		
		Customer customer = new Customer(name,email,password,image1);
		
		Customer customer1 = dao.saveCustomerDetailDao(customer);
		if(customer1 != null)
			System.out.println("Saved successfully....");
		else {
			System.out.println("Something went wrong..");
		}
	}
}
