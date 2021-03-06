package edu.ycp.cs320.teamproject.tbag.db.persist;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import edu.ycp.cs320.teamproject.tbag.model.Agent;
import edu.ycp.cs320.teamproject.tbag.model.Description;
import edu.ycp.cs320.teamproject.tbag.model.Item;
import edu.ycp.cs320.teamproject.tbag.model.Location;
import edu.ycp.cs320.teamproject.tbag.model.User;

public class InitialData 
{
	
	public static List<Item> getInventory() throws IOException{
		List<Item> inventory = new ArrayList<Item>();
		ReadCSV readInventory = new ReadCSV("inventory.csv");
		try 
		{
			//auto-generated primary key for inventory table
			Integer itemID = 1; 
			while (true) 
			{
				List<String> tuple = readInventory.next();
				if (tuple == null) 
				{
					break;
				}
				Iterator<String> i = tuple.iterator();
				Item item = new Item();
				
				item.setItemID(itemID++);
				item.setLocationID(Integer.parseInt(i.next()));
				item.setName(i.next());
				item.setItemDescription(i.next());
				inventory.add(item);
			}
			System.out.println("Inventory loaded from CSV file");
			return inventory;
		} 
		finally 
		{
			readInventory.close();
		}
	}
	
	public static List<Location> getLocations() throws IOException{
		List<Location> locationList = new ArrayList<Location>();
		ReadCSV readLocations = new ReadCSV("locations.csv");
		try 
		{
			//auto-generated primary key for location table
			Integer locationID = 1; 
			while (true) 
			{
				List<String> tuple = readLocations.next();
				if (tuple == null) 
				{
					break;
				}
				Iterator<String> i = tuple.iterator();
				Location location = new Location();
				location.setLocationID(locationID++);
				location.setShortDescription(i.next());
				location.setLongDescription(i.next());
				location.setPlayerHasBeen(Integer.parseInt(i.next()));
				location.setLocationNorth(Integer.parseInt(i.next()));
				location.setLocationSouth(Integer.parseInt(i.next()));
				location.setLocationEast(Integer.parseInt(i.next()));
				location.setLocationWest(Integer.parseInt(i.next()));
				location.setLocationUp(Integer.parseInt(i.next()));
				location.setLocationDown(Integer.parseInt(i.next()));
				locationList.add(location); 
				
				
			}
			System.out.println("Locations loaded from CSV file");
			return locationList;
		} 
		finally 
		{
			readLocations.close();
		}
		
		
	}
	
	
	public static List<User> getUsers() throws IOException{
		List<User>  userList = new ArrayList<User>();
		ReadCSV readUsers = new ReadCSV("users.csv");
		try 
		{
			//auto-generated primary key for location table
			Integer agentID = 1;
			Integer userID = 1;
			while (true) 
			{
				List<String> tuple = readUsers.next();
				if (tuple == null) 
				{
					break;
				}
				Iterator<String> i = tuple.iterator();
				User user = new User(); 
				user.setAgentID(agentID++);
				user.setUsername(i.next());
				user.setDBPassword(i.next());
				user.setJSPPassword(i.next());
				user.setLocationID(userID);
				userList.add(user);
				
				
			}
			System.out.println("Users loaded from CSV file");
			return userList;
		} 
		finally 
		{
			readUsers.close();
		}
		
		
	}

	public static List<Description> getDescriptions() throws IOException {
		// TODO Auto-generated method stub
		return null;
	}

	public static List<Agent> getAgents() throws IOException {
		List<Agent>  agentList = new ArrayList<Agent>();
		ReadCSV readAgents = new ReadCSV("agents.csv");
		try 
		{
			//auto-generated primary key for agent table
			while (true) 
			{
				List<String> tuple = readAgents.next();
				if (tuple == null) 
				{
					break;
				}
				Iterator<String> i = tuple.iterator();
				Agent agent = new Agent();
				agent.setLocationID(Integer.parseInt(i.next()));
				agent.setAgentDescription(i.next());
				agentList.add(agent);
				
				
			}
			System.out.println("Agents loaded from CSV file");
			return agentList;
		} 
		finally 
		{
			readAgents.close();
		}
	}

		
}