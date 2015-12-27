import java.util.ArrayList;
import java.util.List;

/**
 * Created by yejia_alice on 15/12/27.
 */
public class CashFlow {

    public static void main(String[] args) {
//        初始余额100元
        Cash cash = new Cash(100);
//        开始存款线程
        new Deposit(cash).start();
//        开始取款线程
        new Withdraw(cash).start();
    }
}

/**
 * 现金账户
 * cash: 余额
 * count: 流水计数
 * record: 流水记账
 */
class Cash {
    int cash;
    int count;
    List<String> record;

    public Cash(int cash) {
        this.cash = cash;
        this.count = 0;
        record = new ArrayList<String>();
    }

    //    存款操作
    public void deposit() {
//        同步对象锁
        synchronized (this) {
            cash++;
            count++;
            record.add("向账户存了1元，账户还有" + cash + "元");

//            10个一批输出流水
            if (count % 10 == 0) {
                output();
            }
//            通知其他线程对象可用
            notifyAll();
        }
    }

    // 取款操作
    public void withdraw() {
        //        同步对象锁
        synchronized (this) {
            try {
//                等待通知
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            if (cash > 0) {
                cash--;
                count++;
                record.add("向账户取了1元，账户还有" + cash + "元");
            }

            //            10个一批输出流水
            if (count % 10 == 0) {
                output();
            }
        }
    }

    //    输出流水
    public void output() {
        System.out.println("==========================================");
        for (int i = record.size() - 10; i < record.size(); i++) {
            System.out.println("第" + (i + 1) + "次操作 | " + record.get(i));
        }
//        System.out.println("第"+count+"次操作 | "+record.get(record.size()-1));
    }
}

//存款线程
class Deposit extends Thread {
    Cash cash;

    public Deposit(Cash cash) {
        this.cash = cash;
    }

    //    总流水1000次
    @Override
    public void run() {
        while (cash.count < 999) {
            cash.deposit();
        }
    }
}

//取款线程
class Withdraw extends Thread {
    Cash cash;

    public Withdraw(Cash cash) {
        this.cash = cash;
    }

    //    总流水1000次
    @Override
    public void run() {
        while (cash.count < 999) {
            cash.withdraw();
        }
    }
}