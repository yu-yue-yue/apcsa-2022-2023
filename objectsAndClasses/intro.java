package objectsAndClasses;

public class intro {
/**
 * an object is an instantiation of a class, a single instance 
 * object is describing a particular state 
 * class is describing a blueprint; all of the potential kinds 
 * of objects in that class 
 * class: properties, behaviors 
 * properties are innate qualities "baked" into the object
 * 		what data types do I use to describe these qualities
 * behaviors are what the object can do and what can be done to it
 * 		what changes about the object's properties
 */	
	
/** 
 * class cat 
 * properties: int age, boolean (?) gender, string breed, double weight  
 * boolean alive/dead
 * 
 * methods: public boolean killOrResurrect()
 * public double feed(double weightOfFood) 
 * public double exercise(double time)
 */
	
/**
 * fields 
 * to define a field we declare a variable (generally without initializing
 * it -- this will be done in the constructor). This variable should use the 
 * access modifier private for encapsulation purposes
 * only modifiable within the class
 * 
 * getters and setters (accessors and modifiers)
 * 		getters should return the relevant field, and should be named 
 * 		'getFieldName()'
 * 		we need these because private variables can't be accessed outside
 * 		of the class
 * 		setters should take one parameter and set the field to that param
 * 		'setFieldName()'
 * 		getters and setters help us keep our objects in a valid state
 * 
 * constructors
 * 		special type of method; no return type (no void either)
 * 		its name is the same as the class 
 * 		the job of the constructor is to initialize the fields 
 * 		no parameter constructors are default versions
 *       		
 *
 */
}

