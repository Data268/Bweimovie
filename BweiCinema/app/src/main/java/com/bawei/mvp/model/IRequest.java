package com.bawei.mvp.model;

import com.bawei.user.Data;
import com.bawei.user.HotUser;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * 佀常勇
 *
 * @Data:2019/6/8 21:54
 * 描述：
 */
public interface IRequest {
    //热门电影
    @GET("movieApi/movie/v1/findHotMovieList")
    Observable <Data<List<HotUser>>> hotshow(@Query("page") int page,
                                             @Query("count") String count);
    //正在上映
    @GET("movieApi/movie/v1/findReleaseMovieList")
    Observable <Data<List<HotUser>>> ishotshow(@Query("page") int page,
                                             @Query("count") String count);
    //即将上映
    @GET("movieApi/movie/v1/findComingSoonMovieList")
    Observable <Data<List<HotUser>>> comingshow(@Query("page") int page,
                                             @Query("count") String count);
}
