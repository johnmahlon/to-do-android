package edu.mtsu.todo

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton

class ToDoFragment: Fragment() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: ToDoAdapter
    private lateinit var fab: FloatingActionButton


    // Initialize everything here
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_todo, container, false)
        recyclerView = view.findViewById(R.id.todo_recycler)
        fab = view.findViewById(R.id.fabAdd)

        // set layout manager
        // this is what controls how the rv is laid out. In our case, linearly.
        recyclerView.layoutManager = LinearLayoutManager(context)

        // set adapter
        adapter = ToDoAdapter()
        recyclerView.adapter = adapter

        fab.setOnClickListener {
            adapter.items.add("")
            adapter.notifyDataSetChanged()
        }

        return view
    }

}