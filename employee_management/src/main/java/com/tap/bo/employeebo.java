package com.tap.bo;
import java.util.List;
import com.tap.employee;
public interface employeebo {
		int save(employee e);
		int delete(int id);
		int delete(employee e);
		int update(employee e);
		employee get(int id);
		List<employee> getAll();
}
