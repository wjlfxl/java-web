package demo06Synchronized;

//不安全的买票
public class UnsafeBuyBank {
    public static void main(String[] args) {
        Account account=new Account(100,"结婚基金");
        Bank you=new Bank(account,50,"你");
        Bank wife=new Bank(account,100,"妻子");

        you.start();
        wife.start();

    }
}

//账户
class Account{
    int money ;
    String name;

    public Account(int money, String name) {
        this.money = money;
        this.name = name;
    }
}

//银行
class Bank extends Thread{
    Account account;//账户
    int drawingMoney;//取了多少钱
    int nowMoney;//还有多少钱

    public Bank(Account account, int drawingMoney, String name) {
        super(name);
        this.account = account;
        this.drawingMoney = drawingMoney;
    }

    @Override
    public void run() {
        //判断有没有钱
        if(account.money-drawingMoney<0){
            System.out.println(Thread.currentThread().getName()+"钱不够，取不了");
            return;
        }
        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //卡内余额
        account.money=account.money-drawingMoney;
//        手里的钱
        nowMoney=nowMoney + drawingMoney;

        System.out.println(account.name+"里有"+account.money);
        System.out.println(Thread.currentThread().getName()+"手有"+nowMoney);

    }
}
