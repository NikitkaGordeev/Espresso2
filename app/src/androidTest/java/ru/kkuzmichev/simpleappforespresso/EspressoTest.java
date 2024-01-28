package ru.kkuzmichev.simpleappforespresso;

import androidx.test.espresso.ViewInteraction;
import androidx.test.espresso.intent.rule.IntentsTestRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.intent.Intents.intended;
import static androidx.test.espresso.intent.matcher.IntentMatchers.hasAction;
import static androidx.test.espresso.intent.matcher.IntentMatchers.hasData;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withParent;
import android.content.Intent;
import org.hamcrest.Matchers;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(AndroidJUnit4.class)
public class EspressoTest {

    @Rule
    public IntentsTestRule intentsTestRule =
            new IntentsTestRule(MainActivity.class);

    @Test
    public void OpenRightMenu() {
        ViewInteraction imageView = onView(
                Matchers.allOf(
                        withParent(withParent(withId(R.id.toolbar)))));
        imageView.check(matches(isDisplayed()));
        imageView.perform(click());
        ViewInteraction textView = onView(
                Matchers.allOf(withId(androidx.appcompat.R.id.title),
                        withParent(withParent(withId(androidx.appcompat.R.id.content))),
                        isDisplayed()));
        textView.check(matches(isDisplayed()));
        textView.perform(click());
        intended(hasData("https://google.com"));
        intended(hasAction(Intent.ACTION_VIEW));


    }
}