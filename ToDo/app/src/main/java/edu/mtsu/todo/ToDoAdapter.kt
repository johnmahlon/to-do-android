package edu.mtsu.todo

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.EditText
import androidx.constraintlayout.widget.ConstraintSet
import androidx.recyclerview.widget.RecyclerView

class ToDoAdapter: RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    var items = ArrayList<String>()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        // inflate the cell
        return ToDoViewHolder(
            LayoutInflater
                .from(parent.context)
                .inflate(R.layout.item_todo, parent, false)
        )
    }

    // this will be called for every item in our data
    // we'll be given the position of the table as well as a ViewHolder corresponding to that cell
    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        // set the data for the ViewHolder
        (holder as ToDoViewHolder).text.setText(items[position])
        holder.checkBox.isChecked = false
    }

    override fun getItemCount(): Int = items.size

    // The ViewHolder is basically a class that gives you access to the UI elements
    // that you need to 'bind' to the data.
    // it will literally 'hold' the view items.
    class ToDoViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        var checkBox: CheckBox = itemView.findViewById(R.id.checkBox)
        var text: EditText = itemView.findViewById(R.id.editText)
    }

}