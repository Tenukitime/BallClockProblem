package main;

public class Ball implements IBall {
    protected int id;

    public Ball(int id) {
        this.id = id;
    }


    @Override
    public void setId(int id) {
        this.id = id;
    }

    @Override
    public int getId() {
        return id;
    }
}
