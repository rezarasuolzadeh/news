package ir.rezarasuolzadeh.news.di.modules

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import ir.rezarasuolzadeh.news.repository.NewsRepository
import ir.rezarasuolzadeh.news.utils.interfaces.Repository
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    @Singleton
    abstract fun bindNewsRepository(newsRepository: NewsRepository): Repository

}