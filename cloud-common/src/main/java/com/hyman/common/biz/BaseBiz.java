package com.hyman.common.biz;

import com.hyman.common.msg.TableResultResponse;
import com.hyman.common.util.EntityUtils;
import com.hyman.common.util.Query;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.google.common.base.Strings;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.util.StringUtils;
import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.entity.Example;

import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by Mr.AG
 * Date: 17/1/13
 * Time: 15:13
 * Version 1.0.0
 */
public abstract class BaseBiz<M extends Mapper<T>, T> {

    protected DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
    protected DateFormat dateTimeFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    @Autowired
    protected M mapper;

    protected ApplicationContext applicationContext;

    public void setMapper(M mapper) {
        this.mapper = mapper;
    }

    public T selectOne(T entity) {
        return mapper.selectOne(entity);
    }


    public T selectById(Object id) {
        return mapper.selectByPrimaryKey(id);
    }


    public List<T> selectList(T entity) {
        return mapper.select(entity);
    }


    public List<T> selectListAll() {
        return mapper.selectAll();
    }


    public Long selectCount(T entity) {
        return new Long(mapper.selectCount(entity));
    }


    public int insert(T entity) {
        EntityUtils.setCreatAndUpdatInfo(entity);
        return mapper.insert(entity);
    }

    public int insertSelective(T entity) {
        EntityUtils.setCreatAndUpdatInfo(entity);
        return mapper.insertSelective(entity);
    }

    public void save(T entity) {
        mapper.insertSelective(entity);
    }

    public int delete(T entity) {
        return mapper.delete(entity);
    }


    public int deleteById(Object id) {
        return mapper.deleteByPrimaryKey(id);
    }


    public int updateById(T entity) {
        EntityUtils.setUpdatedInfo(entity);
        return mapper.updateByPrimaryKey(entity);
    }


    public int updateSelectiveById(T entity) {
        EntityUtils.setUpdatedInfo(entity);
        return mapper.updateByPrimaryKeySelective(entity);
    }

    public List<T> selectByExample(Object example) {
        return mapper.selectByExample(example);
    }

    public List<T> selectByExampleAndRowBounds(Object example, RowBounds rowBounds) {
        return mapper.selectByExampleAndRowBounds(example, rowBounds);
    }

    public int selectCountByExample(Object example) {
        return mapper.selectCountByExample(example);
    }

    public TableResultResponse<T> selectByQuery(Query query) {
        Class<T> clazz = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[1];
        Example example = new Example(clazz);
        if (query.entrySet().size() > 0) {
            Example.Criteria criteria = example.createCriteria();
            for (Map.Entry<String, Object> entry : query.entrySet()) {
                criteria.andLike(entry.getKey(), "%" + entry.getValue().toString() + "%");
            }
        }
        Page<Object> result = PageHelper.startPage(query.getPage(), query.getLimit());
        List<T> list = mapper.selectByExample(example);
        return new TableResultResponse<T>(result.getTotal(), list);
    }

    protected Date convertBirthday(int age) {
        Calendar c = Calendar.getInstance();
        c.set(Calendar.YEAR, c.get(Calendar.YEAR) - age);
        return c.getTime();
    }

    protected Date tryParseDate(String date) {
        if (Strings.isNullOrEmpty(date)) {
            return null;
        }
        try {
            return dateFormat.parse(date);
        } catch (ParseException e) {
            try {
                return dateTimeFormat.parse(date);
            } catch (ParseException e1) {
                int age = 0;
                try {
                    age = Integer.parseInt(date);
                } catch (NumberFormatException e2) {
                }
                if (age > 10 && age < 100) {
                    Calendar c = Calendar.getInstance();
                    c.add(Calendar.YEAR, -age);
                    return c.getTime();
                }

            }
        }
        return null;
    }

