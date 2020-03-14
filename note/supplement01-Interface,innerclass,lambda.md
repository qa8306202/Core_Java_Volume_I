## 补充：接口，内部类，lambda表达式
### 前言：前面的txt文件代表的阅读了第一次关于*Core Java Volumne I*。而这次的补充是在我阅读源码过程中对这这一部分的深入理解，这个部分会随着我对java的理解而更新，变化。
* 格式：时间，内容标题，内容

## 2020-02-29
### Interface, lambda expression and innerclass is a whole!
**如果类遵循某个特定接口，那么履行这项服务**

~~**到底什么是接口，什么又是服务？他们有什么相同点，又有什么不同点？**~~
1. 刚读*Core Java Volumne I*对这句话的理解十分浅显，就是**如果存在一个接口，那么必定存在至少一个对应这个接口的实现类**。
2. 在学习了lambda表达式后，发现一个接口可以是一个函数式接口``@FunctionalInterface``,我们不需要任何的实现类和实现类方法，仅仅通过调用别的方法
3. 在学习了mybatis之后发现，对于一个接口可以不编写任何的实现类，但是就能返回接口的实例————通过**动态代理**接管了接口。
4. 在接口中写内部类

#### 函数式接口(lambda + interface):匿名函数和方法引用
1. 写一个``@FunctionalInterface``接口。
```java
    @FunctionalInterface
    public interface IPrintable {
        // define one abstract method
        void print(String s);
    }
```

2. 通过一个方法(printString)包装接口，这个方法的参数就是该函数式接口
```java 
    public static void printString(IPrintable p,String output) {
        p.print(output);
    }
```
3. 在使用这个接口的时候对上面包装的方法（printString）使用**lambda表达式**进行重写
* 注意：使用labmda函数重写方法的前提是实现的接口中有且仅有一个需要重写的抽象方法。
```java 
    printString((s)->{
        System.out.println(s);
    },"lambda表达式");
```

4. 或在使用这个接口的时候对上面包装的方法（printString）使用**方法引用**的方式进行重写
* 注意：1. System.out对象是已经存在的; 2. println方法也是存在的才可以直接用。
```java 
    printString(System.out::println,"howareyou");
```

* 总结：在写lambda表达式必须带上形参（如上面的s），而方法引用不需要形参
#### 接口和内部类
```java
interface Stack 
{	public void push(Object o);
	public Object pop();
	public Object top();
	public boolean empty();
	public boolean full();

	public class Dense implements Stack
	{	public Dense (int n)
		{	imp = new Object[n];
			capacity = n;
		}

		public void push(Object o)
		{	imp[size++] = o;
		}
		//...
		private Object []  imp; // Array implementation
		private int size = 0;
		private int capacity = 0;
	}

	public class Linked implements Stack
	{	public Linked (){}

		public void push(Object o)
		{	head = new Node(o, head);
		}
		//...
		private Node head = null; // Linked list

		private class Node
		{	public Node(Object val, Node nextNode)
			{	value = val;
				next = nextNode;
			}
			//...
			private Object value;
			private Node next;
		}
	}

}
```

#### 以springboot中的方法为例
在``WebMvcAutoConfiguration``中
```java
public static class WebMvcAutoConfigurationAdapter implements WebMvcConfigurer {
    // ...
    public void configureContentNegotiation(ContentNegotiationConfigurer configurer) {
        WebMvcProperties.Contentnegotiation contentnegotiation = this.mvcProperties.getContentnegotiation();
        configurer.favorPathExtension(contentnegotiation.isFavorPathExtension());
        configurer.favorParameter(contentnegotiation.isFavorParameter());
        if (contentnegotiation.getParameterName() != null) {
            configurer.parameterName(contentnegotiation.getParameterName());
        }
        Map<String, MediaType> mediaTypes = this.mvcProperties.getContentnegotiation().getMediaTypes();
        // 存在一个方法引用configurer是ContentNegotiationConfigurer类的
        mediaTypes.forEach(configurer::mediaType);
    }
}
```
在这个类中的方法是这样的：
* 其中``mediaTypes``是``LinkedHashMap<>()``

* ``Map``接口的``foreach``使用了常用函数式接口``BiConsumer<T,U,R>``参数类型T,U，返回类型R。

* ``BiConsumer<? super K, ? super V> action``中？表示通配符，通配符有extends bound 和 super bound两种

* 首先是：<? extends T> 既然是extends，就是表示泛型参数类型的上界，说明参数的类型应该是T或者T的子类。
   * 编译器只知道需要某个 T 的子类型，但不知道具体是什么类型。它拒绝传递任何特定的类型。毕竟？不能用来匹配。
   * 希望只取出，不插入，就使用``? extends``
   * 所以用泛型可以写出来一个安全的访问器

* 然后是：``BiConsumer<? super K, ? super V>``表示任何泛型BiConsumer类型，因为修饰符是super所以它的类型参数的超类型限定（super bound，下界）是K和V，一直到object。
   * 
* 为什么要这样做呢？ 带有超类型限定的通配符的行为与 8.8 节介绍的相反。可以为方法提供参数， 但不能使用返回值。K和V是？是超类，那么超类可以代表参数

