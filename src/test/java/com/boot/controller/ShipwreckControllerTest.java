package com.boot.controller;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.boot.ApplicationTestConfig;
import com.boot.controller.ShipwreckController;
import com.boot.model.Shipwreck;

public class ShipwreckControllerTest extends ApplicationTestConfig {

	@Autowired
	private ShipwreckController shipwreckController;
	
	private long swCreatedId;

	@Test
	public void AtestGetList() {

		List<Shipwreck> shipwrecks = shipwreckController.list();

		Assert.assertNotNull(shipwrecks);

	}

	@Test
	public void BcreateAndGetList() {

		Shipwreck sw = new Shipwreck(null, "Test Name", "Test Description",
				"Test cond", 12, 12.00, 10.00, 2);

		Shipwreck newShipwreck = shipwreckController.create(sw);

		Assert.assertNotNull(newShipwreck);

		List<Shipwreck> shipwrecks = shipwreckController.list();

		Assert.assertTrue(!shipwrecks.isEmpty());
		
		swCreatedId = newShipwreck.getId();
		
		String nameToUpdate = "TEST_USER";
		
		Shipwreck swGet = shipwreckController.get(swCreatedId);

		Assert.assertNotNull(swGet);

		swGet.setName(nameToUpdate);
		//shipwreckController.delete(4);
		shipwreckController.update(swCreatedId, swGet);

		Shipwreck swTest = shipwreckController.get(swCreatedId);

		Assert.assertTrue(nameToUpdate.equalsIgnoreCase(swTest.getName()));
	}

}
