package com.sergiogq.taf;

import java.io.IOException;
import java.util.concurrent.TimeUnit;
import com.sergiogq.taf.commons.drivers.Driver;
import com.sergiogq.taf.data.Data;

/**
 * The browser object to make browser action with the driver
 */
public class Browser {

	public Driver driver;

	public Browser(String browserType) throws SecurityException, IOException {
		driver = Driver.getInstance(browserType);
	}

	/**
	 * To open the site
	 */
	public void openSite() {
		driver.obtenerDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.obtenerDriver().manage().window().maximize();
		driver.obtenerDriver().get(Data.getSiteUrl());
	}

}
