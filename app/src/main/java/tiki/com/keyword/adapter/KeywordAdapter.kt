package tiki.com.keyword.adapter

import android.graphics.drawable.GradientDrawable
import tiki.com.keyword.model.KeywordModel
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.item_keyword.view.*
import tiki.com.keyword.R
import tiki.com.keyword.utils.Utils

class KeywordAdapter(private val listKeyword: List<KeywordModel>) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_keyword, parent, false)
        return KeywordItemViewHolder(view)
    }

    override fun getItemCount(): Int {
        return listKeyword.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (holder is KeywordItemViewHolder) {
            holder.bindKeywordItem(listKeyword[position])
        }
    }

    class KeywordItemViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        fun bindKeywordItem(keywordItem: KeywordModel) {
            itemView.text_keyword.text = Utils.getStringBreakLine(keywordItem.name)

            val drawable = itemView.text_keyword.background
            if (drawable is GradientDrawable) {
                drawable.setColor(Utils.getRandomColor())
            }
        }
    }
}
