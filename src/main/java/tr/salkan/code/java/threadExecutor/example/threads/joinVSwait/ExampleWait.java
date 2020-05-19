package tr.salkan.code.java.threadExecutor.example.threads.joinVSwait;

public class ExampleWait {

    public static void main(String args[])
    {
        final Pocket pocket = new Pocket();

        new Thread() {
            @Override
            public void run()
            {
                pocket.payToSomething(15000);
            }
        }.start();
        new Thread() {
            @Override
            public void run()
            {
                pocket.getMoneyFromBank(11000);
            }
        }.start();
    }

}

class Pocket
{
    //money in your pocket
    int amountMoney = 4000;

    synchronized void payToSomething(int price)
    {
        System.out.println("payToSomething...");


        if (this.amountMoney < price) {

            System.out.println("Price is bigger than your money. You get money from ATM");
            try {
                wait();
            }
            catch (Exception e) {
            }
        }

        System.out.println("After get money from ATM and pocket total money :" + this.amountMoney);

        this.amountMoney = amountMoney - price;
        System.out.println("after buying something left your money in your pocket : " + amountMoney);
    }

    synchronized void getMoneyFromBank(int getMoney)
    {
        System.out.println("money in your pocket : " + this.amountMoney);
        this.amountMoney = amountMoney + getMoney;
        System.out.println("after get money from bank  :  " + amountMoney);
        notify();
    }

}

