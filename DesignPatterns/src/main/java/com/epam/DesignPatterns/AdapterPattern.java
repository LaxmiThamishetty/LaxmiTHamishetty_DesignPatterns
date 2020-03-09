package com.epam.DesignPatterns;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;



interface Bird {
	public static final Logger log =  LogManager.getLogger();
	
	public void fly(); 
	public void makeSound(); 
} 

class Sparrow implements Bird { 
	public void fly() 	{ 
		log.info("Flying"); 
	} 
	public void makeSound()	{ 
		log.info("Chirp Chirp"); 
	} 
} 

interface ToyDuck { 
	public void squeak(); 
} 

class PlasticToyDuck implements ToyDuck { 
	public static final Logger log =  LogManager.getLogger();
	public void squeak() { 
		log.info("Squeak"); 
	} 
} 

class BirdAdapter implements ToyDuck { 
	Bird bird; 
	public BirdAdapter(Bird bird) {
		this.bird = bird; 
	} 

	public void squeak() {  
		bird.makeSound(); 
	} 
} 

class AdapterPattern { 
	public static final Logger log =  LogManager.getLogger();
	public static void main(String args[]) { 
		Sparrow sparrow = new Sparrow(); 
		ToyDuck toyDuck = new PlasticToyDuck(); 

		
		ToyDuck birdAdapter = new BirdAdapter(sparrow); 

		log.info("Sparrow..."); 
		sparrow.fly(); 
		sparrow.makeSound(); 

		log.info("ToyDuck..."); 
		toyDuck.squeak(); 

		
		log.info("BirdAdapter..."); 
		birdAdapter.squeak(); 
	} 
} 

