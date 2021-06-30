package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import model.Customer;
import model.Deliverer;
import model.Pizza;
import model.Vehicle;
import model.Ingredient;
import model.Person;;


public class RapiZzDao {
	private static Connection connexionDB;
    private static PreparedStatement VehiculesNotUsed, OrdersByClient, AvgOrders, CustomersOrderedMoreThanAverage, BestCustomer, WorstDeliverer, LeastRequestedPizza, MostRequestedPizza, BestIngredient, ListCustomers, ListDelivers;

    private static RapiZzDao instance;
    
    static {
    	RapiZzDao.instance = new RapiZzDao();
    }

    public static RapiZzDao getInstance() {
        return RapiZzDao.instance;
    }
    
    
    
    public ArrayList<Vehicle> getVehiclesNotUsed() {
		ArrayList<Vehicle> ArrayVehiclesNotused = new ArrayList<Vehicle>();
		try {
            connexionDB = DaoConnection.connexionBD();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
		final String vehiculesNotUsed =  "select plateNumber, typeVehicle from vehicle where plateNumber not in (select plateNumber from orderpizza)";
        try {	
        	VehiculesNotUsed = connexionDB.prepareStatement(vehiculesNotUsed);
            final ResultSet res = VehiculesNotUsed.executeQuery();
            while (res.next()) {
                 Vehicle vehicle = new Vehicle(res.getString("plateNumber"), res.getString("typeVehicle"));
                 ArrayVehiclesNotused.add(vehicle);
            }
            return ArrayVehiclesNotused;
		}
        catch (SQLException e2) {
            e2.printStackTrace();
        }
		return null;
	}
	
	public Map<Integer, Customer> getOrdersByClient() {
		Map<Integer, Customer> MapOrdersByClient = new HashMap<Integer, Customer>();
		try {
            connexionDB = DaoConnection.connexionBD();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
		final String ordersByClient =  "select c.idCustomer, namePerson, surnamePerson, birthDate, mail, phone, address, ville, postalCode, balance, count(idOrderPizza) as OrderByCustomer from orderpizza inner join customer c on orderpizza.idCustomer = c.idCustomer inner join person p on c.idCustomer = p.idPerson group by 1 order by OrderByCustomer desc";
        try {	
        	OrdersByClient = connexionDB.prepareStatement(ordersByClient);
            final ResultSet res = OrdersByClient.executeQuery();
            while (res.next()) {
                 Customer customer = new Customer(res.getInt("idCustomer"), res.getString("namePerson"), res.getString("surnamePerson"), res.getDate("birthDate"), res.getString("mail"), res.getString("phone"), res.getString("address"), res.getString("ville"), res.getInt("postalCode"), res.getFloat("balance"));
                 MapOrdersByClient.put(res.getInt("OrderByCustomer"), customer);
            }
            return MapOrdersByClient;
		}
        catch (SQLException e2) {
            e2.printStackTrace();
        }
		return null;
	}

	public float getAvgOrder() {
		try {
            connexionDB = DaoConnection.connexionBD();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
		final String avgOrders =  "select avg(OrderByCustomer) as AvgOrders from (select c.idCustomer, count(idOrderPizza) as OrderByCustomer from orderpizza inner join customer c on orderpizza.idCustomer = c.idCustomer group by 1 order by 2 desc) as TableOrderByCustomer";
		try {
			AvgOrders = connexionDB.prepareStatement(avgOrders);
            final ResultSet res = AvgOrders.executeQuery();
            while (res.next()) {
            	float avgOrder = res.getFloat("AvgOrders");
            	return avgOrder;
            }
		}
        catch (SQLException e2) {
            e2.printStackTrace();
        }
		return 0;
	}
		
	public ArrayList<Customer> getCustomersOrderedMoreThanAverage() {
		ArrayList<Customer> ArrayCustomersOrderedMoreThanAverage = new ArrayList<Customer>();
		try {
            connexionDB = DaoConnection.connexionBD();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
		final String customersOrderedMoreThanAverage = "select idCustomer, namePerson, surnamePerson, birthDate, mail, phone, address, ville, postalCode, balance, OrderByCustomer from (select c.idCustomer, namePerson, surnamePerson, birthDate, mail, phone, address, ville, postalCode, balance, count(idOrderPizza) as OrderByCustomer from orderpizza inner join customer c on orderpizza.idCustomer = c.idCustomer inner join person p on c.idCustomer = p.idPerson group by 1 order by 2 desc) as TableOrderByCustomer where OrderByCustomer > (select avg(OrderByCustomer) from (select c.idCustomer, count(idOrderPizza) as OrderByCustomer from orderpizza inner join customer c on orderpizza.idCustomer = c.idCustomer group by 1 order by 2 desc) as TableOrderByCustomer)";
        try {	
        	CustomersOrderedMoreThanAverage = connexionDB.prepareStatement(customersOrderedMoreThanAverage);
            final ResultSet res = CustomersOrderedMoreThanAverage.executeQuery();
            while (res.next()) {
            	Customer customer = new Customer(res.getInt("idCustomer"), res.getString("namePerson"), res.getString("surnamePerson"), res.getDate("birthDate"), res.getString("mail"), res.getString("phone"), res.getString("address"), res.getString("ville"), res.getInt("postalCode"), res.getFloat("balance"));
                ArrayCustomersOrderedMoreThanAverage.add(customer);
            }
            return ArrayCustomersOrderedMoreThanAverage;
		}
        catch (SQLException e2) {
            e2.printStackTrace();
        }
        return null;
	}
	
	public Customer getBestCustomer () {
		try {
            connexionDB = DaoConnection.connexionBD();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
		final String bestCustomer = "select idCustomer, namePerson, surnamePerson, birthDate, mail, phone, address, ville, postalCode, balance,  max(Orders) from (select c.idCustomer, namePerson, surnamePerson, birthDate, mail, phone, address, ville, postalCode, balance,  count(idOrderPizza) as Orders from orderpizza inner join customer c on orderpizza.idCustomer = c.idCustomer inner join person p on c.idCustomer = p.idPerson group by 1) as Orders";;
        try {	
        	BestCustomer = connexionDB.prepareStatement(bestCustomer);
            final ResultSet res = BestCustomer.executeQuery();
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
	
	public Deliverer getWorstDeliverer () {
		try {
            connexionDB = DaoConnection.connexionBD();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
		final String worstDeliverer = "select p.idPizza, namePizza, basePrice, count(orderpizza.idPizza) as mostRequetedPizza from orderpizza inner join pizza p on orderpizza.idPizza = p.idPizza group by 1 order by mostRequetedPizza desc limit 1";
        try {	
        	WorstDeliverer = connexionDB.prepareStatement(worstDeliverer);
            final ResultSet res = WorstDeliverer.executeQuery();
            while (res.next()) {
            	Deliverer deliverer = new Deliverer(res.getInt("idDeliverer"), res.getString("namePerson"), res.getString("surnamePerson"), res.getDate("birthDate"), res.getString("mail"), res.getString("phone"), res.getString("address"), res.getString("ville"), res.getInt("postalCode"));
            	return deliverer;
            }
		}
        catch (SQLException e2) {
            e2.printStackTrace();
        }
		return null;
	}
	
	public Pizza getLeastRequestedPizza () {
		try {
            connexionDB = DaoConnection.connexionBD();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
		final String leastRequestedPizza = "select p.idPizza, namePizza, basePrice, count(orderpizza.idPizza) as mostRequetedPizza from orderpizza inner join pizza p on orderpizza.idPizza = p.idPizza group by 1 order by mostRequetedPizza asc limit 1";
        try {	
        	LeastRequestedPizza = connexionDB.prepareStatement(leastRequestedPizza);
            final ResultSet res = LeastRequestedPizza.executeQuery();
            while (res.next()) {
            	Pizza pizza = new Pizza(res.getInt("idPizza"), res.getString("namePizza"), res.getFloat("basePrice"));
            	return pizza;
            }
		}
        catch (SQLException e2) {
            e2.printStackTrace();
        }
		return null;
	}
	
	public Pizza getMostRequestedPizza () {
		try {
            connexionDB = DaoConnection.connexionBD();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
		final String mostRequestedPizza = "select p.idPizza, namePizza, basePrice, count(orderpizza.idPizza) as mostRequetedPizza from orderpizza inner join pizza p on orderpizza.idPizza = p.idPizza group by 1 order by mostRequetedPizza desc limit 1";
        try {	
        	MostRequestedPizza = connexionDB.prepareStatement(mostRequestedPizza);
            final ResultSet res = MostRequestedPizza.executeQuery();
            while (res.next()) {
            	Pizza pizza = new Pizza(res.getInt("idPizza"), res.getString("namePizza"), res.getFloat("basePrice"));
            	return pizza;
            }
		}
        catch (SQLException e2) {
            e2.printStackTrace();
        }
        return null;
	}
	
	public Ingredient getBestIngredient () {
		try {
            connexionDB = DaoConnection.connexionBD();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
		final String bestIngredient = "select c.idIngredient, nameIngredient, count(c.idIngredient) as bestIngredient from orderpizza inner join pizza p on orderpizza.idPizza = p.idPizza inner join compose c on p.idPizza = c.idPizza inner join ingredient i on c.idIngredient = i.idIngredient group by 2 order by bestIngredient desc limit 1";
        try {	
        	BestIngredient = connexionDB.prepareStatement(bestIngredient);
            final ResultSet res = BestIngredient.executeQuery();
            while (res.next()) {
            	Ingredient ingredient = new Ingredient(res.getInt("idIngredient"), res.getString("nameIngredient"));
            	return ingredient;
            }
		}
        catch (SQLException e2) {
            e2.printStackTrace();
        }
        return null;
	}
	
	public List<Customer> getCustomers() {
		ArrayList<Customer> Customers = new ArrayList<>();
		try {
            connexionDB = DaoConnection.connexionBD();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
		final String customers = "select * from customer inner join person p on customer.idCustomer = p.idPerson";
		try {	
			ListCustomers = connexionDB.prepareStatement(customers);
            final ResultSet res = ListCustomers.executeQuery();
            while (res.next()) {
            	Customer customer = new Customer(res.getInt("idCustomer"), res.getString("namePerson"), res.getString("surnamePerson"), res.getDate("birthDate"), res.getString("mail"), res.getString("phone"), res.getString("address"), res.getString("ville"), res.getInt("postalCode"), res.getFloat("balance"));
            	Customers.add(customer);
            }
		}
        catch (SQLException e2) {
            e2.printStackTrace();
            return null;
        }
		return Customers;
	}
	
	public List<Deliverer> getDelivers() {
		ArrayList<Deliverer> Deliverers = new ArrayList<>();
		try {
            connexionDB = DaoConnection.connexionBD();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
		final String delivers = "select * from deliver inner join person p on customer.idDeliver = p.idPerson";
		try {	
			ListDelivers = connexionDB.prepareStatement(delivers);
            final ResultSet res = ListDelivers.executeQuery();
            while (res.next()) {
            	Deliverer deliver = new Deliverer(res.getInt("idDeliver"), res.getString("namePerson"), res.getString("surnamePerson"), res.getDate("birthDate"), res.getString("mail"), res.getString("phone"), res.getString("address"), res.getString("ville"), res.getInt("postalCode"));
            	Deliverers.add(deliver);
            }
		}
        catch (SQLException e2) {
            e2.printStackTrace();
            return null;
        }
		return Deliverers;
	}
	
    public Person getPerson(final String mail, final String pwd) {
    	PersonDao personDao = new PersonDao();
    	return personDao.getPerson(mail, pwd);	    
    }
	

}
