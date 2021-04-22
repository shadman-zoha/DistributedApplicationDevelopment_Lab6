import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import ftmk.rmi.sensor.TemperatureSensor;

public class NewTemperatureClientRMIApp {

	public static void main(String[] args) {
		
					
					
			try {
					// Get registry
					Registry rmiRegistry = LocateRegistry.getRegistry();
						
					// Look-up for the remote object
					TemperatureSensor remoteSensorAyerKeroh = (TemperatureSensor) rmiRegistry.lookup("SensorAyerKeroh");
						
					// Invoke method from the remote object
					int currentTemperature = remoteSensorAyerKeroh.getTemperature();
						
					System.out.println("Current Temperature in Ayer Keroh is " + currentTemperature + " Celcius");
			
					// Invoke method from remote object 
					String day = "Sunday";
					int temperature = remoteSensorAyerKeroh.getTemperatureByDay(day);
					
					System.out.println("Current Temperature on " + day +" in Ayer Keroh is " +  temperature + " Celcius");
					
					//Average temperature
					double averageTemperature = remoteSensorAyerKeroh.getAverageTemperature();
					System.out.println("Average temperature is " +  String.format("%.1f", averageTemperature) + " Celcius");
					
					
					
				} catch (RemoteException | NotBoundException e) {
						
						e.printStackTrace();
				}
					
					
		
	}

}