package com.prj1.stand.artworldviewer.utilities;

/**
 * Handles the setting and getting of current page to move to next page
 *
 * Created by Stand on 6/15/2017.
 */

public class LastSelectedPage {
	private static LastSelectedPage ourInstance;
	private static ArtPage ourArtPage;
	
	private LastSelectedPage() {
	}
	
	public static LastSelectedPage getInstance(){
		if(ourInstance == null){
			ourInstance = new LastSelectedPage();
		}
		
		return ourInstance;
	}
	
	public ArtPage getArtPage(){
		return ourArtPage;
	}
	
	public void setArtPage(ArtPage currentArtPage){
		ourArtPage = currentArtPage;
	}
}
