

public class Player {
// Definition of values
    private String name;
    private int hp = 100;
    private int energy = 100;


    public void lowKick (Player target){
        target.decreseHp(10);
        this.energy -= 10;
    }
    public void bodyKick (Player target){
        target.decreseHp(20);
        this.energy -= 20;
    }
    public void highKick (Player target){
        target.decreseHp(40);
        this.energy -= 40;
    }
    public void defence (){
        this.hp += 15;
        if (this.hp >= 100){
            this.hp = 100;
        }
        this.energy -= 30;
    }

    // GETTERS
    public String getName() {
        return name;
    }

    public int getHp() {
        return this.hp;
    }

    public int getEnergy() {
        return energy;
    }
    // Setters
    public void setName(String name) {
        this.name = name;
    }
    public void setHp(int hp) {
        this.hp = hp;
    }

    // regular method
    public void decreseHp (int damage){
        this.hp -= damage;
    }
    public void increaseEnergy(int amount){
        this.energy += amount;
        if(this.energy >= 100){
            this.energy = 100;
        }
    }


}
