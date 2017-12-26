package rugu.yetote.com.zhihuadvertisementdemo;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.GET;

/**
 * rugu.yetote.com.zhihuadvertisementdemo
 *
 * @author Swg
 * @date 2017/12/22 15:30
 */
public interface AdvertisementService {
    /**
     * 获取mulitLayout_sc.php中返回的数据
     * @return myModel类型的列表
     */
    @GET("advertisement.php")
    Observable<List<MyModel>> getData();
}
