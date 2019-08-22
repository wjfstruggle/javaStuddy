### JDBC 

JDBC ： java Database connectity java语言操作数据库

JDBC 定义了操作所有关系型数据库的规则(接口)。提供数据库驱动jar包，
正真执行的代码是驱动jar的实现类。

步骤： 
1、导入驱动jar包
2、注册驱动
3、获取数据库连接对象
4、定义SQL
5、获取执行SQL语句对象的Statement
6、执行SQL语句、接收返回结果
7、处理结果
8、释放资源