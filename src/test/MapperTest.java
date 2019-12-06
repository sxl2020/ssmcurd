import com.atguigu.curd.bean.crud.Department;
import com.atguigu.curd.bean.crud.Employee;
import com.atguigu.curd.dao.DepartmentMapper;
import com.atguigu.curd.dao.EmployeeMapper;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
 import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.UUID;

/*
*
* */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
public class MapperTest {

    @Autowired
    DepartmentMapper departmentMapper;
    @Autowired
    EmployeeMapper employeeMapper;
    @Autowired
    SqlSession sqlSession;

    /*
    * 测试DepartmentMapper
    * */
    @Test
    public void testDepartmentCRUD(){
        //1.创建SpringIOC容器
//        System.out.println(departmentMapper);
        // 插入部门
        departmentMapper.insertSelective( new Department("Develop Part"));
        departmentMapper.insertSelective( new Department(99,"HR Part"));
        }

    @Test
    public void testEmployeeCRUD(){
        //2. 插入员工
        employeeMapper.insertSelective(new Employee(8,"David","M","David@maituan.com",1));
        employeeMapper.insertSelective(new Employee(null,"Ela","M","Ela@maituan.com",2));

        //3.批量插入多个员工：批量，使用可以批量操作的sqlSession.
        EmployeeMapper mapper = sqlSession.getMapper(EmployeeMapper.class);
        for(int i=0;i<1000;i++){
            String uid = UUID.randomUUID().toString().substring(0,5)+i;
            mapper.insert(new Employee(null,uid,"F",uid+"@atguigu.com",1));
        }

    }
}
