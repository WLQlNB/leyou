package club.wlqzz.service;

import club.wlqzz.pojo.Category;

import java.util.List;

public interface CategoryService {
    List<Category> queryCategoryByPid(Long pid);
}
