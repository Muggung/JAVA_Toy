package com.employee_manage.model.dao;

import static com.employee_manage.model.common.JDBC_Templete.close;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import com.employee_manage.model.dto.Employee;

public class Employee_Dao {
	Properties prop = new Properties();
	
	{
		String path = Employee_Dao.class.getResource("/sql/employee/employee_sql.properties").getPath();
		
		try(FileReader fr = new FileReader(path)){
			prop.load(fr);
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	public List<Employee> printAllEmployee(Connection conn){
		String sql = prop.getProperty("printAllEmployee");
		List<Employee> employee = new ArrayList<Employee>();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				employee.add(getEmployee(rs));
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(rs);
			close(pstmt);
		}return employee;
	}
	
	private Employee getEmployee(ResultSet rs) throws SQLException {
		Employee emp = new Employee();
		emp.setEmp_Id(rs.getString("EMP_ID"));
		emp.setEmp_Name(rs.getString("EMP_NAME"));
		emp.setEmp_No(rs.getString("EMP_NO"));
		emp.setEmail(rs.getString("EMAIL"));
		emp.setPhone(rs.getString("PHONE"));
		emp.setDept_Code(rs.getString("DEPT_CODE"));
		emp.setJob_Code(rs.getString("JOB_CODE"));
		emp.setSalary(rs.getInt("SALARY"));
		emp.setBonus(rs.getDouble("BONUS"));
		emp.setManager_Id(rs.getString("MANAGER_ID"));
		emp.setHire_Date(rs.getDate("HIRE_DATE"));
		emp.setEnt_Date(rs.getDate("ENT_DATE"));
		emp.setEnt_YN(rs.getString("ENT_YN").charAt(0));
		return emp;
	}
}
