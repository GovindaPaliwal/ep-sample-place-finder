package com.gp.controller;

import com.gp.epsample.R;
import com.gp.epsample.R.style;

import android.app.Activity;
import android.content.Intent;

public class Utils {

	private static int sTheme;



	public final static int THEME_MATERIAL_LIGHT = 0;

	public final static int THEME_YOUR_CUSTOM_THEME = 1;

	
	public final static boolean isValidEmail(CharSequence target) {
	    if (target == null) {
	        return false;
	    } else {
	        return android.util.Patterns.EMAIL_ADDRESS.matcher(target).matches();
	    }
	}

	public static void changeToTheme(Activity activity, int theme) {

		sTheme = theme;

		activity.finish();

		activity.startActivity(new Intent(activity, activity.getClass()));

		activity.overridePendingTransition(android.R.anim.fade_in,

				android.R.anim.fade_out);

	}



	public static void onActivityCreateSetTheme(Activity activity) {

		switch (sTheme) {

		default:

		case THEME_MATERIAL_LIGHT:

			activity.setTheme(R.style.Theme_Material_Ligth);

			break;

		case THEME_YOUR_CUSTOM_THEME:

			activity.setTheme(R.style.Theme_Material_Dark);

			break;

		}

	}

}