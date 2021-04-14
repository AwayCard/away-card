package br.com.awaycard.navigation

import android.content.Context
import androidx.navigation.NavController

class NavMachineV1(context: Context) {
    private var navController: NavController = NavController(context)

    fun navigateTo(machineGraph: NavMachineGraph) {
        when (machineGraph) {
            NavMachineGraph.OnBoarding -> navController.navigate(MainNavigationGraphDirections.actionGlobalOnboarding())
        }
    }

    fun updateNavController(navController: NavController) {
        this.navController = navController
    }
}

sealed class NavMachineGraph {
    object OnBoarding : NavMachineGraph()
}

interface NavMachine {
    fun navigateToMachineGraph(graph: NavMachineGraph)
}