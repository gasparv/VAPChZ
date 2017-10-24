package sk.gasparv.cviko5_recyclerview;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

/**
 * Created by gaspa on 24.10.2017.
 */

//TODO 6: vytvorit adapter, ktory rozsituje typ RecyclerView.Adapter<>
public class ZoznamAdapter extends RecyclerView.Adapter<ZoznamAdapter.ViewHolder> {

    //TODO: 13 Vytvorit si globalnu premennu, ktoru naplnime datami v konstruktore
    public List<KoncertModel> data;
    public Context context;
    //todo> 12 vyTVORIT SI PARAMETRICKY KONSTRUKTOR  V KTOROM SU DATA (lIST) a zaroven konctext v ktorom vytvaram adapter (aktivita)
    public ZoznamAdapter(List<KoncertModel> data, Context context){
        this.data = data;
        this.context = context;
    }

    public void refreshData(List<KoncertModel> zoznam)
    {
        this.data = zoznam;
        notifyDataSetChanged();
    }


    //TODO 7: Vytvorit viewholder {staticka trieda) ktory rozsiruje RecyclerView.ViewHolder a vytvorit pre neho konstruktor
    public static class ViewHolder extends RecyclerView.ViewHolder{
    //TODO 8: Naplnit obsah pre vsetky objekty v bunke a vyhladat ich v konstruktore Viewholdera cez itemView, ktory je vlastne kazda bunka.
        public TextView tv1;
        public TextView tv2;
        public TextView tv3;
        public ViewHolder(View itemView) {
            super(itemView);
            tv1 = itemView.findViewById(R.id.textView);
            tv2 = itemView.findViewById(R.id.textView2);
            tv3 = itemView.findViewById(R.id.textView3);
        }
    }

    //TODO: 15 pomocou inflatera inflatnut konkretny layout do viewgourp a vratit viewholder;
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.bunka_zoznamu,parent,false);
        return new ViewHolder(view);
    }


    //TODO: 14 On bind view holder naplna data do holdera pomocou pozicie ...
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.tv1.setText(data.get(position).nazov);
        holder.tv2.setText(data.get(position).interpret);
        holder.tv3.setText(data.get(position).datum);
    }

    @Override
    public int getItemCount() {
        return data.size();
    }
}
