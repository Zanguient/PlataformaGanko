package ganko.movil.ganko1.di

import dagger.Module
import dagger.android.ContributesAndroidInjector
import ganko.movil.ganko1.ui.farm.add.AddFarmActivity
import ganko.movil.ganko1.ui.login.LoginActivity
import ganko.movil.ganko1.ui.farm.FarmActivity
import ganko.movil.ganko1.ui.login.password.PasswordActivity
import ganko.movil.ganko1.ui.menu.MenuActivity
import javax.inject.Scope

/**
 * Created by Ana Marin on 18/10/2017.
 */
@Retention(AnnotationRetention.RUNTIME)
@Scope
annotation class ActivityScope

@Module
abstract class ActivityBuilders{

    @ActivityScope
    @ContributesAndroidInjector
    abstract fun bindMainActivity(): FarmActivity

    @ActivityScope
    @ContributesAndroidInjector
    abstract fun bindLoginActivity(): LoginActivity

    @ActivityScope
    @ContributesAndroidInjector
    abstract fun bindPasswordActivity(): PasswordActivity

    @ActivityScope
    @ContributesAndroidInjector
    abstract fun bindAddFarmActivity(): AddFarmActivity

    @ActivityScope
    @ContributesAndroidInjector
    abstract fun bindMenuActivity(): MenuActivity

}