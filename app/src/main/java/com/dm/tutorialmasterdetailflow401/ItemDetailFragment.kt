package com.dm.tutorialmasterdetailflow401

import android.os.Bundle
import androidx.fragment.app.Fragment
import com.google.android.material.appbar.CollapsingToolbarLayout
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.dm.tutorialmasterdetailflow401.dummy.DummyContent

/**
 * Un frammento che rappresenta una singola schermata dei dettagli dell'oggetto.
 * Questo frammento è contenuto in un file [ItemListActivity]
 * in modalità a due riquadri (su tablet) nel file [ItemDetailActivity]
 * sui portatili.
 */
class ItemDetailFragment : Fragment() {

    /**
     * Il contenuto fittizio presentato da questo frammento.
     */
    private var item: DummyContent.DummyItem? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        arguments?.let {
            if (it.containsKey(ARG_ITEM_ID)) {
                // Carica il contenuto fittizio specificato dagli argomenti del frammento.
                // In uno scenario reale, utilizza un caricatore per caricare il contenuto
                // da un fornitore di contenuti.
                item = DummyContent.ITEM_MAP[it.getString(ARG_ITEM_ID)]
                activity?.findViewById<CollapsingToolbarLayout>(R.id.toolbar_layout)?.title = item?.content
            }
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val rootView = inflater.inflate(R.layout.item_detail, container, false)

        // Mostra il contenuto fittizio come testo in una TextView.
        item?.let {
            rootView.findViewById<TextView>(R.id.item_detail).text = it.details
        }

        return rootView
    }

    companion object {
        /**
         * L'argomento del frammento che rappresenta l'ID dell'elemento rappresentato
         * da questo frammento.
         */
        const val ARG_ITEM_ID = "item_id"
    }
}