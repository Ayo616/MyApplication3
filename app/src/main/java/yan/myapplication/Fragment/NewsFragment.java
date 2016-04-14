package yan.myapplication.Fragment;


import android.annotation.TargetApi;
import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.CardView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import yan.myapplication.Activity.ScrollingActivity;
import yan.myapplication.Adapter.CardAdapter;
import yan.myapplication.Adapter.Myadapter;
import yan.myapplication.Interface.OnItemClickLitener;
import yan.myapplication.R;
import yan.myapplication.Util.DividerItemDecoration;

/**
 * A simple {@link Fragment} subclass.
 */
public class NewsFragment extends Fragment {

    private RecyclerView recyclerView;


    public NewsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_news, container, false);
        recyclerView = (RecyclerView)view.findViewById(R.id.cardview_recyview);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        //set cardAdapter Adapter
        CardAdapter cardAdapter = new CardAdapter(getActivity());
        recyclerView.setAdapter(cardAdapter);
        //set cardAdapter listener
        cardAdapter.setOnItemClickLitener(new OnItemClickLitener() {
            @TargetApi(Build.VERSION_CODES.LOLLIPOP)
            @Override
            public void onItemClick(View view, int position) {
                Toast.makeText(getActivity(), "click" + position, Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(getActivity(), ScrollingActivity.class);

                getActivity().startActivity(intent,
                        ActivityOptions.makeSceneTransitionAnimation(getActivity()).toBundle());

            }

            @Override
            public void onItemLongClick(View view, int position) {
                Toast.makeText(getActivity(), "long click" + position, Toast.LENGTH_SHORT).show();
            }
        });
        //set Recycleview ItemDecoration
        recyclerView.addItemDecoration(new DividerItemDecoration(getActivity(), DividerItemDecoration.VERTICAL_LIST));
        return view;

    }



}
