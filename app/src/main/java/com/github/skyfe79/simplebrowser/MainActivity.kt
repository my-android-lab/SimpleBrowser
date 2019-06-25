package com.github.skyfe79.simplebrowser

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import org.mozilla.geckoview.GeckoRuntime
import org.mozilla.geckoview.GeckoRuntimeSettings
import org.mozilla.geckoview.GeckoSession

class MainActivity : AppCompatActivity(), GeckoRuntime.Delegate {

    private val session: GeckoSession by lazy {
        GeckoSession()
    }

    private lateinit var runtime: GeckoRuntime

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        runtime = GeckoRuntime.getDefault(applicationContext)
        runtime.delegate = this
        session.open(runtime)
        engineView.setSession(session)
        session.loadUri("https://www.google.com")
    }

    override fun onShutdown() {
        session.close()
    }
}
