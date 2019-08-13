package org.tektutor;

public interface IObservable {
	
	public void addSubscriber( IObserver observer );
	public void removeSubscriber( IObserver observer );
	public void notifyAllSubscribers(String message);

}