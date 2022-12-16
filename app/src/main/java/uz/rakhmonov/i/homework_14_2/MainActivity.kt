package uz.rakhmonov.i.homework_14_2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.RecyclerView
import uz.rakhmonov.i.homework_14_2.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    lateinit var list: ArrayList<Singer>
    lateinit var singerAdapter: SingerAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        binding= ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        loadData()

        singerAdapter= SingerAdapter(list)
        binding.rv.adapter=singerAdapter

        itemActions()
    }

    private fun itemActions() {
    val itemTouchHelper=object :ItemTouchHelper.Callback(){
        override fun getMovementFlags(
            recyclerView: RecyclerView,
            viewHolder: RecyclerView.ViewHolder
        ): Int {
            val swipeFlags=ItemTouchHelper.START or ItemTouchHelper.END
            val dragFlags= ItemTouchHelper.UP or ItemTouchHelper.DOWN
            return makeMovementFlags(dragFlags,swipeFlags)
        }

        override fun onMove(
            recyclerView: RecyclerView,
            viewHolder: RecyclerView.ViewHolder,
            target: RecyclerView.ViewHolder
        ): Boolean {
            singerAdapter.onItemMove(viewHolder.adapterPosition,target.adapterPosition)
            return true
        }

        override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
            singerAdapter.onItemDissmiss(viewHolder.adapterPosition)

        }
    }
        ItemTouchHelper(itemTouchHelper).attachToRecyclerView(binding.rv)
    }

    private fun loadData() {
        list= ArrayList()

        for (i in 0 until 10) {
            list.add(Singer("Sherali Jo'rayev", "Karvon"))
            list.add(Singer("Ozodbek Nazarbekov", "Tabarruk"))
            list.add(Singer("Xurshid Rasulov", "Yoshlik"))
            list.add(Singer("Otabek Muxammadzoxid", "Indamaslar olami"))
        }
    }
}