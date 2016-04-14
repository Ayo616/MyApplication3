package yan.myapplication.Fragment;


import android.annotation.TargetApi;
import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.transition.ChangeImageTransform;
import android.transition.Slide;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ImageView;
import android.widget.Toast;

import yan.myapplication.Activity.MainActivity;
import yan.myapplication.Activity.UserInfo;
import yan.myapplication.Adapter.Myadapter;
import yan.myapplication.Animation.animation;
import yan.myapplication.Interface.OnItemClickLitener;
import yan.myapplication.R;
import yan.myapplication.Util.DividerItemDecoration;


/**
 * A simple {@link Fragment} subclass.
 */
public class navigation_Fragment extends Fragment {


    private ActionBarDrawerToggle mactionBarDrawerToggle;
    private DrawerLayout mdrawerLayout;
    private Toolbar mtoobar;

    public navigation_Fragment() {
        // Required empty public constructor


    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_navigation_draw, container, false);
        //Recycleview
        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.Recycleview);
        //set Recycleview Manager
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        //set Recycleview Adapter
        Myadapter myadapter = new Myadapter(getActivity());
        recyclerView.setAdapter(myadapter);
        //set Rececleview listener
        myadapter.setOnItemClickLitener(new OnItemClickLitener() {
            @TargetApi(Build.VERSION_CODES.LOLLIPOP)
            @Override
            public void onItemClick(View view, int position) {
                Toast.makeText(getActivity(), "click" + position, Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(getActivity(), UserInfo.class);
            // the shareView that you need to share in the next Activity
                ImageView shareView = (ImageView) view.findViewById(R.id.circleview);
                //give the shareview a special name
                view.setTransitionName("shareElement");
            // start Actvity with three param
                animation.startActivityWithAnimation(getActivity(), view, intent);

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
