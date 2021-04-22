package ftmk.rmi.sensor;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.HashMap;

import ftmk.rmi.sensor.TemperatureSensor;


public class TemperatureSensorManager extends UnicastRemoteObject implements TemperatureSensor {

	private HashMap<String , Integer> loadTemperatureData()
	{
		HashMap<String , Integer> Temp = new HashMap<>();	
		
		// Hash map value
		Temp.put("Monday", 32);
		Temp.put("Tuesday", 31);
		Temp.put("Wednesday", 33);
		Temp.put("Thursday", 35);
		Temp.put("Friday", 36);
		Temp.put("Saturday", 33);
		Temp.put("Sunday", 33);
		
		return Temp;
	}
	
	public TemperatureSensorManager() throws RemoteException {
		super();
	}

	@Override
	public int getTemperature() throws RemoteException {
		
		return 35;
	}

	@Override
	public int getTemperatureByDay(String day) throws RemoteException {
		
		HashMap <String, Integer> temp = loadTemperatureData();
		
		int temperature = temp.get(day);
		
		return temperature;
	}

	@Override
	public double getAverageTemperature() throws RemoteException {
		
		HashMap <String, Integer> temp = loadTemperatureData();
		
		int totalTemperature=0;
		for (int temperature : temp.values())
		{
			totalTemperature += temperature;
		}
		
		double averageTemperature = (double)totalTemperature/temp.size();
		
		
		return averageTemperature;
	}
	
	

}