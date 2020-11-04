package club.wlqzz.service.impl;

import club.wlqzz.mapper.CategoryMapper;
import club.wlqzz.pojo.Category;
import club.wlqzz.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryMapper categoryMapper;

    /**
     * 根据父节点查询子节点
     * @param pid
     * @return
     */
    @Override
    public List<Category> queryCategoryByPid(Long pid) {
       Category category = new Category();
       category.setParentId(pid);
        return categoryMapper.select(category);
    }
}
