package cc.somkiat.recipes.ui.main;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.test.InstrumentationRegistry;
import android.support.test.espresso.contrib.RecyclerViewActions;
import android.support.test.rule.ActivityTestRule;

import org.junit.Rule;
import org.junit.Test;

import cc.somkiat.recipes.R;
import cc.somkiat.recipes.pageobject.MainPage;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.isSelected;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.junit.Assert.*;

public class MainActivityTest {

    @Rule
    public ActivityTestRule<MainActivity> activityTestRule
            = new ActivityTestRule<>(MainActivity.class);

    @Test public void
    select_first_item() {

        waiting();

        MainPage.clickByPosition(0);

        onView(withId(R.id.title))
                .check(matches(withText("Fried Rice")));
        onView(withId(R.id.title))
                .check(matches(isDisplayed()));
    }

    @Test public void
    select_first_item_and_add_to_favorite() {

        waiting();

        Context context = InstrumentationRegistry.getTargetContext();
        SharedPreferences sharedPreferences =
                context.getSharedPreferences("favorites.xml", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.clear();
        editor.commit();

        MainPage.clickByPosition(0);

        onView(withId(R.id.title)).perform(click());
        onView(withId(R.id.title)).check(matches(isSelected()));
    }

    private void waiting() {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}