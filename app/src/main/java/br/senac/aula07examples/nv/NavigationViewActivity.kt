package br.senac.aula07examples.nv

import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import br.senac.aula07examples.R
import br.senac.aula07examples.databinding.ActivityNvBinding
import br.senac.aula07examples.fragments.RecentsFragment

class NavigationViewActivity : AppCompatActivity() {
    lateinit var binding: ActivityNvBinding
    lateinit var toggle : ActionBarDrawerToggle

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityNvBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        toggle = ActionBarDrawerToggle(this, binding.drawerLayout, R.string.open_menu, R.string.close_menu)

        binding.drawerLayout.addDrawerListener(toggle)
        toggle.syncState()


        binding.navigationView.setNavigationItemSelectedListener {

            binding.drawerLayout.closeDrawers()

            if(it.itemId == R.id.recentes){
                val frag: Fragment = RecentsFragment.newInstance()

                supportFragmentManager.beginTransaction().replace(R.id.container, frag).commit()
            }


            true
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return toggle.onOptionsItemSelected(item)
    }

}