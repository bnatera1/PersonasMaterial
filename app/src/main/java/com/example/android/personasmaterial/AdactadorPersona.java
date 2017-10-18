package com.example.android.personasmaterial;

import android.content.Context;
import android.content.res.Resources;
import android.support.v4.content.res.ResourcesCompat;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by android on 17/10/2017.
 */



public class AdactadorPersona extends RecyclerView.Adapter<AdactadorPersona.PersonaViewHolder> {

    private ArrayList<Persona> personas;
    private Resources res;

    public AdactadorPersona(Context contexto, ArrayList<Persona>personas){
        this.personas = personas;
        this.res = contexto.getResources();
    }

    @Override
    public PersonaViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_personas,parent,false);
        return new PersonaViewHolder(v);
    }

    @Override
    public void onBindViewHolder(PersonaViewHolder holder, int position) {
        final Persona p = personas.get(position);
        holder.foto.setImageDrawable(ResourcesCompat.getDrawable(res,p.getFoto(),null));
        holder.cedula.setText(p.getCedula());
        holder.nombre.setText(p.getNombre());
        holder.apellido.setText(p.getApellido());
    }

    @Override
    public int getItemCount() {
        return personas.size();
    }

    public static class PersonaViewHolder extends RecyclerView.ViewHolder{
        private ImageView foto;
        private TextView cedula;
        private TextView nombre;
        private TextView apellido;

        public PersonaViewHolder(View item){
            super(item);
            foto = (ImageView)item.findViewById(R.id.imgFoto);
            cedula = (TextView) item.findViewById(R.id.lblCedula);
            nombre = (TextView) item.findViewById(R.id.lblNombre);
            apellido = (TextView) item.findViewById(R.id.lblApellido);
        }
    }

}
