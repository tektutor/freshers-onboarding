package org.tektutor;

import static org.junit.Assert.assertEquals;
import org.mockito.Mockito;

import org.junit.Test;

public class MobileTest {

	@Test
	public void testStartPhotoAppWhenCameraOnFunctionsNormally() {

		//Mocking - creating a dummy Camera object with no original code
		Camera mockedCamera = Mockito.mock ( Camera.class );
		
		//Stubbing - hard coding the response of dependent method
		Mockito.when( mockedCamera.on() ).thenReturn(true);
		
		//Dependency Injection
		Mobile mobile = new Mobile(mockedCamera);
		
		boolean actualResponse   = mobile.startPhotoApp();
		boolean expectedResponse = true;
		
		assertEquals ( expectedResponse, actualResponse );
		
		//Verify the camera.on() method invoking within the startPhotoApp() method
		Mockito.verify( mockedCamera, Mockito.times(1) ).on();
		
	}

}