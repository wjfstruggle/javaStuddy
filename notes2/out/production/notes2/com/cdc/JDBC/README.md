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
    
    - 练习：添加一条记录
    
- PreparedStatement 执行SQL对象

    解决SQL注入的问题: 使用PreparedStatement来解决
    
    预编译的SQL语句，参数使用占位符
    
    步骤： 
    * 1、导入驱动jar包
    * 2、注册驱动
    * 3、获取数据库连接对象
    * 4、定义SQL
        - 注意： SQL语句的参数使用，使用 ？作为占位符。如：select * from user where username=？ and password=？
    * 5、获取执行SQL语句对象的PreparedStatement
        - Connection.prepareStatement(String sql) 
    * 6  给 ？ 赋值
        - 方法：setXxx(参数1，参数2);参数1 ？ 的位置，从1开始，参数2，？的值。
    * 7、执行SQL语句、接收返回结果，不需要传递SQL语句
    * 8、处理结果
    * 9、释放资源
    
- ResultSet 结果集对象 封装查询结果

    - 方法： 
    
         boolean next() 将光标从当前位置向前移动一行。 
          
         getxxx() 获取数据， xxx数据类型 如 int getInt() String getString()
         
         1、int 代表列的编号，从 1 开始，如 getString(1)
         2、String代表列名称；如 getDouble("balance")
         
### 抽取JDBC工具类

* 目的： 简化简写
* 分析： 

    1、注册驱动也抽取
    
    2、抽取一个方法获取连接对象
    
        * 需求： 不想传递参数，保证工具类的通用性
        * 解决： 配置文件
        
        
    3、抽取一个方法释放资源