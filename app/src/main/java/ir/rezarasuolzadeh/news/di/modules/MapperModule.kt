package ir.rezarasuolzadeh.news.di.modules

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import ir.rezarasuolzadeh.news.database.model.NewsEntity
import ir.rezarasuolzadeh.news.mapper.NewsMapper
import ir.rezarasuolzadeh.news.mapper.SavedMapper
import ir.rezarasuolzadeh.news.mapper.SourceMapper
import ir.rezarasuolzadeh.news.utils.interfaces.Mapper
import ir.rezarasuolzadeh.news.model.NewsModel
import ir.rezarasuolzadeh.news.model.SourceModel
import ir.rezarasuolzadeh.news.response.NewsResponse
import ir.rezarasuolzadeh.news.response.SourceResponse
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class MapperModule {

    @Binds
    @Singleton
    abstract fun bindNewsMapper(
        mapper: NewsMapper
    ): Mapper<NewsResponse, NewsModel>

    @Binds
    @Singleton
    abstract fun bindSourceMapper(
        mapper: SourceMapper
    ): Mapper<SourceResponse, SourceModel>

    @Binds
    @Singleton
    abstract fun bindSavedNewsMapper(
        mapper: SavedMapper
    ): Mapper<NewsModel, NewsEntity>

}