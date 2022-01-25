package com.news24.app.ui.navigation

import androidx.fragment.app.DialogFragment
import ru.terrakok.cicerone.android.support.SupportAppNavigator
import ru.terrakok.cicerone.android.support.SupportAppScreen
import ru.terrakok.cicerone.commands.Forward

open class ApplicationNavigator(
		private val activity: androidx.fragment.app.FragmentActivity,
		private val fragmentManager: androidx.fragment.app.FragmentManager,
		containerId: Int
) : SupportAppNavigator(activity, fragmentManager, containerId) {

	constructor(activity: androidx.fragment.app.FragmentActivity, containerId: Int) :
			this(activity, activity.supportFragmentManager, containerId)


	override fun fragmentForward(command: Forward?) {
		when (command?.screen) {
			// ADD BOTTOM SHEET SCREENS
			is Nothing -> {
				val fragment = createFragment(command.screen as SupportAppScreen) as DialogFragment
				val currentFragment: DialogFragment? =
						fragmentManager.findFragmentByTag(command.screen.javaClass.name) as? DialogFragment
				currentFragment?.dismissAllowingStateLoss()
				fragmentManager.executePendingTransactions()
				val transaction = fragmentManager.beginTransaction()
				transaction.addToBackStack(command.screen.javaClass.name)
				fragment.show(transaction, command.screen.javaClass.name)
			}
			else -> super.fragmentForward(command)
		}
	}

}