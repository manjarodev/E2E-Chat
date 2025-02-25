package com.devbeans.io.chat.utils.qr

import android.content.Context
import android.util.AttributeSet
import android.widget.FrameLayout
import androidx.lifecycle.DefaultLifecycleObserver
import androidx.lifecycle.LifecycleOwner
import com.devbeans.io.chat.utils.logging.Log
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.subjects.PublishSubject


/**
 * View for starting up a camera and scanning a QR-Code. Safe to use on an API version and
 * will delegate to legacy camera APIs or CameraX APIs when appropriate.
 *
 * QR-code data is emitted via [qrData] observable.
 */
class QrScannerView @JvmOverloads constructor(
  context: Context,
  attrs: AttributeSet? = null,
  defStyleAttr: Int = 0
) : FrameLayout(context, attrs, defStyleAttr) {

  private var scannerView: ScannerView? = null
  private val qrDataPublish: PublishSubject<String> = PublishSubject.create()

  val qrData: Observable<String> = qrDataPublish

  private fun initScannerView(forceLegacy: Boolean) {
    val scannerView: FrameLayout = if (!forceLegacy) {
      ScannerView21(context) { qrDataPublish.onNext(it) }
    } else {
      ScannerView19(context) { qrDataPublish.onNext(it) }
    }

    scannerView.layoutParams = LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT)
    addView(scannerView)

    this.scannerView = (scannerView as ScannerView)
  }

  @JvmOverloads
  fun start(lifecycleOwner: LifecycleOwner, forceLegacy: Boolean = false) {
    if (scannerView != null) {
      Log.w(TAG, "Attempt to start scanning that has already started")
      return
    }

    initScannerView(forceLegacy)

    scannerView?.start(lifecycleOwner)
    lifecycleOwner.lifecycle.addObserver(object : DefaultLifecycleObserver {
      override fun onDestroy(owner: LifecycleOwner) {
        qrDataPublish.onComplete()
      }
    })
  }

  companion object {
    private val TAG = Log.tag(QrScannerView::class.java)
  }
}
