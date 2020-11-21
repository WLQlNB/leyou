package club.wlqzz.service;

import com.leyou.common.pojo.Brand;
import com.leyou.common.pojo.PageResult;

import java.util.List;

public interface BrandService {

    public PageResult<Brand> queryBrandsByPage(String key, Integer page, Integer rows, String sortBy, Boolean desc) ;

    void saveBrand(Brand brand, List<Long> cids);
}