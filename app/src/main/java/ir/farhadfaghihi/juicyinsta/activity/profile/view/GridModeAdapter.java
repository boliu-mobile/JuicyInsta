package ir.farhadfaghihi.juicyinsta.activity.profile.view;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;
import ir.farhadfaghihi.juicyinsta.R;
import ir.farhadfaghihi.juicyinsta.network.media.model.Media;
import ir.farhadfaghihi.juicyinsta.utils.image.ImageUtils;


public class GridModeAdapter extends RecyclerView.Adapter<GridModeAdapter.ViewHolder>
{

    Context context;
    ArrayList<Media> listItems;

    public GridModeAdapter(Context context, ArrayList<Media> listItems) {
        this.context = context;
        this.listItems = listItems;
    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int position)
    {
        View itemView = LayoutInflater.from(viewGroup.getContext()). inflate(R.layout.item_media_grid, viewGroup, false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, int position)
    {
        String url = listItems.get(position).getImages().getThumbnail().getUrl();

        ImageUtils.loadOriginal(context,url,viewHolder.imageView);
    }

    @Override
    public int getItemCount() {
        return listItems.size();
    }

    public final static class ViewHolder extends RecyclerView.ViewHolder {

        @Bind(R.id.grid_imageview) ImageView imageView ;
        public ViewHolder(View view) {
            super(view);
            ButterKnife.bind(this,view);
        }
    }

}
