package JavaBean;

//敌人类
public class EnemyCharacter extends Character {
    private String skill;
    boolean defending;

    public EnemyCharacter(int attack, int defense, int hp, String name, String skill) {
        super(attack, defense, hp, name);
        this.skill = skill;
    }

    public EnemyCharacter() {
        super();
    }

    @Override
    public int TakeAttack(int attack) { //有一个判断减伤状态的方法所以需要重写
        if (defending) {
            //减伤
            attack = attack / 2;
            if (attack <= 1) {
                attack = 1;
            }
            defending = false;    //重置状态
        }
        //计算好伤害后就扣血
        return super.TakeAttack(attack);    //直接调用父类方法
    }
}
