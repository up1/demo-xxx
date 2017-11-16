package cc.somkiat.recipes.ui.recipedetail;

import android.content.Intent;
import android.support.test.rule.ActivityTestRule;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import cc.somkiat.recipes.R;
import cc.somkiat.recipes.data.local.CachedRecipe;
import cc.somkiat.recipes.data.model.Recipe;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.junit.Assert.*;


public class RecipeDetailActivityTest {

    @Rule
    public ActivityTestRule<RecipeDetailActivity> activityTestRule =
            new ActivityTestRule<>(RecipeDetailActivity.class, false, false);

    @Before
    public void resetDataInCachedRecipe() {
        CachedRecipe.setAllRecipes(new ArrayList<Recipe>());
    }

    @Test public void
    detail_of_recipe_not_found() {
        Intent intent = new Intent();
        intent.putExtra("id", 0);
        activityTestRule.launchActivity(intent);

        onView(withId(R.id.description))
        .check(matches(withText("Not found")));
    }

    @Test public void
    detail_of_recipe_should_found() {
        List<Recipe> mockData = new ArrayList<>();
        mockData.add(new Recipe("TEST", "TEST2"));
        CachedRecipe.setAllRecipes(mockData);

        Intent intent = new Intent();
        intent.putExtra("id", 0);
        activityTestRule.launchActivity(intent);

        onView(withId(R.id.title))
                .check(matches(withText("TEST")));
        onView(withId(R.id.description))
                .check(matches(withText("TEST2")));
    }

}