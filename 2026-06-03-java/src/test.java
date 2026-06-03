public class test {
    public static void main(String[] args){
        SellTicket st1 = new SellTicket("窗口一");
        SellTicket st2 = new SellTicket("窗口二");
        SellTicket st3 = new SellTicket("窗口三");
        st1.start();
        st2.start();
        st3.start();
    }
}
