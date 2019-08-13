package org.tektutor;

import java.util.ArrayList;

public class PaperWala implements IObservable {
	private ArrayList<IObserver> subscribers;
	private String name;
	
	public PaperWala(String name) {
		this.name = name;
		subscribers = new ArrayList<IObserver>();
	}
	
	public void addSubscriber(IObserver observer) {
		subscribers.add(observer);
	}

	public void removeSubscriber(IObserver observer) {
		subscribers.remove(observer);
	}

	public void notifyAllSubscribers(String message) {
		for ( IObserver customer : subscribers ) 
			customer.update( message );
	}
}