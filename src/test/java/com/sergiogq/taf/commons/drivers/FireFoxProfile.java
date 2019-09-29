package com.sergiogq.taf.commons.drivers;

import java.io.File;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.internal.ProfilesIni;

import com.sergiogq.taf.commons.Constants;

/**
 * The Firefox profile to use
 */
@SuppressWarnings("deprecation")
public class FireFoxProfile {

	private ProfilesIni allProfiles = new ProfilesIni();
	private FirefoxProfile profile;
	private String profileName = "seleniumTesting";
	private File firebug;
	private File firePath;
	private String fireBugVersion;	

	public FireFoxProfile(){
		File mainResourcesDirectory = new File(Constants.RESOURCES);

		if( ! mainResourcesDirectory.exists()){
			mainResourcesDirectory.mkdirs();
		}

		File[] resources = new File(Constants.RESOURCES).listFiles();

		if(hasFirefoxItsOwnProfileForTesting()){
			profile = allProfiles.getProfile(profileName);
		}else if(existExtensions(resources)){
			createProfile();
		}else{
			profile = null;
		}
	}

	private void createProfile() {		
		profile = new FirefoxProfile();
		try {
			profile.addExtension(firebug);
			profile.addExtension(firePath);
			fireBugVersion = firebug.getName().split("-")[1];
			profile.setPreference("extensions.firebug.currentVersion", fireBugVersion);		
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private boolean existExtensions(File[] resourcesFiles){
		for (File file : resourcesFiles) {
			if(file.getName().toLowerCase().contains("firebug")){
				firebug = file;
			}else if(file.getName().toLowerCase().contains("firepath")){
				firePath = file;
			}
		}		

		if(firebug != null && firePath != null){
			return true;
		}else{
			return false;	
		}		
	}

	private boolean hasFirefoxItsOwnProfileForTesting(){		
		if(allProfiles.getProfile(profileName) != null){			
			return true;
		}else {
			return false;
		}		
	}

	public FirefoxProfile getProfile() {
		return profile;
	}
}
