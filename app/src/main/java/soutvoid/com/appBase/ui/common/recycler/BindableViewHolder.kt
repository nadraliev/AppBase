package soutvoid.com.appBase.ui.common.recycler

import android.view.View


abstract class BindableViewHolder<in T>(itemView: View) : BaseViewHolder(itemView) {

    abstract fun bind(data: T)
}
