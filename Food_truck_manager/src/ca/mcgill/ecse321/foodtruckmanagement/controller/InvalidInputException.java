package ca.mcgill.ecse321.foodtruckmanagement.controller;

public class InvalidInputException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 6032898515504458143L;

	public InvalidInputException(String error)
	{
		super(error);
	}
}
