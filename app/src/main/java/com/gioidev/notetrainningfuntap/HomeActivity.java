package com.gioidev.notetrainningfuntap;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.gioidev.notetrainningfuntap.Adapter.TestStackAdapter;
import com.gioidev.notetrainningfuntap.CardStack.CardStackView;

import java.util.Arrays;

public class HomeActivity extends AppCompatActivity implements CardStackView.ItemExpendListener{
    public Integer[] TEST_DATAS = new Integer[]{
            R.color.blue,
            R.color.blue1,
            R.color.blue2,
            R.color.brown,
            R.color.yellow,
            R.color.red
    };

    CardStackView mStackView;
    TestStackAdapter mTestStackAdapter;
    private LinearLayout mActionButtonContainer;

    TextView textCartItemCount;
    int mCartItemCount = 10;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        button();

    }
    private void setupBadge() {

        if (textCartItemCount != null) {
            if (mCartItemCount == 0) {
                if (textCartItemCount.getVisibility() != View.GONE) {
                    textCartItemCount.setVisibility(View.GONE);
                }
            } else {
                textCartItemCount.setText(String.valueOf(Math.min(mCartItemCount, 99)));
                if (textCartItemCount.getVisibility() != View.VISIBLE) {
                    textCartItemCount.setVisibility(View.VISIBLE);
                }
            }
        }
    }

    public void button(){
        mStackView = (CardStackView) findViewById(R.id.cardStackView);
        mTestStackAdapter = new TestStackAdapter(this);
        mStackView.setItemExpendListener(this);
        mStackView.setAdapter(mTestStackAdapter);

        new Handler().postDelayed(
                new Runnable() {
                    @Override
                    public void run() {
                        mTestStackAdapter.updateData(Arrays.asList(TEST_DATAS));
                    }
                }
                , 200
        );
    }


    @Override
    public void onItemExpend(boolean expend) {

    }
}
