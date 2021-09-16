package 测试包;
/*
    测试反编译工具jclasslib
 */
public class jclasslib {
    private final int a=1;
    private final double b=1.1;
    private final float c=1.11f;
    private final String d="abc";
    private int e=2;
    private String f="abcde";
    public void test01(String prefix){
        System.out.println(prefix+":"+a);
    }
    public String test02(){
        test01("001");
        return "success";
    }
}
