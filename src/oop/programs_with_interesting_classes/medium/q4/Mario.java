package oop.programs_with_interesting_classes.medium.q4;

public class Mario {
    private int jumpHeight;
    private boolean activePowerUp;
    private boolean isDead;

    public Mario() {
        jumpHeight = 1;
        activePowerUp = false;
        isDead = false;
    }

    public Mario(int jumpHeight, boolean activePowerUp, boolean isDead) {
        this.jumpHeight = jumpHeight;
        this.activePowerUp = activePowerUp;
        this.isDead = isDead;
    }

    public int jump() {
        return jumpHeight;
    }

    public void eatPowerUp() {
        activePowerUp = true;
        jumpHeight = jumpHeight + 5;
    }

    public void takeDamage() {
        if (activePowerUp) {
            activePowerUp = false;
            jumpHeight = jumpHeight - 5;
        } else {
            isDead = true;
            jumpHeight = 0;
        }
    }

    public String toString() {
        String out = "I can jump " + jumpHeight + " units high, my power up state is " + activePowerUp;
        if (isDead)
            out = out + ", and I am dead.";
        else
            out = out + ", and I am still alive.";
        return out;
    }
}
