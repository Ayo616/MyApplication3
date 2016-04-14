package yan.myapplication.Animation;

import android.animation.Animator;
import android.annotation.TargetApi;
import android.app.Activity;
import android.app.ActivityOptions;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.transition.ChangeImageTransform;
import android.transition.Fade;
import android.transition.Slide;
import android.transition.Transition;
import android.transition.TransitionInflater;
import android.view.View;
import android.view.ViewAnimationUtils;
import android.view.animation.AccelerateDecelerateInterpolator;

import yan.myapplication.R;

/**
 * Created by y on 2016/3/29.
 */
public class animation {

    /**
     * this method is used to stat a Activity or Fragment with share element
     * @param activity
     * @param shareView
     * @param intent
     */
    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public static void  startActivityWithAnimation(Activity activity,View shareView,Intent intent){
//        Transition mytransition = TransitionInflater.from(activity).inflateTransition(R.transition.share_element_transition);
        //      activity.getWindow().setExitTransition(new Slide());
        ActivityOptions options = ActivityOptions
                .makeSceneTransitionAnimation(activity, shareView, "shareElement");

        activity.startActivity(intent, options.toBundle());
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public static Animator creatAnimation(View oval){
        Animator animator = ViewAnimationUtils.createCircularReveal(
                oval,
                oval.getWidth() / 2,
                oval.getHeight() / 2,
                oval.getWidth(),
                0);
        animator.setInterpolator(new AccelerateDecelerateInterpolator());
        animator.setDuration(2000);
        return animator;
        //animator.start();
    }
}
