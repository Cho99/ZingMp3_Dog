package com.example.appmusicv2.Fragment;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

import com.example.appmusicv2.Model.Kind;
import com.example.appmusicv2.Model.KindAndTopic;
import com.example.appmusicv2.Model.Topic;
import com.example.appmusicv2.R;
import com.example.appmusicv2.Service.APIService;
import com.example.appmusicv2.Service.Dataservice;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Fragment_Kind_Topic_today extends Fragment {
    View view;
    HorizontalScrollView horizontalScrollView;
    TextView txtViewTopicAndKind;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_kind_topic_today, container, false);
        txtViewTopicAndKind = view.findViewById(R.id.textViewViewMore);
        horizontalScrollView = view.findViewById(R.id.horizontalScrollView);
        GetData();
        return view;
    }

    private void GetData() {
       Dataservice dataservice = APIService.getService();
       Call<KindAndTopic> callback = dataservice.GetCategoryMusic();
       callback.enqueue(new Callback<KindAndTopic>() {
           @Override
           public void onResponse(Call<KindAndTopic> call, Response<KindAndTopic> response) {
               KindAndTopic kindAndTopic = response.body();
               final ArrayList<Topic> array_Topic = new ArrayList<>();
               array_Topic.addAll(kindAndTopic.getTopic());

               final ArrayList<Kind> array_Kind = new ArrayList<>();
               array_Kind.addAll(kindAndTopic.getKind());

               LinearLayout linearLayout = new LinearLayout(getActivity());
               linearLayout.setOrientation(LinearLayout.HORIZONTAL);

               LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(580, 250);
               layoutParams.setMargins(10, 20, 10, 30);

               for (int i = 0; i < (array_Topic.size()); i++) {
                   CardView cardView = new CardView(getActivity());
                   cardView.setRadius(10);
                   ImageView imageView = new ImageView(getActivity());
                   imageView.setScaleType(ImageView.ScaleType.FIT_XY);
                   if (array_Topic.get(i).getImageTopic() != null) {
                       Picasso.get().load(array_Topic.get(i).getImageTopic()).into(imageView);
                   }
                   cardView.setLayoutParams(layoutParams);
                   cardView.addView(imageView);
                   linearLayout.addView(cardView);
               }
               for (int j = 0; j < (array_Kind.size()); j++) {
                   CardView cardView = new CardView(getActivity());
                   cardView.setRadius(10);
                   ImageView imageView = new ImageView(getActivity());
                   imageView.setScaleType(ImageView.ScaleType.FIT_XY);
                   if (array_Topic.get(j).getImageTopic() != null) {
                       Picasso.get().load(array_Kind.get(j).getImageKind()).into(imageView);
                   }
                   cardView.setLayoutParams(layoutParams);
                   cardView.addView(imageView);
                   linearLayout.addView(cardView);
               }
               horizontalScrollView.addView(linearLayout);
           }

           @Override
           public void onFailure(Call<KindAndTopic> call, Throwable t) {

           }
       });
    }
}
