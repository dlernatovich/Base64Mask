package com.artlite.base64masklibrary.facade.helpers

import androidx.annotation.StringRes
import com.artlite.base64masklibrary.impl.helpers.Base64MaskHelperImpl
import kotlin.properties.ReadOnlyProperty
import kotlin.reflect.KProperty

interface Base64MaskHelper {

    /**
     * Method which provide encode string to Base64 string with steps.
     * @receiver AFBase64.Companion
     * @param value Int
     * @param steps Int
     * @return String
     */
    fun encode(@StringRes value: Int, steps: Int): String

    /**
     * Method which provide encode string to Base64 string with steps.
     * @receiver AFBase64.Companion
     * @param value String
     * @param steps Int
     * @return String
     */
    fun encode(value: String, steps: Int): String

    /**
     * Method which provide to decode base64 to string with steps.
     * @receiver AFBase64.Companion
     * @param value Int
     * @param steps Int
     * @return String
     */
    fun decode(@StringRes value: Int, steps: Int): String

    /**
     * Method which provide to decode base64 to string with steps.
     * @receiver AFBase64.Companion
     * @param value String
     * @param steps Int
     * @return String
     */
    fun decode(value: String, steps: Int): String

    /**
     * Static functionality.
     */
    companion object : () -> ReadOnlyProperty<Any?, Base64MaskHelper> {
        override fun invoke(): ReadOnlyProperty<Any?, Base64MaskHelper> = Injector()
        open class Injector : ReadOnlyProperty<Any?, Base64MaskHelper> {
            override fun getValue(thisRef: Any?, property: KProperty<*>): Base64MaskHelper =
                Base64MaskHelperImpl
        }
    }

}