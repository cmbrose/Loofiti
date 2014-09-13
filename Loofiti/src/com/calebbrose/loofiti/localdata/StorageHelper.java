package com.calebbrose.loofiti.localdata;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Facilitates shared preferences storage of AppStats and Achievement objects.
 */
public class StorageHelper {
	
	private SharedPreferences prefs;
	
	public StorageHelper(Context context) {
		prefs = context.getSharedPreferences("stats", Context.MODE_PRIVATE);
	}
	
	public void storeAppStats(AppStats stats) {
		SharedPreferences.Editor editor = prefs.edit();
		editor.putInt("sessionCount", stats.getSessionCount());
		editor.putInt("userExperience", stats.getUserExperience());
		editor.putInt("userLevel", stats.getUserLevel());
		editor.putString("lastLocation", stats.getLastLocation());
		editor.putString("lastDate", stats.getLastDateString());
		editor.putInt("totalTime", stats.getTotalTime());
		editor.commit();
	}
	
	public AppStats retrieveAppStats() {
		AppStats stats = new AppStats(
				prefs.getInt("sessionCount", 0),
				prefs.getInt("userExperience", 0),
				prefs.getInt("userLevel", 0),
				prefs.getString("lastLocation", ""),
				prefs.getString("lastDate", ""),
				prefs.getInt("totalTime", 0));
		return stats;
	}

}
