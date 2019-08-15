## java反射

### 访问字段

- Field getField(name)：根据字段名获取某个public的field（包括父类）
- Field getDeclaredField(name)：根据字段名获取当前类的某个field（不包括父类）
- Field[] getFields()：获取所有public的field（包括父类）
- Field[] getDeclaredFields()：获取当前类的所有field（不包括父类）

### 一个Field对象包含了一个字段的所有信息：

- getName()：返回字段名称，例如，"name"；
- getType()：返回字段类型，也是一个Class实例，例如，String.class；
- getModifiers()：返回字段的修饰符，它是一个int，不同的bit表示不同的含义。