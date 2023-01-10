package com.artlite.base64masklibrary.impl.core

import android.content.Context
import com.artlite.base64masklibrary.facade.core.SdkBase64Mask
import com.artlite.base64masklibrary.facade.managers.ContextManager

/**
 * Implementation of the [SdkBase64Mask].
 */
internal object SdkBase64MaskImpl: SdkBase64Mask {

    /**
     * Context manager.
     */
    private val contextManager by ContextManager()

    /**
     * Method which provide the on create functional.
     * @param context Context instance.
     */
    override fun onCreate(context: Context) {
        this.contextManager.set(context)
    }

    /**
     * Method which provide the destroy functional.
     */
    override fun onDestroy() {
        this.contextManager.clear()
    }
}