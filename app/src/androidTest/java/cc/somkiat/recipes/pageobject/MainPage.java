package cc.somkiat.recipes.pageobject;


import android.support.test.espresso.contrib.RecyclerViewActions;

import cc.somkiat.recipes.R;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.matcher.ViewMatchers.withId;

public class MainPage {

    public static void clickByPosition(int position) {
        onView(withId(R.id.recipes)).perform(
                RecyclerViewActions.actionOnItemAtPosition(position, click()));

    }

}
