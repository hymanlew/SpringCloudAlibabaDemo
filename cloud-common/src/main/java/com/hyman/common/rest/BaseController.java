package com.hyman.common.rest;

import com.hyman.common.biz.BaseBiz;
import com.hyman.common.context.BaseContextHandler;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

/**
 * ${DESCRIPTION}
 *
 * @Author
 * @create 2017-06-15 8:48
 */
@Slf4j
@SuppressWarnings("unchecked")
public class BaseController<Biz extends BaseBiz,Entity> {
    @Autowired
    protected HttpServletRequest request;
    @Autowired
    protected Biz baseBiz;

//    @RequestMapping(value = "",method = RequestMethod.POST)
//    @ResponseBody
//    public ObjectRestResponse<Entity> add(@RequestBody Entity model){
//        baseBiz.insertSelective(model);
//        return new ObjectRestResponse<Entity>();
//    }
//
//    @RequestMapping(value = "/{id}",method = RequestMethod.GET)
//    @ResponseBody
//    public ObjectRestResponse<Entity> get(@PathVariable int id){
//        ObjectRestResponse<Entity> entityObjectRestResponse = new ObjectRestResponse<>();
//        Object o = baseBiz.selectById(id);
//        entityObjectRestResponse.data((Entity)o);
//        return entityObjectRestResponse;
//    }
//
//    @RequestMapping(value = "/{id}",method = RequestMethod.PUT)
//    @ResponseBody
//    public ObjectRestResponse<Entity> update(@RequestBody Entity model){
//        baseBiz.updateSelectiveById(model);
//        return new ObjectRestResponse<Entity>();
//    }
//    @RequestMapping(value = "/{id}",method = RequestMethod.DELETE)
//    @ResponseBody
//    public ObjectRestResponse<Entity> remove(@PathVariable int id){
//        baseBiz.deleteById(id);
//        return new ObjectRestResponse<Entity>();
//    }
//
//    @RequestMapping(value = "/all",method = RequestMethod.GET)
//    @ResponseBody
//    public List<Entity> all(){
//        return baseBiz.selectListAll();
//    }
//    @RequestMapping(value = "/page",method = RequestMethod.GET)
//    @ResponseBody
//    public TableResultResponse<Entity> list(@RequestParam Map<String, Object> params){
//        //查询列表数据
//        Query query = new Query(params);
//        return baseBiz.selectByQuery(query);
//    }


    public String getCurrentUserName(){
        return BaseContextHandler.getUsername();
    }

    /**
     * 将名字转换为驼峰命名
     * @param name
     * @return
     */
    public String camelName(String name){
        return baseBiz.camelName(name);
    }

    /**
     * 将驼峰命名转换为_开头的命名
     * @param name
     * @return
     */
    public String underscoreName(String name){
        return baseBiz.underscoreName(name);
    }

    public long ObjectTOLong(Object longObj){
        return baseBiz.ObjectTOLong(longObj);
    }

    /**
     * 将列表转换为驼峰试命名
     * @param args
     * @return
     */
    public List<Map<String,Object>> camelMap(List<Map<String,Object>> args){
        return baseBiz.camelMap(args);
    }
}
