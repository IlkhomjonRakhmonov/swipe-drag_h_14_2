package uz.rakhmonov.i.homework_14_2

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import uz.rakhmonov.i.homework_14_2.databinding.ItemRvBinding
import java.util.Collections

class SingerAdapter(val list: ArrayList<Singer>):RecyclerView.Adapter<SingerAdapter.VH>(),TouchHelper {
    inner class VH(val itemRvBinding: ItemRvBinding):RecyclerView.ViewHolder(itemRvBinding.root){
        fun onBind(singer: Singer, position: Int){
            itemRvBinding.singer.text=singer.name
            itemRvBinding.song.text=singer.song
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VH {
        return VH(ItemRvBinding.inflate(LayoutInflater.from(parent.context),parent,false))

    }

    override fun onBindViewHolder(holder: VH, position: Int) {
        holder.onBind(list[position], position)

    }

    override fun getItemCount(): Int {
      return  list.size
    }

    override fun onItemMove(fromPosition: Int, toPosition: Int) {
        if (fromPosition>toPosition){
            for (i in fromPosition until toPosition){
                Collections.swap(list,i,i+1)
            }

        }else{
            for (i in fromPosition until toPosition+1){
                Collections.swap(list,i,i-1)
            }
        }
        notifyItemMoved(fromPosition,toPosition)
    }

    override fun onItemDissmiss(position: Int) {
        list.removeAt(position)
        notifyItemRemoved(position)
    }

}