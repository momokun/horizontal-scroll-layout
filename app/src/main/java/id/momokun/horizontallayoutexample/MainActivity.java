package id.momokun.horizontallayoutexample;

//dev.momokun.id

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private TextView mainCheckpointWindowTitle, mainCheckpointWindowSubTitle, mainCheckpointWindowTitleInformation;
    private ArrayList<String> subtitleList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView horizontal_recycler_view = (RecyclerView) findViewById(R.id.horizontal_recycler_view);
        ArrayList<String> titleList = new ArrayList<>();
        ArrayList<String> infoList = new ArrayList<>();

        subtitleList=new ArrayList<>();

        for(int x = 0; x <10; x++) {
            titleList.add("Title "+x);
            subtitleList.add("Subtitle "+x);
            infoList.add("Info "+x);

        }

        HorizontalAdapter horizontalAdapter = new HorizontalAdapter(titleList, infoList);
        LinearLayoutManager horizontalLayoutManagaer = new LinearLayoutManager(MainActivity.this, LinearLayoutManager.HORIZONTAL, false);
        horizontal_recycler_view.setLayoutManager(horizontalLayoutManagaer);
        horizontal_recycler_view.setAdapter(horizontalAdapter);

        mainCheckpointWindowTitle = (TextView) findViewById(R.id.checkpoint_title);
        mainCheckpointWindowSubTitle = (TextView) findViewById(R.id.checkpoint_subtitle);
        mainCheckpointWindowTitleInformation = (TextView) findViewById(R.id.checkpoint_information);
    }




    public class HorizontalAdapter extends RecyclerView.Adapter<HorizontalAdapter.MyViewHolder> {

        private List<String> titleList;
        private List<String> infoList;

        class MyViewHolder extends RecyclerView.ViewHolder {
            TextView horizontal_activity_title_text;
            TextView horizontal_activity_subtitle_text;
            LinearLayout ll;


            MyViewHolder(View view) {
                super(view);
                horizontal_activity_title_text = (TextView) view.findViewById(R.id.horizontal_activity_title_text);
                horizontal_activity_subtitle_text = (TextView) view.findViewById(R.id.horizontal_activity_subtitle_text);
                ll = (LinearLayout) view.findViewById(R.id.ll);
            }
        }



        HorizontalAdapter(List<String> titleList, List<String> infoList) {
            this.titleList = titleList;
            this.infoList = infoList;

        }

        @Override
        public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.horizontal_layout_view, parent, false);
            return new MyViewHolder(itemView);
        }

        @Override
        public void onBindViewHolder(final MyViewHolder holder, final int position) {

            if(position==0){
                mainCheckpointWindowTitle.setText(titleList.get(position));
                mainCheckpointWindowSubTitle.setText(subtitleList.get(position));
                mainCheckpointWindowTitleInformation.setText(infoList.get(position));
            }

            holder.horizontal_activity_title_text.setText(titleList.get(position));
            holder.horizontal_activity_subtitle_text.setText(subtitleList.get(position));

            holder.ll.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mainCheckpointWindowTitle.setText(titleList.get(position));
                    mainCheckpointWindowSubTitle.setText(subtitleList.get(position));
                    mainCheckpointWindowTitleInformation.setText(infoList.get(position));
                }
            });
        }


        @Override
        public int getItemCount() {
            return titleList.size();
        }



    }

}
