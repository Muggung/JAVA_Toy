package com.employee_manage.controller;

import java.util.List;

import com.employee_manage.model.common.Employee_Controller;
import com.employee_manage.model.dto.Employee;
import com.employee_manage.model.service.Service;
import com.employee_manage.view.MainView;

public class Controller implements Employee_Controller {	
	private MainView view = new MainView();
	private Service service = new Service();
	
	@Override
	public void mainMenu() {
		new MainView().mainMenu();
	}
	
	@Override
	public void printAllEmployee() {
		List<Employee> employee = service.printAllEmployee();
		new MainView().printAllEmployee(employee);
	}
}
