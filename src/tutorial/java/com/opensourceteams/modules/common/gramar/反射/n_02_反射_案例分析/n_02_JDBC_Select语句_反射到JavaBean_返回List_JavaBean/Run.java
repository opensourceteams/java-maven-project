package com.opensourceteams.modules.common.gramar.反射.n_02_反射_案例分析.n_02_JDBC_Select语句_反射到JavaBean_返回List_JavaBean;

import com.opensourceteams.modules.common.java.lang.reflect.ReflectUtil;
import com.opensourceteams.modules.common.java.util.sql.JDBCUtil;
import org.junit.Test;

import java.sql.Types;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * 日期: 2016-03-29  07:41
 * 开发人:刘文  -->  (372065525@qq.com)
 * 功能描述: JDBC查询数据库表行数据,反射处理,返回List<T>
 * ).JDBC查询
 * ).元数据得到数据库表和字段描述信息(字段名称,类型,长度,值)
 * ).反射把数据注入到类属性值
 * ).反回的是List
 */
public class Run {

    /**
     * 设置list<T>属性
     * 功能说
     */
    @Test
    public void testSetPropertiesList(){
        String sql = "select * from student  where  id > ? "  ;
        List<Object> values = new ArrayList<Object>();
        values.add(0);

        List<Integer> types = new ArrayList<Integer>();
        types.add(Types.INTEGER);



        List<Map<Object,Object>> listMap = JDBCUtil.getSelectList(sql,values,types);
        List<Student> listStudent = new ReflectUtil<Student>().setPropertiesList(Student.class, listMap);

        for (Student stu : listStudent){
            System.out.println(stu);

        }
    }
}
