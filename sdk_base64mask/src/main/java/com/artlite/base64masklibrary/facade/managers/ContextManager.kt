package com.artlite.base64masklibrary.facade.managers

import android.content.Context
import com.artlite.base64masklibrary.impl.managers.ContextManagerImpl
import kotlin.properties.ReadOnlyProperty
import kotlin.reflect.KProperty

/**
 * Manager which provide the [Context] manager keeping.
 */
internal interface ContextManager {

    /**
     * Method which provide the getting of the [Context].
     * @return Context? instance.
     */
    fun getContext(): Context?

    /**
     * Method which provide to get of the required [Context].
     * @return Context instance of the required [Context].
     */
    fun getRequiredContext(): Context

    /**
     * Method which provide the set of the [Context].
     * @param context Context? instance.
     */
    fun set(context: Context?)

    /**
     * Method which provide the clear functionality.
     */
    fun clear()

    /**
     * Static functionality.
     */
    companion object : () -> ReadOnlyProperty<Any?, ContextManager> {
        override fun invoke(): ReadOnlyProperty<Any?, ContextManager> = Injector()
        open class Injector : ReadOnlyProperty<Any?, ContextManager> {
            override fun getValue(thisRef: Any?, property: KProperty<*>): ContextManager =
                ContextManagerImpl
        }
    }

}