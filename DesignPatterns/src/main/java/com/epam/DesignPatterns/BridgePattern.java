package com.epam.DesignPatterns;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

abstract class Vehicle {
	public static final Logger log =  LogManager.getLogger();
	protected Workshop workShop1; 
	protected Workshop workShop2; 

	protected Vehicle(Workshop workShop1, Workshop workShop2) { 
		this.workShop1 = workShop1; 
		this.workShop2 = workShop2; 
	} 

	abstract public void manufacture(); 
} 


class Car extends Vehicle { 
	public Car(Workshop workShop1, Workshop workShop2) { 
		super(workShop1, workShop2); 
	} 

	@Override
	public void manufacture() { 
		log.info("Car "); 
		workShop1.work(); 
		workShop2.work(); 
	} 
} 


class Bike extends Vehicle { 
	public Bike(Workshop workShop1, Workshop workShop2) { 
		super(workShop1, workShop2); 
	} 

	@Override
	public void manufacture() { 
		log.info("Bike "); 
		workShop1.work(); 
		workShop2.work(); 
	} 
} 

 
interface Workshop { 
	abstract public void work(); 
} 

 
class Produce implements Workshop {
	public static final Logger log =  LogManager.getLogger();
	public void work() { 
		log.info("Produced"); 
	} 
} 

 
class Assemble implements Workshop { 
	public static final Logger log =  LogManager.getLogger();
	public void work() { 
		log.info(" And  Assembled."); 
		 
	} 
} 

 
class BridgePattern { 
	public static void main(String[] args) { 
		Vehicle vehicle1 = new Car(new Produce(), new Assemble()); 
		vehicle1.manufacture(); 
		Vehicle vehicle2 = new Bike(new Produce(), new Assemble()); 
		vehicle2.manufacture(); 
	} 
} 