### JDBC 

JDBC ： java Database connectity java语言操作数据库

JDBC 定义了操作所有关系型数据库的规则(接口)。提供数据库驱动jar包，
正真执行的代码是驱动jar的实现类。

步骤： 
* 1、导入驱动jar包
* 2、注册驱动
* 3、获取数据库连接对象
* 4、定义SQL
* 5、获取执行SQL语句对象的Statement
* 6、执行SQL语句、接收返回结果
* 7、处理结果
* 8、释放资源

各个对象的详解：
- DriverManager 驱动管理对象
  ####  功能
  
* 1、注册驱动：`static void registerDriver(Driver driver) `注册与给定的驱动程序 `DriverManager` 。  告诉驱动应该使用哪个数据库
    * 使用方式： `Class.forName("com.mysql.cj.jdbc.Driver");`
* 2、获取连接
`static Connection getConnection(String url, String user, String password)  `

- Connection 数据库连接对象
    - 1、获取执行SQL的对象
        - `Statement createStatement()  `
        `PreparedStatement prepareStatement(String sql) `` 
    - 2 管理事务
        - 开启事务 `void setAutoCommit(boolean autoCommit)  `
        - 提交事务 `void commit()  `
        - 回滚事务 `void rollback()  `
- Statement 执行SQL对象
    - `boolean execute(String sql)`   可以执行任意的SQL语句
    - `int executeUpdate(String sql)`  执行给定的SQL语句，这可能是 MDL语句; INSERT ， UPDATE ，或 DELETE语句，或者不返回任何内容，如SQL DDL语句的SQL语句。 
        - 返回值：影响的行数，可以通过影响的行数来判断DML语句是否执行成功，> 0 则表示成功。
    - `ResultSet executeQuery(String sql)  `执行select语句
    
    
- PreparedStatement 执行SQL对象
- ResultSet 结果集对象