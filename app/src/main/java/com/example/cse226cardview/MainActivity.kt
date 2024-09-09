package com.example.cse226cardview

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {
    lateinit var rv:RecyclerView
    lateinit var al:ArrayList<RecyclerModelDemo3>
    lateinit var ad:RecyclerAdapterDemo3
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
            rv=findViewById(R.id.rv)
            rv.setHasFixedSize(true)
            addData()
            val gm= LinearLayoutManager(this)
            gm.orientation= RecyclerView.VERTICAL
            rv.layoutManager=gm
            ad=RecyclerAdapterDemo3(this,al)
            rv.adapter=ad
        ItemTouchHelper(
            object :ItemTouchHelper.SimpleCallback(0,ItemTouchHelper.LEFT){
                override fun onMove(
                    recyclerView: RecyclerView,
                    viewHolder: RecyclerView.ViewHolder,
                    target: RecyclerView.ViewHolder
                ): Boolean {
                    return false
                }

                override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
                    val deleteCourse:RecyclerModelDemo3=
                        al.get(viewHolder.adapterPosition)
                    val position=viewHolder.adapterPosition
                    al.removeAt(viewHolder.adapterPosition)
                    ad!!.notifyItemRemoved(viewHolder.adapterPosition)
                    Snackbar.make(rv,"Deleted"+deleteCourse.t,Snackbar.LENGTH_LONG)
                        .setAction(
                            "Undo",
                            View.OnClickListener {
                                al.add(position,deleteCourse)
                                ad!!.notifyItemInserted(position)
                            }
                        ).show()
                }
            }
        ).attachToRecyclerView(rv)
        }
        fun addData()
        {
            al=ArrayList<RecyclerModelDemo3>()
            al.add(RecyclerModelDemo3("Facebook",R.drawable.facebook))
            al.add(RecyclerModelDemo3("Bluetooth",R.drawable.bluetooth))
            al.add(RecyclerModelDemo3("Signal",R.drawable.signal))
            al.add(RecyclerModelDemo3("Smartphone",R.drawable.phone))
            al.add(RecyclerModelDemo3("Database",R.drawable.database))
            al.add(RecyclerModelDemo3("WIfi",R.drawable.wifi))
    }
}