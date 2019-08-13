package org.tektutor;

public class Main {

	public static void main(String[] args) {

		PaperWala paperWala = new PaperWala("Pune PaperWala Pvt Ltd.,");
		
		paperWala.addSubscriber( new Subscriber("Ramesh") );
		paperWala.addSubscriber( new Subscriber("Rishi") );
		paperWala.addSubscriber( new Subscriber("Abhey") );

		paperWala.notifyAllSubscribers("Times Of India");
				
	}

}