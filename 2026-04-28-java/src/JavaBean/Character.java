package JavaBean;

//角色父类,写共有属性和共有方法
public class Character {
    private String name;
    private int Hp;
    private int attack;
    private int defense;
    private int maxHp;

    public Character() {
    }

    //不需要把maxhp也赋值,因为最开始hp就为maxhp
    public Character(int attack, int defense, int hp, String name) {
        this.attack = attack;
        this.defense = defense;
        this.Hp = hp;
        maxHp = hp;
        this.name = name;
    }

    public int getAttack() {
        return attack;
    }

    public void setAttack(int attack) {
        this.attack = attack;
    }

    public int getDefense() {
        return defense;
    }

    public void setDefense(int defense) {
        this.defense = defense;
    }

    public int getHp() {
        return Hp;
    }

    public void setHp(int hp) {
        Hp = hp;
    }

    public int getMaxHp() {
        return maxHp;
    }

    public void setMaxHp(int maxHp) {
        this.maxHp = maxHp;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    //各种行为

    //  1.判断血量
    public boolean isAlive() {
        return Hp > 0;    //>0即存活
    }

    //  2.回复血量
    public int heal(int healing) {  //这里要使用非静态方法,因为是对象实例
        if (healing + getHp() > getMaxHp()) {
            return getMaxHp();
        } else {
            return getHp() + healing;
        }
    }

    //  3.受到攻击
    public int TakeAttack(int attack) {
        setHp(getHp() - attack);
        if (getHp() < 0) {
            return 0;
        } else {
            return getHp();
        }
    }   //玩家英雄直接调用,敌人要重写,因为有一个判断减伤状态的方法

    //  4.展示角色信息
    public void show() {
        System.out.println("角色名称: " + getName() + "  当前血量: " + getHp() + "  攻击力: " + getAttack() + "  防御力: " + getDefense());
    }
}
