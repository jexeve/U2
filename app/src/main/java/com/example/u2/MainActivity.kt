package com.example.u2

import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        // Configura el Listener para manejar las insets de la ventana
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // Configura el Listener para el botón btn_SUMA
        findViewById<Button>(R.id.btn_SUMA)?.setOnClickListener {
            // Oculta el contenedor de botones
            findViewById<View>(R.id.buttons_container).visibility = View.GONE

            // Reemplaza el contenido del contenedor principal con el fragmento SumaFragmento
            val fragment = SumaFragmento()
            supportFragmentManager.beginTransaction()
                .replace(R.id.main, fragment)
                .addToBackStack(null)
                .commit()
        }
    }

}
