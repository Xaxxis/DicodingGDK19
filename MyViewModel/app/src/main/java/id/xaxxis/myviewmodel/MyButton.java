package id.xaxxis.myviewmodel;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.AppCompatButton;
import android.util.AttributeSet;

import static android.view.Gravity.CENTER;

public class MyButton extends AppCompatButton {
    private Drawable enableBackground, disableBackground;
    private int textColor;

    public MyButton(Context context) {
        super(context);
    }

    public MyButton(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    private void init() {
        textColor = ContextCompat.getColor(getContext(), android.R.color.background_light);
        enableBackground = getResources().getDrawable(R.drawable.bg_button);
        disableBackground = getResources().getDrawable(R.drawable.bg_button_disable);
    }

    public MyButton(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        setBackground(isEnabled() ? enableBackground : disableBackground);
        setTextColor(textColor);
        setTextSize(12.f);
        setGravity(CENTER);
        setText(isEnabled()? "Submit" : "Isi Dulu");
    }
}
