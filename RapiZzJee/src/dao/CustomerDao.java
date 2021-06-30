package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.Customer;

public class CustomerDao implements InterfaceDao<Customer>{
	private static Connection connexionDB;
    private static PreparedStatement CusotmerGet;
    
    public CustomerDao () {
    	
    }
	
	public Customer getCustomer(String mail, String pwd) {
		try {
            connexionDB = DaoConnection.connexionBD();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
		final String customerGet = "select * from customer inner join person p on customer.idCustomer = p.idPerson where customer.mail = ? and customer.mail";
		try {	
			CusotmerGet = connexionDB.prepareStatement(customerGet);
			CusotmerGet.setString(1, mail);
			CusotmerGet.setString(2, pwd);
            final ResultSet res = CusotmerGet.executeQuery();
            while (res.next()) {
            	Customer customer = new Customer(res.getInt("idCustomer"), res.getString("namePerson"), res.getString("surnamePerson"), res.getDate("birthDate"), res.getString("mail"), res.getString("phone"), res.getString("address"), res.getString("ville"), res.getInt("postalCode"), res.getFloat("balance"));
            	return customer;
            }
		}
        catch (SQLException e2) {
            e2.printStackTrace();
        }
		return null;
	}

	@Override
	public void addObject(Customer obj) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void upadteObject(Customer obj) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteObject(Customer obj) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Customer getObject(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
