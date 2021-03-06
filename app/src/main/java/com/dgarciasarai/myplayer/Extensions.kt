package com.dgarciasarai.myplayer

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.support.annotation.IdRes
import android.support.annotation.LayoutRes
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.Toast
import com.squareup.picasso.Picasso

/**
 * @author Sarai Díaz García
 */
fun Context.toast(msg: String, length: Int = Toast.LENGTH_SHORT) =
    Toast.makeText(this, msg, length).show()

fun RecyclerView.ViewHolder.toast(msg: String, length: Int =
Toast.LENGTH_SHORT) = itemView.context.toast(msg, length)

fun ViewGroup.inflate(@LayoutRes layoutRes: Int) =
    LayoutInflater.from(context).inflate(layoutRes, this, false)

fun ImageView.loadUrl(url: String) = Picasso.with(context).load(url).into(this)

inline fun <reified T : Activity> Context.startActivity() =
    startActivity(Intent(this, T::class.java))

inline fun <reified T : View> View.find(@IdRes idRes: Int) = findViewById(idRes) as T

inline fun <reified T : View> RecyclerView.ViewHolder.find(@IdRes idRes: Int): T {
    return itemView.find<T>(idRes)
}

var View.visible: Boolean
    get() = visibility == View.VISIBLE
    set(value) {
        visibility = if(value) View.VISIBLE else View.GONE
    }
