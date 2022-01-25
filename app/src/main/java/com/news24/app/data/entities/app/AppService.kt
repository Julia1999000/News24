package com.news24.app.data.entities.app

interface AppService {

	fun isShouldShowOnboardingScreen(): Boolean

	fun setShouldShowOnboardingScreen(shouldShow: Boolean)

}