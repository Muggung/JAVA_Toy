package com.employee_manage.model.service;

import static com.employee_manage.model.common.JDBC_Templete.*;

import java.sql.Connection;
import java.util.List;

import com.employee_manage.model.dao.Employee_Dao;
import com.employee_manage.model.dto.Employee;;

public class Service {
	Employee_Dao dao = new Employee_Dao();
	
	public List<Employee> printAllEmployee(){
		Connection conn = getConnection();
		List<Employee> employee = dao.printAllEmployee(conn);
		close(conn);
		return employee;
	}
}
