package com.xuanzi.mybatis01;

import com.xuanzi.mybatis01.dao.StudentDao;
import com.xuanzi.mybatis01.entities.Student;
import org.junit.Test;
import org.junit.Before;
import org.junit.After;

/**
 * StudentDao Tester.
 *
 * @author <Authors name>
 * @version 1.0
 * @since <pre>09/24/2018</pre>
 */
public class StudentDaoTest {

    @Before
    public void before() throws Exception {
    }

    @After
    public void after() throws Exception {
    }

    /**
     * Method: getStudentById(int id)
     */
    @Test
    public void testGetStudentById() throws Exception {
        StudentDao dao=new StudentDao();
        Student student=dao.getStudentById(1);
        System.out.println(student);
    }


}