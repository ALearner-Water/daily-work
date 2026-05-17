import javax.swing.*;

public class SwingJMenu {
    public static void main(String[] args) {
        //先创建窗体然后才有菜单
        JFrame game = new JFrame("游戏");
        game.setSize(603, 602);
        game.setLocationRelativeTo(null);
        //设置窗体关闭方式
        game.setDefaultCloseOperation(3);
        //初始化菜单
        //1.先创建一整个菜单对象
        JMenuBar jmenubar = new JMenuBar();

        //2.创建菜单上面的两个选项
        JMenu jmenu1 = new JMenu("功能");   //调用有参构造
        JMenu jmenu2 = new JMenu("关于我们");

        //3.创建选项条目
        JMenuItem item1 = new JMenuItem("重新开始");
        JMenuItem item2 = new JMenuItem("关闭游戏");

        JMenuItem item3 = new JMenuItem("公众号");

        //组合对象使用jmenubar和jmenu的对象add()
        jmenu1.add(item1);
        jmenu1.add(item2);
        jmenu2.add(item3);
        jmenubar.add(jmenu1);
        jmenubar.add(jmenu2);

        //组合完毕之后再将菜单放入窗口
        game.setJMenuBar(jmenubar);     //新版不需要先调用container方法,普通添加组件直接add即可

        //展示窗口
        game.setVisible(true);
    }
}
