package com.xuanzi.mybatis01.dao;

import com.xuanzi.mybatis01.entities.Student;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.InputStream;

public class StudentDao {

    public Student getStudentById(int id){
        //使用类加载器加载mybatis的配置文件（它也加载关联的映射文件）
        InputStream stream=StudentDao.class.getClassLoader().getResourceAsStream("conf.xml");
        //构建sqlSession的工厂
        SqlSessionFactory ssf=new SqlSessionFactoryBuilder().build(stream);
        //使用MyBatis提供的Resources类加载mybatis的配置文件（它也加载关联的映射文件）
        //Reader reader = Resources.getResourceAsReader(resource);
        //构建sqlSession的工厂
        //SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(reader);

        //创建能执行映射文件中sql的sqlSession
        SqlSession session=ssf.openSession();
        /**
         * 映射sql的标识字符串，
         * com.zhangguo.mybatis01.dao.studentMapper是studentMapper.xml文件中mapper标签的namespace属性的值，
         * selectStudentById是select标签的id属性值，通过select标签的id属性值就可以找到要执行的SQL
         */
        Student student=session.selectOne("com.xuanzi.mybatis01.dao.studentMapper.selectStudentById",3);
        return student;
    }

    public static void main(String[] args) {
        StudentDao dao=new StudentDao();
        Student student=dao.getStudentById(2);
        System.out.println(student);
    }

}
