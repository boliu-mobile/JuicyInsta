package ir.farhadfaghihi.juicyinsta.activity.profile.view;

import android.content.Context;
import android.support.v7.widget.AppCompatTextView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import butterknife.Bind;
import butterknife.ButterKnife;
import ir.farhadfaghihi.juicyinsta.R;
import ir.farhadfaghihi.juicyinsta.network.media.model.Media;
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

        String date = getFormattedDate(listItems.get(position).getCreated_time()) ;
        ImageUtils.loadOriginal(context, url, viewHolder.imageView);

        viewHolder.tvLikes.setText(likes + "");
        viewHolder.tvComments.setText(comments + "");
        viewHolder.tvDate.setText(date);

        if(listItems.get(position).getCaption() != null)
        {
            viewHolder.tvCaption.setText(listItems.get(position).getCaption().getText());
        }

        else
        {
            viewHolder.tvCaption.setText("");
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

    private String getFormattedDate(String createdTime)
    {
        Date date = new Date(Long.parseLong(createdTime)*1000);

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MMM-dd-yy") ;

        return simpleDateFormat.format(date) ;

    }
}
