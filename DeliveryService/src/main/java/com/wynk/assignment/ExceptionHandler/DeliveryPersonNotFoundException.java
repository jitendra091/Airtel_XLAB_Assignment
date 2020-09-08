package com.wynk.assignment.ExceptionHandler;

public class DeliveryPersonNotFoundException extends RuntimeException {
   
	private static final long serialVersionUID = 1L;

	public DeliveryPersonNotFoundException() {
        super();
    }

    public DeliveryPersonNotFoundException(String message) {
        super(message);
    }
}
