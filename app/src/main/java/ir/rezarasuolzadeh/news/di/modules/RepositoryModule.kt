package ir.rezarasuolzadeh.news.di.modules

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import ir.rezarasuolzadeh.news.repository.NewsRepositoryImp
import ir.rezarasuolzadeh.news.repository.interfaces.NewsRepository
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    @Singleton
    abstract fun bindNewsRepository(
        newsRepository: NewsRepositoryImp
    ): NewsRepository

}