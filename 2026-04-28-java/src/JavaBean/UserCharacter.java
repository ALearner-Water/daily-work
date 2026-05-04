package JavaBean;

import java.util.ArrayList;

//玩家自身英雄
public class UserCharacter extends Character {
    //自身英雄的技能有多个需要用集合存放
    private ArrayList<String> skills;

    //直接把对象创建出来
    public UserCharacter() {
        skills = new ArrayList<String>();
    }

    public UserCharacter(int attack, int defense, int hp, String name) {
        super(attack, defense, hp, name);
        skills = new ArrayList<String>();
    }

    public ArrayList<String> getSkills() {
        return skills;
    }

    public void setSkills(ArrayList<String> skills) {
        this.skills = skills;
    }

}
