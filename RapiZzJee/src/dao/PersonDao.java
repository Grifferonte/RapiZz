package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.Person;

public class PersonDao implements InterfaceDao<Person>{
	private static Connection connexionDB;
    private static PreparedStatement PersonGet;
    
    public PersonDao () {
    	
    }
	
	public Person getPerson(String mail, String pwd) {
		try {
            connexionDB = DaoConnection.connexionBD();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
		final String personGet = "select * from person where mail = ? and mail";
		try {	
			PersonGet = connexionDB.prepareStatement(personGet);
			PersonGet.setString(1, mail);
			PersonGet.setString(2, pwd);
            final ResultSet res = PersonGet.executeQuery();
            while (res.next()) {
            	Person customer = new Person(res.getInt("idPerson"), res.getString("namePerson"), res.getString("surnamePerson"), res.getDate("birthDate"), res.getString("mail"), res.getString("phone"), res.getString("address"), res.getString("ville"), res.getInt("postalCode"));
            	return customer;
            }
		}
        catch (SQLException e2) {
            e2.printStackTrace();
        }
		return null;
	}

	@Override
	public void addObject(Person obj) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void upadteObject(Person obj) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteObject(Person obj) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Person getObject(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