    /**
     * 驼峰命名
     *
     * @param name
     * @return
     */
    public String camelName(String name) {
        name = name.toLowerCase();
        StringBuilder result = new StringBuilder();
        // 快速检查
        if (name == null || name.isEmpty()) {
            // 没必要转换
            return "";
        } else if (!name.contains("_")) {
            // 不含下划线，仅将首字母小写
            return name.substring(0, 1).toLowerCase() + name.substring(1);
        }
        // 用下划线将原始字符串分割
        String[] camels = name.split("_");
        for (String camel : camels) {
            // 跳过原始字符串中开头、结尾的下换线或双重下划线
            if (camel.isEmpty()) {
                continue;
            }
            // 处理真正的驼峰片段
            if (result.length() == 0) {
                // 第一个驼峰片段，全部字母都小写
                result.append(camel.toLowerCase());
            } else {
                // 其他的驼峰片段，首字母大写
                result.append(camel.substring(0, 1).toUpperCase());
                result.append(camel.substring(1).toLowerCase());
            }
        }
        return result.toString();
    }

    public String underscoreName(String name) {
        if (!StringUtils.hasLength(name)) {
            return "";
        }
        StringBuilder result = new StringBuilder();
        result.append(lowerCaseName(name.substring(0, 1)));
        for (int i = 1; i < name.length(); i++) {
            String s = name.substring(i, i + 1);
            String slc = lowerCaseName(s);
            if (!s.equals(slc)) {
                result.append("_").append(slc);
            } else {
                result.append(s);
            }
        }
        return result.toString();
    }

    /**
     * Convert the given name to lower case.
     * By default, conversions will happen within the US locale.
     *
     * @param name the original name
     * @return the converted name
     * @since 3.4.2
     */
    public String lowerCaseName(String name) {
        return name.toLowerCase(Locale.US);
    }

    public long ObjectTOLong(Object longObj) {
        return Long.valueOf(String.valueOf(longObj));
    }

    /**
     * 将数据库带_的字段转换为camel格式
     *
     * @param args
     * @return
     */
    public List<Map<String, Object>> camelMap(List<Map<String, Object>> args) {
        if (args == null) {
            return null;
        }
        Map<String, Object> m1 = null;
        List<Map<String, Object>> list = Lists.newArrayList();
        for (Map<String, Object> map : args) {
            m1 = Maps.newHashMap();

            for (Iterator<String> iterator = map.keySet().iterator(); iterator.hasNext(); ) {
                String key = iterator.next();
                m1.put(camelName(key), map.get(key));
            }
            list.add(m1);
        }
        return list;
    }

    /**
     * 将数据库带_的字段转换为camel格式
     *
     * @param args
     * @return
     */
    public Map<String, Object> camelMap(Map<String, Object> args) {
        if (args == null) {
            return null;
        }
        Map<String, Object> result = Maps.newHashMap();
        for (Iterator<String> iterator = args.keySet().iterator(); iterator.hasNext(); ) {
            String key = iterator.next();
            result.put(camelName(key), args.get(key));
        }
        return result;
    }


    /**
     * 将数据库带_的字段转换为camel格式的Page
     *
     * @param args
     * @return
     */
    public Page<Map<String, Object>> camelPageMap(Page<Map<String, Object>> args) {
        if (args == null) {
            return null;
        }
        Map<String, Object> m1 = null;
        Page list = new Page();
        BeanUtils.copyProperties(args, list);
        for (Map<String, Object> map : args) {
            m1 = Maps.newHashMap();
            for (Iterator<String> iterator = map.keySet().iterator(); iterator.hasNext(); ) {
                String key = iterator.next();
                m1.put(camelName(key), map.get(key));
            }
            list.add(m1);
        }
        return list;
    }


    public Map<String, Object> convertBeanToMap(Object bean) {
        try {
            Class type = bean.getClass();
            Map<String, Object> returnMap = new HashMap<String, Object>();
            BeanInfo beanInfo = Introspector.getBeanInfo(type);
            PropertyDescriptor[] propertyDescriptors = beanInfo.getPropertyDescriptors();
            for (int i = 0; i < propertyDescriptors.length; i++) {
                PropertyDescriptor descriptor = propertyDescriptors[i];
                String propertyName = descriptor.getName();
                if (!"class".equals(propertyName)) {
                    Method readMethod = descriptor.getReadMethod();
                    Object result = readMethod.invoke(bean);
                    if (result != null) {
                        returnMap.put(propertyName, result);
                    } else {
                        returnMap.put(propertyName, "");
                    }
                }
            }
            return returnMap;
        } catch (IntrospectionException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

        return null;
    }
}
