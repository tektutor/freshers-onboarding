package org.tektutor;

public class MobileFactory {
	
	public static IMobile getMobile ( String mobileName ) {
		IMobile mobile = null;
		
		if ( mobileName.equals("IPhone4") )
			mobile = new IPhone4();
		else if ( mobileName.equals("IPhone5") )
			mobile = new IPhone5();
		if ( mobileName.equals("OnePlus5") )
			mobile = new OnePlus5();
		else
			mobile = new NullMobile();
		
		return mobile;
	}

}