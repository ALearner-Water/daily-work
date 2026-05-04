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

    public UserCharacter(int hp, int attack, int defense, String name) {
        super(attack, defense, hp, name);
        skills = new ArrayList<String>();
    }

    public ArrayList<String> getSkills() {
        return skills;
    }

    public void setSkills(ArrayList<String> list) {
        this.skills = skills;
    }

    //写一个展示技能的show方法
    public String showSkills(){
        //使用stringbuilder进行拼接
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < getSkills().size(); i++) {
            sb.append(getSkills().get(i));
            if(i!=getSkills().size()-1){
                sb.append(", ");
            }
        }
        return sb.toString();
    }
}
