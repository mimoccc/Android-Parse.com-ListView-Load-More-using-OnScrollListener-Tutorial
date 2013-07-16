package com.androidbegin.parseloadmore;

import com.parse.Parse;
import com.parse.ParseACL;
import com.parse.ParseUser;
import android.app.Application;

public class ParseApplication extends Application {

	@Override
	public void onCreate() {
		super.onCreate();

		// Add your initialization code here
		Parse.initialize(this, "WOK7gM7rKRt9Rp4yzT06bc9ZE6nTnKABGVJM2r1J",
				"TWQE6wkTPpToH7KDZlulMrXjNXK0LZ0XgvyUloqS");

		ParseUser.enableAutomaticUser();
		ParseACL defaultACL = new ParseACL();

		// If you would like all objects to be private by default, remove this
		// line.
		defaultACL.setPublicReadAccess(true);

		ParseACL.setDefaultACL(defaultACL, true);
	}

}
