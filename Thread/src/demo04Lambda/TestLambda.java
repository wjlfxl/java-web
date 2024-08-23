package demo04Lambda;

public class TestLambda {
    public static void main(String[] args) {
        ILike like=new Like();
        like=()->{System.out.println("I Like Lambda2");};
       like.lambda();

    }
}

interface ILike{
    void lambda();
//    abstract void lambda();
}

class Like implements ILike{
    @Override
    public void lambda() {
        System.out.println("I Like");
    }
}