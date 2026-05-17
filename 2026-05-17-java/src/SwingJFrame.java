import javax.swing.*;

public class SwingJFrame {
    public static void main(String[] args){
        //创建窗口(jframe)
        JFrame game=new JFrame("游戏");   //创建一个窗口默认不可见   可以设置窗体标题
        game.setSize(603,602);  //设置窗口大小
        //game.setLocation(500,200);  //设置窗体在屏幕的坐标    可以用setbound一口气设置完毕
        game.setLocationRelativeTo(null);   //这个直接可以让窗体居中,就不需要设置坐标
        //设置窗体关闭方式
        game.setDefaultCloseOperation(3);   //设置关闭窗体直接停止运行,数字代表关闭方式,也可以用接口直接调用
        game.setVisible(true);  //将窗口设成可见的
    }
}
