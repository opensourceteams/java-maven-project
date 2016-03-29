package com.opensourceteams.modules.common.java.lang.reflect;

import com.opensourceteams.modules.common.gramar.反射.n_02_反射_案例分析.n_01_JavaBean属性值的复制.ManBean;
import com.opensourceteams.modules.common.gramar.反射.n_02_反射_案例分析.n_01_JavaBean属性值的复制.WomanBean;
import com.opensourceteams.modules.common.java.util.sql.JDBCUtil;
import org.junit.Test;

import java.lang.reflect.Field;
import java.sql.*;
import java.util.*;
import java.util.Date;

import static javax.swing.UIManager.getInt;

/**
 * 日期: 2016-03-29  05:02
 * 开发人:刘文  -->  (372065525@qq.com)
 * 功能描述:
 */
public class ReflectUtilTest {

    /**
     * 得到类实例的所有属性信息,(属性信息包括,类型,名称,值,等)
     */
    @Test
    public void testGetFields(){
        ManBean manBean = new ManBean("长胡子","刘德华",50,new Date(),new Date(),new Date());
        Field[] fields = new ReflectUtil<ManBean>().getDeclaredFields(manBean);
        for (Field f : fields){
            f.setAccessible(true);
            try {
                System.out.println(f.getType() + " -> " + f.getName() + " -> " + f.get(manBean));
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }

    }

    /**
     * 两个类实例,进行属性值的复制
     */
    @Test
    public void testCopyProperties(){
        ManBean manBean = new ManBean("长胡子","刘德华",50,new Date(),new Date(),new Date());
        WomanBean womanBean = new WomanBean("生了个胖娃娃","凯丽",20,new Date(),new Date(),new Date());
        new ReflectUtil<ManBean>().copyProperties(manBean,womanBean);

        System.out.println(womanBean.getName());
        System.out.println(womanBean.getAge());
        System.out.println(womanBean.getBirthTochild());
        System.out.println(womanBean.getBirthday());
        System.out.println(womanBean.getCreateDate());
        System.out.println(womanBean.getUpdateDate());


    }

    /**
     * 给类的属性赋值
     */
    @Test
    public void testSetProperties(){

        Map<Object,Object> map = new HashMap<Object, Object>();
        map.put("name","刘文");
        map.put("age","18");
        map.put("birthday",new Date());
        ManBean manBean = new ReflectUtil<ManBean>().setProperties(ManBean.class,map);
        System.out.println(manBean.getName());
        System.out.println(manBean.getAge());
        System.out.println(manBean.getBirthday());
    }



    /**
     * testResultSetPreparedStatement 查询数据
     */
    @Test
    public void testResultSetPreparedStatementPrint(){
        String sql = "select * from student  where name =? and id = ?"  ;
        List<Object> values = new ArrayList<Object>();
        values.add("中国16");
        values.add(2);

        List<Integer> types = new ArrayList<Integer>();
        types.add(Types.VARCHAR);
        types.add(Types.INTEGER);

        Connection connection = JDBCUtil.getNewConnection();
        ResultSet resultSet = null;
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            List<Map<String,Object>> list = JDBCUtil.getMetaData(ps);

            resultSet = JDBCUtil.resultSetPreparedStatement(connection,ps,sql,values,types);




            try {
                while (resultSet.next()){
                    System.out.print("id:" + resultSet.getInt("id") );
                    System.out.println("\tname:" + resultSet.getString("name"));
                    System.out.println();
                    System.out.println("=======");
                    for (Map<String,Object> map : list){
                       /* System.out.println(map.get("columnName"));
                        System.out.println(map.get("columnType"));
                        System.out.println(map.get("columnClassName"));*/


                        if("java.lang.Integer".equals(map.get("columnClassName"))){
                            if(resultSet.getObject(map.get("columnName")+"") == null){
                                //空值

                            }else{
                                int value = resultSet.getInt(map.get("columnName")+"");
                                System.out.println(value);
                            }
                        }else  if("java.lang.String".equals(map.get("columnClassName"))){
                            if(resultSet.getObject(map.get("columnName")+"") == null){
                                //空值

                            }else{
                                String value = resultSet.getString(map.get("columnName")+"");
                                System.out.println(value);
                            }
                        }
                    }
                }

            } catch (SQLException e) {
                e.printStackTrace();
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }


        JDBCUtil.close(connection,resultSet);

    }


    /**
     * testResultSetPreparedStatement 查询数据
     */
    @Test
    public void testResultSetPreparedStatementPrint2(){

        List<Student> listStudent = new ArrayList<Student>();
        String sql = "select * from student  where  id > ? "  ;
        List<Object> values = new ArrayList<Object>();
        values.add(0);

        List<Integer> types = new ArrayList<Integer>();
        types.add(Types.INTEGER);

        Connection connection = JDBCUtil.getNewConnection();
        ResultSet resultSet = null;
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            List<Map<String,Object>> list = JDBCUtil.getMetaData(ps);

            resultSet = JDBCUtil.resultSetPreparedStatement(connection,ps,sql,values,types);


            Map<Object,Object> resultMap = new HashMap<Object, Object>();

            try {
                while (resultSet.next()){
                    System.out.print("id:" + resultSet.getInt("id") );
                    System.out.println("\tname:" + resultSet.getString("name"));
                    System.out.println();
                    System.out.println("=======");
                    for (Map<String,Object> map : list){
                       /* System.out.println(map.get("columnName"));
                        System.out.println(map.get("columnType"));
                        System.out.println(map.get("columnClassName"));*/


                        if("java.lang.Integer".equals(map.get("columnClassName"))){
                            if(resultSet.getObject(map.get("columnName")+"") == null){
                                //空值
                                resultMap.put(map.get("columnName")+"",0);

                            }else{
                                int value = resultSet.getInt(map.get("columnName")+"");
                                System.out.println(value);
                                resultMap.put(map.get("columnName")+"",value);
                            }
                        }else  if("java.lang.String".equals(map.get("columnClassName"))){
                            if(resultSet.getObject(map.get("columnName")+"") == null){
                                //空值
                                resultMap.put(map.get("columnName")+"",null);

                            }else{
                                String value = resultSet.getString(map.get("columnName")+"");
                                System.out.println(value);
                                resultMap.put(map.get("columnName")+"",value);
                            }
                        }


                    } //end for

                    Student student = new ReflectUtil<Student>().setProperties(Student.class,resultMap);
                    listStudent.add(student);
                }

            } catch (SQLException e) {
                e.printStackTrace();
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }


        System.out.println("结果");
        for (Student stu : listStudent){
            System.out.println(stu.getName());
            System.out.println(stu.getAge());
            System.out.println(stu.getId());
        }


        JDBCUtil.close(connection,resultSet);

    }

    /**
     * 设置 T 类属性
     */
    @Test
    public void testGetSelectList(){
        String sql = "select * from student  where  id > ? "  ;
        List<Object> values = new ArrayList<Object>();
        values.add(0);

        List<Integer> types = new ArrayList<Integer>();
        types.add(Types.INTEGER);
        List<Map<Object,Object>> list = JDBCUtil.getSelectList(sql,values,types);
        List<Student> listStudent = new ArrayList<Student>();
        for (Map<Object,Object> map : list){
            Student student = new ReflectUtil<Student>().setProperties(Student.class,map);
            listStudent.add(student);
        }
        System.out.println("结果");
        for (Student stu : listStudent){
            System.out.println(stu);

        }
    }

    /**
     * 设置list<T>属性
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
