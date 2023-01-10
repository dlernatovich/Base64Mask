package com.artlite.base64masklibrary.facade.core

import android.content.Context
import com.artlite.base64masklibrary.impl.core.SdkBase64MaskImpl
import kotlin.properties.ReadOnlyProperty
import kotlin.reflect.KProperty

/**
 * Sdk entry point.
 */
interface SdkBase64Mask {

    /**
     * Method which provide the on create functional.
     * @param context Context instance.
     */
    fun onCreate(context: Context)

    /**
     * Method which provide the destroy functional.
     */
    fun onDestroy()

    /**
     * Static functionality.
     */
    companion object : () -> ReadOnlyProperty<Any?, SdkBase64Mask> {
        override fun invoke(): ReadOnlyProperty<Any?, SdkBase64Mask> = Injector()
        open class Injector : ReadOnlyProperty<Any?, SdkBase64Mask> {
            override fun getValue(thisRef: Any?, property: KProperty<*>): SdkBase64Mask =
                SdkBase64MaskImpl
        }
    }

}