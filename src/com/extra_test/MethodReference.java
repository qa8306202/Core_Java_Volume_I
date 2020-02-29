package com.extra_test;


/**
 * In Springboot :
 * 		private Optional<Resource> getWelcomePage() {
 * 			String[] locations = getResourceLocations(this.resourceProperties.getStaticLocations());
 * 			return Arrays.stream(locations).map(this::getIndexHtml).filter(this::isReadable).findFirst();
 *                }
 *
 * 		private Resource getIndexHtml(String location) {
 * 			return this.resourceLoader.getResource(location + "index.html");
 *        }
 * What is MethodReference?
 *  It is Lambda Expression, which is a closure(闭包).It is often used in multithreading and listener.
 *  lambda表达式本质是拿什么参数做什么操作的形式，因为他是一个闭包，因此可以调用外部的变量！
 *      (param1, param2 ...)->{xxx}
 *  lambda表达式使用的必备条件：函数式接口！
 *
 *  **当代码冗余的时候，把匿名内部函数改为lambda表达式可以减少冗余！**
 *  **当lambda冗余的时候，使用方法引用减少冗余**
 *   注意：
 *     1. System.out对象是已经存在的
 *     2. println方法也是存在的
 *     所以我们可以使用方法引用优化lambda表达式
 *  e.g.:
 *
 *  * class::staticMethod
 *  * object::instanceMethod
 *  * class::instanceMethod
 *  * class::new
 *
 */
public class MethodReference {
    private int a;
    /*
        1. 这个方法不能放到static的方法中调用，无论是this.adddo 还是this::adddo
        2.
     */
    private void adddo(String a){
        System.out.println("adddd----" + a);
    }
    // lambda expression for multithreading!
    public static void main(String[] args) {
        printString((methods)->{
            System.out.println();
        },"howareyou");

//        new MethodReference().newThread();
        printString(System.out::println,"howareyou");
    }

    // 一般使用lambda的情况1(内部匿名函数)：
    public void newThread(){
        // 通过内部类实现多进程
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName() + "新线程被创建了");
            }
        }).start();
        // 通过lambda表达式实现多线程
        new Thread(()->{
            System.out.println(Thread.currentThread().getName() + "新线程被创建了");
        });
    }

    // 使用lambda的情况2（方法引用，因为对象和方法都是存在的1）：
    /*
         调用printString方法，方法的参数IPrintable是一个函数式接口，所以可以传递lambda
         分析： lambda表达式的目的，打印参数传递的字符串，
         把参数s传递给了sout对象，调用out中的方法，println对字符串进行了输出
         注意：
            1. System.out对象是已经存在的
            2. println方法也是存在的
           所以我们可以使用方法引用优化lambda表达式：
           printString(System.out::println)
        */
    public static void printString(IPrintable p,String output) {
        p.print(output);
    }

//    // 使用lambda的情况3（this引用）：
//    private



}
