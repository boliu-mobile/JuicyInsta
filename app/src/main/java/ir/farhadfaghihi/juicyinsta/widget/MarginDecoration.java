package ir.farhadfaghihi.juicyinsta.widget;


import android.content.Context;
import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import ir.farhadfaghihi.juicyinsta.R;

public class MarginDecoration extends RecyclerView.ItemDecoration
{
    private int margin;

    public MarginDecoration(Context context)
    {
        margin = context.getResources().getDimensionPixelSize(R.dimen.margin_small);
    }

    @Override
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state)
    {
        outRect.set(margin, margin, margin, margin);
    }
}
