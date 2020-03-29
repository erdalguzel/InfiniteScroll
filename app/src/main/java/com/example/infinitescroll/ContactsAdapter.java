package com.example.infinitescroll;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ContactsAdapter extends RecyclerView.Adapter<ContactsAdapter.ViewHolder> {

    private List<Contacts> mContactsList;

    public ContactsAdapter(List<Contacts> contacts) {
        mContactsList = contacts;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        View contactView = inflater.inflate(R.layout.item_contact, parent, false);
        ViewHolder viewHolder = new ViewHolder(contactView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Contacts contact = mContactsList.get(position);

        TextView textView = holder.nameTextView;
        Button button = holder.contactsButton;
        textView.setText(contact.getName());
        button.setText(contact.getOnlineStatus() ? "Online" : "Offline");
        button.setEnabled(contact.getOnlineStatus());
    }

    @Override
    public int getItemCount() {
        return mContactsList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        public TextView nameTextView;
        public Button contactsButton;

        public ViewHolder(View itemView) {
            super(itemView);
            nameTextView = itemView.findViewById(R.id.contact_name);
            contactsButton = itemView.findViewById(R.id.message_button);
        }
    }
}
