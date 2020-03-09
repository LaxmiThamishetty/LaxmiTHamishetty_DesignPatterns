package com.epam.DesignPatterns;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

interface Expression { 
	boolean interpreter(String con); 
} 
class TerminalExpression implements Expression { 
	String data; 

	public TerminalExpression(String data) { 
		this.data = data; 
	} 

	public boolean interpreter(String con) { 
		if(con.contains(data)) { 
			return true; 
		} else{ 
			return false; 
		} 
	} 
} 
class OrExpression implements Expression { 
	Expression expr1; 
	Expression expr2; 

	public OrExpression(Expression expr1, Expression expr2) { 
		this.expr1 = expr1; 
		this.expr2 = expr2; 
	} 
	public boolean interpreter(String con) 	{		 
		return expr1.interpreter(con) || expr2.interpreter(con); 
	} 
} 


class AndExpression implements Expression { 
	Expression expr1; 
	Expression expr2; 

	public AndExpression(Expression expr1, Expression expr2) { 
		this.expr1 = expr1; 
		this.expr2 = expr2; 
	} 
	public boolean interpreter(String con) {		 
		return expr1.interpreter(con) && expr2.interpreter(con); 
	} 
} 

//Driver class 
class InterpreterPattern { 
	public static final Logger log =  LogManager.getLogger();

	public static void main(String[] args) { 
		Expression person1 = new TerminalExpression("Laxmi"); 
		Expression person2 = new TerminalExpression("Thamishetty"); 
		Expression isSingle = new OrExpression(person1, person2); 

		Expression vikram = new TerminalExpression("Lakshmi"); 
		Expression committed = new TerminalExpression("Committed"); 
		Expression isCommitted = new AndExpression(vikram, committed);	 

		log.info(isSingle.interpreter("Laxmi")); 
		log.info(isSingle.interpreter("Thamishetty")); 
		log.info(isSingle.interpreter("Lakshmi")); 

		log.info(isCommitted.interpreter("Committed, Lakshmi")); 
		log.info(isCommitted.interpreter("Single, Lakshmi")); 

	} 
} 

