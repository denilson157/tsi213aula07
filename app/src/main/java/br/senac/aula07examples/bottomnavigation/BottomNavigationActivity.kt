package br.senac.aula07examples.bottomnavigation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import br.senac.aula07examples.R
import br.senac.aula07examples.databinding.ActivityBottomNavigationBinding
import br.senac.aula07examples.fragments.AlbumsFragment
import br.senac.aula07examples.fragments.ArtistsFragment
import br.senac.aula07examples.fragments.RecentsFragment

class BottomNavigationActivity : AppCompatActivity() {

    lateinit var binding: ActivityBottomNavigationBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityBottomNavigationBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val frag: Fragment = RecentsFragment.newInstance()
        supportFragmentManager.beginTransaction().replace(R.id.container, frag).commit()

        binding.bottomNavigationView2.setOnItemSelectedListener {

            when(it.itemId){
                R.id.recentes-> {
                    supportFragmentManager.beginTransaction().replace(R.id.container, frag).commit()
                }
                R.id.albuns-> {
                    val frag = AlbumsFragment.newInstance()
                    supportFragmentManager.beginTransaction().replace(R.id.container, frag).commit()
                }
                R.id.artistas -> {
                    val frag = ArtistsFragment.newInstance()
                    supportFragmentManager.beginTransaction().replace(R.id.container, frag).commit()
                }
                R.id.opcoes -> {
                    supportFragmentManager.beginTransaction().replace(R.id.container, frag).commit()
                }
            }

            true

        }
    }

}