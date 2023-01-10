package com.artlite.base64masklibrary.impl.helpers

import android.util.Base64
import com.artlite.base64masklibrary.facade.helpers.Base64MaskHelper
import com.artlite.base64masklibrary.facade.managers.ContextManager

/**
 * Implementation fo the [Base64MaskHelper].
 */
internal object Base64MaskHelperImpl: Base64MaskHelper {

    /**
     * Context manager instance.
     */
    private val contextManager by ContextManager()

    /**
     * Method which provide encode string to Base64 string with steps.
     * @receiver AFBase64.Companion
     * @param value Int
     * @param steps Int
     * @return String
     */
    override fun encode(value: Int, steps: Int): String {
        val resources = contextManager.getRequiredContext().resources
        val string = resources.getString(value)
        return encode(string, steps)
    }

    /**
     * Method which provide encode string to Base64 string with steps.
     * @receiver AFBase64.Companion
     * @param value String
     * @param steps Int
     * @return String
     */
    override fun encode(value: String, steps: Int): String {
        var result = value
        for (i in 1..steps) {
            result = Base64.encodeToString(result.toByteArray(), Base64.NO_WRAP)
        }
        return result
    }

    /**
     * Method which provide to decode base64 to string with steps.
     * @receiver AFBase64.Companion
     * @param value Int
     * @param steps Int
     * @return String
     */
    override fun decode(value: Int, steps: Int): String {
        val resources = contextManager.getRequiredContext().resources
        val string = resources.getString(value)
        return decode(string, steps)
    }

    /**
     * Method which provide to decode base64 to string with steps.
     * @receiver AFBase64.Companion
     * @param value String
     * @param steps Int
     * @return String
     */
    override fun decode(value: String, steps: Int): String {
        var result = value
        for (i in 1..steps) {
            result = String(Base64.decode(result.toByteArray(), Base64.NO_WRAP))
        }
        return result
    }

}