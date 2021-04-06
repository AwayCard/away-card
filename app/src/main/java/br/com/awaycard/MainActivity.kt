package br.com.awaycard

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import br.com.awaycard.navigation.NavMachine
import br.com.awaycard.navigation.NavMachineGraph
import br.com.awaycard.navigation.NavMachineV1

class MainActivity : AppCompatActivity(), NavMachine {
    private val navMachineV1: NavMachineV1 by lazy { NavMachineV1(this) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val nav = findNavController(R.id.main_nav_host)
        navMachineV1.updateNavController(nav)
    }

    override fun navigateToMachineGraph(graph: NavMachineGraph) {
        navMachineV1.navigateTo(graph)
    }
}