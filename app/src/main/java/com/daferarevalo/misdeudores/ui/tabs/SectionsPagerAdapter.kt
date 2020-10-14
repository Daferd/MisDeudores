package com.daferarevalo.misdeudores.ui.tabs

import android.content.Context
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.daferarevalo.misdeudores.R
import com.daferarevalo.misdeudores.ui.actualizar.ActualizarFragment
import com.daferarevalo.misdeudores.ui.borrar.BorrarFragment
import com.daferarevalo.misdeudores.ui.buscar.buscarFragment
import com.daferarevalo.misdeudores.ui.crear.crearFragment

private val TAB_TITLES = arrayOf(
    R.string.crear,
    R.string.buscar,
    R.string.actualizar,
    R.string.borrar
)

class SectionsPagerAdapter(private val context: Context, fm: FragmentManager) :
    FragmentPagerAdapter(fm) {

    override fun getItem(position: Int): Fragment {
        when (position) {
            0 -> return crearFragment()
            1 -> return buscarFragment()
            2 -> return ActualizarFragment()
            else -> return BorrarFragment()
        }
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return context.resources.getString(TAB_TITLES[position])
    }

    override fun getCount(): Int {
        return 4
    }
}