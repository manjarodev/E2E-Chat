package com.devbeans.io.chat.utils.views

import android.content.Context
import android.os.Build
import android.view.*
import android.widget.PopupWindow
import androidx.core.content.ContextCompat
import com.devbeans.io.chat.R


/**
 * The context menu shown after long pressing a message in ConversationActivity.
 */
class ConversationContextMenu(private val anchor: View, items: List<ActionItem>) : PopupWindow(
    LayoutInflater.from(anchor.context).inflate(R.layout.chat_context_menu, null),
    ViewGroup.LayoutParams.WRAP_CONTENT,
    ViewGroup.LayoutParams.WRAP_CONTENT,
) {

    val context: Context = anchor.context

    private val contextMenuList = ContextMenuList(
        recyclerView = contentView.findViewById(R.id.signal_context_menu_list),
        onItemClick = { dismiss() },
    )

    init {
        setBackgroundDrawable(ContextCompat.getDrawable(context, R.drawable.signal_context_menu_background))
        animationStyle = R.style.ConversationContextMenuAnimation

        isFocusable = false
        isOutsideTouchable = true

        if (Build.VERSION.SDK_INT >= 21) {
            elevation = 20f
        }

        setTouchInterceptor { _, event ->
            event.action == MotionEvent.ACTION_OUTSIDE
        }

        contextMenuList.setItems(items)

        contentView.measure(
            View.MeasureSpec.makeMeasureSpec(0, View.MeasureSpec.UNSPECIFIED),
            View.MeasureSpec.makeMeasureSpec(0, View.MeasureSpec.UNSPECIFIED)
        )
    }

    fun getMaxWidth(): Int = contentView.measuredWidth
    fun getMaxHeight(): Int = contentView.measuredHeight

    fun show(offsetX: Int, offsetY: Int) {
        showAsDropDown(anchor, offsetX, offsetY, Gravity.TOP or Gravity.START)
    }
}