* 下面参数T就可以用``? super K``的K表示，同理U可以用V表示。

* 参考：核心技术330页

* 注意：下面的方法实现是在接口中的，实际上，应该在实现类中的才是真正的“实现”，下面的``entrySet``相当于``ArrayList``中的``DataElement``或者``HashMap``中的``table
``（这些类的底层都是通过数组实现的，而且被修饰了 transient   关键字而不会在默认的序列化函数中存储到文件中。）
```java
public interface Map<K, V> {
    default void forEach(BiConsumer<? super K, ? super V> action) {
        Objects.requireNonNull(action);
        for (Map.Entry<K, V> entry : entrySet()) {
            K k;
            V v;
            try {
                k = entry.getKey();
                v = entry.getValue();
            } catch (IllegalStateException ise) {
                // this usually means the entry is no longer in the map.
                throw new ConcurrentModi ficationException(ise);
            }
            action.accept(k, v);
        }
    }
}
```
上面的``action``就是指的下面这个方法引用：
```java
public class ContentNegotiationConfigurer {
	public ContentNegotiationConfigurer mediaType(String extension, MediaType mediaType) {
		this.mediaTypes.put(extension, mediaType);
		return this;
	}
}
```
#### stream流
* stream操作有两个基础特征：
   1. pipelining：中间操作都会返回流对象本身，这样多个操作可以串联成一个管道，如同流式风格。这样做可以对操作进行优化，比如延迟执行和短路。
   2. 内部迭代：以前对集合遍历都是通过iterator或者增加for的方法，显式的在集合外部进行迭代，这叫做外部迭代。stream提供了内部迭代的方式，流可以直接调用遍历方法。
   3. stream流属于管道流，只能被消费使用一次，第一个stream流调用完毕方法，数据就会转移到下一个stream上，而这时第一个stream流已经使用完毕，就会关闭了，所以第一个
1. 获取流stream
   * 把集合Collection转化为stream流，比如``Stream<String> stream1 = list.stream()``
2. 常用方法
   * 延迟方法：返回值任然是``Stream``接口自身类型的方法，支持链式调用。（除了终结方法外，其余方法均为延迟方法）
   * 终结方法：返回值类型不再是``Stream``接口自身类型的方法，因此不再支持类似``StringBuilder``那样的链式调用。终结方法包括``forEach``和``count``方法。
3. filter方法（延迟方法）
   ```java 
        Stream<String> stream1 = list.stream();
        Stream<String> stream2 = Stream.filter((name)->{return name.startwith(name);});         
   ```
4. map方法传入的是Function接口（函数接口）（延迟方法）
   ```java 
    Stream<String> stream2 = Stream.map((name)->{return Integer.parseInt(name);});  
   ```
5. count统计个数（是一个终结方法!）
6. limit对流中的元素进行截取，获取前几个。是一个延迟方法
7. skip跳过几个，是一个延迟方法
8. concat组合方法，将两个流合并成一个新的流。是一个静态方法。和String的concat不一样。
## 2020-03-14
### innerClass
内部类在大量的源码中出现，尤其是springboot，因为应该学会使用内部类，从以下三个层次去考虑：
* 什么是内部类，为什么要有内部类？
* 内部类有哪几种？
* 如何定义内部类？——从hashMap理解内部类
* 内部类的反射原理
#### 什么是，为什么
* 简单来讲内部类就是在一个类里面定义定外一个类，他属于一个残缺的闭包。之所以要定义这个类是因为：更好的封装性。
    * 内部类方法可以访问该类定义所在的作用域中的数据，包括私有数据。
    * 内部类可以对同一个包中的其他类隐藏起来。
    * 当想要定义一个回调函数且不想编写大量代码时，使用匿名（anonymous）内部类比较便捷。
    * 仿造C++的嵌套类，但是比嵌套类更加丰富。
#### 内部类有哪几种
* 内部类：属于这个类，就是上面讲的定义在一个类面的类。
* 局部内部类：定义在某个类的具体方法里面。 
* 匿名内部类：只创建这个内部类的一个对象。这个对象是某个结构实现类的对象，也可以说是一个类的扩展类。
* 静态内部类：简而言之，外部类就不用实例化这个内部类，也就是说内部类不再属于外部类的某个对象了。
    * 静态内部类的一个用法：当某个方法需要返回多个类型的变量时候，但是java需要新定义一个类用来包含这些返回变量。这个时候就可以使用静态内部类。
#### 如何定义内部类？
* 内部类：就是属于类A的内部类B，并且这个内部类B有时候需要提供给别人使用（不完全封装）。比如HashMap的KeySet
* 局部内部类：经常用于实现监听接口，用于异步操作。
* 匿名内部类：也常用于异步通信，可能在JS中更加常见。
* 静态内部类：属于类A的内部类，属于整个类，而不是属于类的某个实例！比如HashMap的Node

#### 内部类的反射原理
* 记住：内部类翻译成$分隔外部类名与内部类名的常规类文件，而虚拟机对此一无所知。

  