package com.cornelio.losyondris.covi19;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import de.hdodenhof.circleimageview.CircleImageView;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {
      ArrayList<Poo> poos;
    Dialog myDialogo;
    public MyAdapter(ArrayList<Poo> poos) {
        this.poos = poos;
    }

    @NonNull
    @Override
    public MyAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
       // View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item,null,false);
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item,null,false);
       // ViewHolder holder = new ViewHolder(view);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final MyAdapter.ViewHolder holder, int position) {
       final Poo pojo = poos.get(position);
       holder.pais.setText(pojo.getCountry());
       holder.curado.setText(pojo.getRecovered());
        holder.infectado.setText(pojo.getCases());
       // holder.infectadodiario.setText(pojo.getTodayCases());
       holder.muerto.setText(pojo.getDeaths());
      // holder.muertodiario.setText(pojo.getTodayDeaths());

        Glide.with(holder.context).load(pojo.getFlag())
                .apply( new RequestOptions().override(240,240))
                .placeholder(R.drawable.ic_launcher_background).into(holder.vanderaImg);

        holder.muerto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(holder.context,"Pais :"+pojo.getCountry(),Toast.LENGTH_LONG).show();

                AlertDialog.Builder builder = new AlertDialog.Builder(holder.context);
                builder.setTitle(pojo.getCountry());
                builder.setIcon(R.drawable.icono_app);
                builder.setMessage("\n"+"\n"
                                +"Curados :"+pojo.getRecovered()+"\n"
                                +"Casos :"+pojo.getCases()+"\n"
                                +"Casos por dia :"+pojo.getTodayCases()+"\n"
                                +"Muertos :"+pojo.getDeaths()+"\n"
                                +"Hoy Muertos :"+pojo.getTodayDeaths()+"\n"
                );
                builder.setPositiveButton("Cerrar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                       // Toast.makeText(holder.context,"Cerrando",Toast.LENGTH_LONG).show();

                    }
                });/*.setNegativeButton("Eliminar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        DatabaseReference mybd = FirebaseDatabase.getInstance().getReference().child("CarlosMelo");
                        mybd.child(pooView.getId()).removeValue();
                        Toast.makeText(view.getContext(),"Eliminar :" ,Toast.LENGTH_LONG).show();
                    }
                });
*/

                Dialog bbx= builder.create();
                bbx.show();

                }
        });
    }



    @Override
    public int getItemCount() {
        return poos.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
       // CircleImageView vanderaImg;
        ImageView vanderaImg;
        TextView pais,muerto,curado,infectado;
        Context context;
        LinearLayout dialogo;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            vanderaImg = itemView.findViewById(R.id.vandera);
            pais = itemView.findViewById(R.id.pais);
            curado = itemView.findViewById(R.id.id_curado);
            muerto = itemView.findViewById(R.id.id_muerto);
            infectado = itemView.findViewById(R.id.infectado);
            context = itemView.getContext();
            dialogo = itemView.findViewById(R.id.rvView);
          //  muertodiario = itemView.findViewById(R.id.muertoXdia);
           // infectadodiario = itemView.findViewById(R.id.infectadoXdia);



        }
    }


}
