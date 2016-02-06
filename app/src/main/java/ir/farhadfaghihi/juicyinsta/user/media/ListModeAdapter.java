package ir.farhadfaghihi.juicyinsta.user.media;

import android.content.Context;
import android.support.v7.widget.AppCompatTextView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.Date;

import butterknife.Bind;
import butterknife.ButterKnife;
import ir.farhadfaghihi.juicyinsta.R;
import ir.farhadfaghihi.juicyinsta.utils.image.ImageUtils;


public class ListModeAdapter extends RecyclerView.Adapter<ListModeAdapter.ViewHolder>
{

    Context context;
    ArrayList<Media> listItems;

    public ListModeAdapter(Context context, ArrayList<Media> listItems)
    {
        this.context = context;
        this.listItems = listItems;
    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int position)
    {
        View itemView = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_media_list, viewGroup, false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, int position)
    {
        String url = listItems.get(position).getImages().getStandard_resolution().getUrl();
        int likes = listItems.get(position).getLikes().getCount() ;
        int comments = listItems.get(position).getComments().getCount() ;

        Date dateCreated = new Date(Long.parseLong(listItems.get(position).getCreated_time()));

        ImageUtils.loadOriginal(context, url, viewHolder.imageView);

        viewHolder.tvLikes.setText(likes + "\r\n" + "Likes");
        viewHolder.tvComments.setText(comments + "\r\n" + "Comments");
        viewHolder.tvDate.setText(dateCreated.toString());

        Caption caption = listItems.get(position).getCaption();
        if(caption != null)
        {
            viewHolder.tvCaption.setText(caption.getText());
        }

    }

    @Override
    public int getItemCount()
    {
        return listItems.size();
    }


    static class ViewHolder extends RecyclerView.ViewHolder
    {
        @Bind(R.id.list_imageview)  ImageView imageView;
        @Bind(R.id.list_tvLikes)    AppCompatTextView tvLikes;
        @Bind(R.id.list_tvComments) AppCompatTextView tvComments;
        @Bind(R.id.list_tvDate)     AppCompatTextView tvDate;
        @Bind(R.id.list_tvCaption)  AppCompatTextView tvCaption;

        ViewHolder(View view)
        {
            super(view);
            ButterKnife.bind(this, view);
        }
    }
}
