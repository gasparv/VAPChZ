package sk.gasparv.cviko5_recyclerview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    //TODO 5: vytvorit si premenne pre RecyclerView, pre adapter a pre layout manager
    private RecyclerView recyclerView;
    private RecyclerView.Adapter<ZoznamAdapter.ViewHolder> adapter;
    private RecyclerView.LayoutManager layoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView  = (RecyclerView) findViewById(R.id.rv_zoznam);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);

        //TODO 11: Vytiahnut data a naplnit adapter
        List<KoncertModel> zoznamKoncertov = Tools.stiahniKoncerty();
        adapter = new ZoznamAdapter(zoznamKoncertov,this);
        //TODO 17 priradit adapter pre recyclerview
        recyclerView.setAdapter(adapter);


        //adapter.refreshData(Tools.stiahniKoncerty());

    }
}
