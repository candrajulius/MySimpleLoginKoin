package com.candra.mysimpleloginkoin.di

import android.content.Context
import com.candra.mysimpleloginkoin.HomeActivity
import com.candra.mysimpleloginkoin.MainActivity
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [StorageModule2::class])
interface AppComponent {
    @Component.Factory
    interface Factory{
        fun create(@BindsInstance context: Context): AppComponent
    }

    fun inject(activity: MainActivity)
    fun inject(activity: HomeActivity)

}

/*
Kesimpulan
Untuk membuat component perlu annotation @Component. Jika tidak, maka akan muncul eror @Component.Factory types must be nested within a @Component.

@Singleton ada karena di dalam object yang di-inject terdapat @Singleton juga. Jika tidak akan muncul eror IncompatiblyScopedBindings.

Untuk menambahkan module di dalam parameter modules harus menggunakan format Array.

Jika ada objek yang membutuhkan Context, Anda perlu menambahkan @BindsInstance. Jika tidak, maka akan muncul eror MissingBinding Context.

Menambahkan fungsi Inject untuk setiap Activity/Fragment yang membutuhkan, dalam hal ini yaitu MainActivity dan HomeActivity.
 */