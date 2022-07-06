package jdbc;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.sql.SQLException;
import java.util.Set;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

import com.skillstorm.ExpenseDao;
import com.skillstorm.javabeans.Employee;

public class EmployeeDaoTest {

	static ExpenseDao expenseDao;
	
	@BeforeClass
	public static void setUp() 
	{
		try {
			expenseDao = new ExpenseDao();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	public void findAll() 
	{
		try {
			Set<Employee> employees = expenseDao.findAll();
			for(Employee row: employees) 
			{
				System.out.println("-Employee ID: " + row.getId() + ", " 
						+ row.getName() + ": Reason: " + row.getReason());
			}
			
			assertTrue(employees.size() > 0);
		}
		catch(SQLException e) 
		{
			e.printStackTrace();
			fail();
		}
	}
	
	@Test
	@Ignore
	public void findById() 
	{
		try {
			Employee expected = new Employee(3, "jake", "Travel", "Drove from office to client");
			assertEquals(expected, expenseDao.findById(3));
			System.out.println(expected.getId() + ", " + expected.getName() +
					", " + expected.getReason() + ", " + expected.getNotes());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			fail();
		}
	}
	
	@Test
	public void create() 
	{
		try {		
			Employee employee = expenseDao.createEmployeeRecord(new Employee("bob"));
			System.out.println(employee);
		}
		catch(SQLException e) 
		{
			e.printStackTrace();
			fail();
		}
		
	}
	
	@Test
	@Ignore
	public void delete() 
	{
		try {
			boolean success = expenseDao.deleteRecord(11);
			assertTrue(success);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			fail();
		}
	}
	
	@Test
	@Ignore
	public void update() 
	{
		try {
			expenseDao.UpdateRecord(new Employee(12, "Saitama", "destroyed equipment", "accidentally punched monitor"));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}
}
