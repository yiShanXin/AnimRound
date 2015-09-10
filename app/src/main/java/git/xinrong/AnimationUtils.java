package git.xinrong;

import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.ScaleAnimation;

/**
 * Created by ShanXin on 2015/9/9.
 * 由于项目用到 用户Logo动态展示 也就是放大缩小
 */
public class AnimationUtils {
    private static AnimationUtils animationUtils;

    private AnimationUtils() {

    }

    private static int index = 3;

    public static AnimationUtils getInitia() {
        if (animationUtils == null) {
            animationUtils = new AnimationUtils();
        }
        return animationUtils;
    }

    public void startView(final View view) {
        // 显示layout进行缩放动画效果
        if (view == null) {
            return;
        }
        ScaleAnimation myAnimation_Scale;
        // 放大的类,不需要设置监听器
        myAnimation_Scale = new ScaleAnimation(1.0f, 0.8f, 1f, 0.8f,
                Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF,
                0.5f);
        myAnimation_Scale.setInterpolator(new AccelerateInterpolator());
        myAnimation_Scale.setAnimationListener(new Animation.AnimationListener() {

            @Override
            public void onAnimationStart(Animation arg0) {

            }

            @Override
            public void onAnimationRepeat(Animation arg0) {

            }

            @Override
            public void onAnimationEnd(Animation arg0) {
                if (index > 1) {
                    start_privotView(view);
                } else {

                }
            }
        });
        AnimationSet aa = new AnimationSet(true);
        aa.addAnimation(myAnimation_Scale);
        aa.setDuration(1500);
        view.startAnimation(aa);
    }

    void start_privotView(final View view) {
        // 显示layout进行缩放动画效果
        ScaleAnimation myAnimation_Scale;
        // 放大的类,不需要设置监听器
        myAnimation_Scale = new ScaleAnimation(0.8f, 1.0f, 0.8f, 1f,
                Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF,
                0.5f);
        myAnimation_Scale.setInterpolator(new AccelerateInterpolator());
        myAnimation_Scale.setAnimationListener(new Animation.AnimationListener() {

            @Override
            public void onAnimationStart(Animation arg0) {

            }

            @Override
            public void onAnimationRepeat(Animation arg0) {

            }

            @Override
            public void onAnimationEnd(Animation arg0) {
                if (index > 1) {
                    startView(view);
                } else {

                }
            }
        });
        AnimationSet aa = new AnimationSet(true);
        aa.addAnimation(myAnimation_Scale);
        aa.setDuration(1500);


        view.startAnimation(aa);
    }

}
