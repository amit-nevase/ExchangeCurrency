package com.amit.exchangecurrency.ui

import android.app.Application
import com.amit.exchangecurrency.di.initDI
import io.github.inflationx.calligraphy3.CalligraphyConfig
import io.github.inflationx.calligraphy3.CalligraphyInterceptor
import io.github.inflationx.viewpump.ViewPump

class App : Application() {

    override fun onCreate() {
        super.onCreate()
        ViewPump.init(
            ViewPump.builder()
                .addInterceptor(
                    CalligraphyInterceptor(
                        CalligraphyConfig.Builder()
                            .setDefaultFontPath("fonts/Montserrat-Bold.ttf")
                            .setFontAttrId(com.amit.exchangecurrency.R.attr.fontPath)
                            .build()
                    )
                )
                .build()
        )
//        CalligraphyConfig.initDefault(
//            CalligraphyConfig.Builder()
//                .setDefaultFontPath("fonts/Montserrat-Bold.ttf")
//                .setFontAttrId(R.attr.fontPath)
//                .build()
//        )

        initDI()
    }
}
