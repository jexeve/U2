package com.example.u2

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [SumaFragmento.newInstance] factory method to
 * create an instance of this fragment.
 */
class SumaFragmento : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_suma_fragmento, container, false)

        // Configura el listener para el botón "Calcula"
        val btnCalcula: Button = view.findViewById(R.id.btnCalcula)
        val txtValor1: EditText = view.findViewById(R.id.txtValor1)
        val txtValor2: EditText = view.findViewById(R.id.txtValor2)
        val txtResultado: TextView = view.findViewById(R.id.txtResultado)
        val btnReset: Button = view.findViewById(R.id.btnReset)

        btnCalcula.setOnClickListener {
            val valor1 = txtValor1.text.toString().toDoubleOrNull() ?: 0.0
            val valor2 = txtValor2.text.toString().toDoubleOrNull() ?: 0.0
            val resultado = valor1 + valor2
            txtResultado.text = resultado.toString()
        }

        // Configura el listener para el botón "Regresar"
        val btnRegresar: Button = view.findViewById(R.id.btnRegresar)
        btnRegresar.setOnClickListener {
            // Regresar al fragmento anterior en la pila de retroceso
            parentFragmentManager.popBackStack()

            // Mostrar el contenedor de botones en MainActivity
            activity?.findViewById<View>(R.id.buttons_container)?.visibility = View.VISIBLE
        }

        return view
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment SumaFragmento.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            SumaFragmento().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }


}