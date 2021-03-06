package yan.myapplication.Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import yan.myapplication.Interface.OnItemClickLitener;
import yan.myapplication.R;

/**
 * Created by y on 2016/3/29.
 */
public class CardAdapter extends RecyclerView.Adapter<CardholderView> {

    private Context context;
    private List<String> list;

    public void init() {
        list = new ArrayList<>();
        list.add("Abosho");
        list.add("Bjjipr");
        list.add("vvou-re");
        list.add("dooodr");
        list.add("edsav");
        list.add("dpppser");
        list.add("sovloe");
        list.add("xximen");
        list.add("kancy");

    }

    public CardAdapter() {
        super();
        init();

    }

    public CardAdapter(Context context) {
        super();
        init();
        this.context = context;
    }

    private OnItemClickLitener mOnItemClickLitener;

    public void setOnItemClickLitener(OnItemClickLitener mOnItemClickLitener) {
        this.mOnItemClickLitener = mOnItemClickLitener;
    }




    @Override
    public CardholderView onCreateViewHolder(ViewGroup parent, int viewType) {


        CardholderView cardholderView = new CardholderView(
                LayoutInflater.from(context).inflate(R.layout.item_cardview, parent, false));
        return cardholderView;
    }

    @Override
    public void onBindViewHolder(final CardholderView holder, int position) {
        holder.textView.setText(list.get(position));

        // 如果设置了回调，则设置点击事件
        if (mOnItemClickLitener != null) {
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int pos = holder.getLayoutPosition();
                    mOnItemClickLitener.onItemClick(holder.itemView, pos);
                }
            });

            holder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View v) {
                    int pos = holder.getLayoutPosition();
                    mOnItemClickLitener.onItemLongClick(holder.itemView, pos);
                    return true;
                }
            });
        }
    }


    @Override
    public int getItemCount() {
        return list.size();
    }
}

 class CardholderView extends RecyclerView.ViewHolder {

     TextView textView;

     public CardholderView(View itemView) {
         super(itemView);

         textView = (TextView) itemView.findViewById(R.id.author_cardview);
     }
 }

