### mysql基本语法

#### 基本查询

- 要查询表中的数据，使用SQL语句。
```sql
SELECT * FROM <表名>
// *代表所有列
```

### 条件查询

- 使用`SELECT * FROM <表名>`可以查询到一张表的所有记录。但是，很多时候，我们并不希望获得所有记录，而是根据条件选择性地获取指定条件的记录，例如，查询分数在`80`分以上的学生记录。在一张表有数百万记录的情况下，获取所有记录不仅费时，还费内存和网络带宽。

```sql
WHERE 条件设定查询条件
SELECT * FROM <表名> WHERE <条件表达式>
SELECT * FROM students WHERE score >= 80 AND gender = 'M';
SELECT * FROM students WHERE score >= 80 OR gender = 'M';
SELECT * FROM students WHERE NOT class_id = 2;// not 不符合

```
### 投影查询

```sql
SELECT 列1, 列2, 列3 FROM <表名>
SELECT id, score, name FROM students;

```

### 排序
```sql
ORDER BY 升序
SELECT id, name, gender, score FROM students ORDER BY score;
DESC 倒叙
SELECT id, name, gender, score FROM students ORDER BY score DESC;

```
### 修改数据
- 当我们需要向数据库表中插入一条新记录时，就必须使用INSERT语句。
```sql
INSERT INTO cdc_test (username,password, score) VALUES('cdc006',23344, 83)
```