package demo04Lambda;

public class TestLambda2 {

    public static void main(String[] args) {
        ILove love=null;
//        love=heat-> System.out.println("I Love you ->"+heat);
//        love.love(520);
        //总结:
        //lambda表达式只能有一行代码的情况下才能简化成为-行，如果有多行，那么就用代码块包裹。
        love=heat-> {
            System.out.println("I Love you ->"+heat);
            System.out.println("I Love myself ->"+heat);
        };
        love.love(520);

        // 前提是接口为函数式接口
        //多个参数也可以去掉参数类型，要去掉就都去掉,必须加上括号，
//        love=(heat,people)-> System.out.println("I Love you ->"+heat);
    }
}

interface ILove{
    void love(int heat);
//    abstract void lambda();
}
