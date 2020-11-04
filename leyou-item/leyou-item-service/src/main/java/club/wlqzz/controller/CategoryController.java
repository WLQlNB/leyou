package club.wlqzz.controller;

import club.wlqzz.pojo.Category;
import club.wlqzz.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("category")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    /**
     * 根据父节点的id查询子节点id
     * @param pid
     * @return
     */
    @GetMapping("list")
    public ResponseEntity<List<Category>> queryCategoryByPid(@RequestParam(value = "pid",defaultValue = "0") Long pid){
        if(pid==null || pid < 0){
            //400 参数不合法
            return ResponseEntity.badRequest().build();
        }
        List<Category> categories = categoryService.queryCategoryByPid(pid);
        if(CollectionUtils.isEmpty(categories)){
           //404 资源服务器未找到
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(categories);
    }
}
