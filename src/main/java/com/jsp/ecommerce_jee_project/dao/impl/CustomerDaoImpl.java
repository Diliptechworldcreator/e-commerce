package com.jsp.ecommerce_jee_project.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.jsp.ecommerce_jee_project.connection.ConnectionProvider;
import com.jsp.ecommerce_jee_project.dao.CustomerDao;
import com.jsp.ecommerce_jee_project.entity.Customer;

public class CustomerDaoImpl implements CustomerDao{
	
	Connection conn = ConnectionProvider.getConnection();
	String insertQuery = "INSERT INTO customer(name,email,password,image) VALUES(?,?,?,?)";

	@Override
	public Customer saveCustomerDetailDao(Customer customer) {
		try {
			
			PreparedStatement ps = conn.prepareStatement(insertQuery);
			
			ps.setString(1,customer.getCustomerName());
			ps.setString(2, customer.getCustomerEmail());
			ps.setString(3, customer.getCustomerPassword());
			ps.setBytes(4, customer.getImage());
			
			int a  = ps.executeUpdate();
			
			return a != 0 ? customer:null;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	

}
