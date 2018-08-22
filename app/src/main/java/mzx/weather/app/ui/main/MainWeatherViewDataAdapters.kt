package mzx.weather.app.ui.main

import android.widget.TextView
import androidx.annotation.RawRes
import androidx.databinding.BindingAdapter
import mzx.weather.app.uidata.*
import mzx.weather.domain.element.WeatherElement

@BindingAdapter("weatherDataUi")
fun weatherDataUi(textView: TextView, @RawRes dataUI: DataUI) {
    textView.text = when (dataUI) {
        is Response<*> -> {
            if (dataUI.respponse is WeatherElement) {
                dataUI.respponse.main.temp.toString()
            } else {
                ""
            }
        }
        is Initial -> "Initial"
        is Loading -> "Loading"
        is ErrorData -> "Error"
    }
}