package sp.statsplayer.StatsPlayer.model;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="stats")
public class Stats {
    @Id
    private String uuid;
    private int zombie;
    private int creeper;
    private int skeleton;

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public int getZombie() {
        return zombie;
    }

    public void setZombie(int zombie) {
        this.zombie = zombie;
    }

    public int getCreeper() {
        return creeper;
    }

    public void setCreeper(int creeper) {
        this.creeper = creeper;
    }

    public int getSkeleton() {
        return skeleton;
    }

    public void setSkeleton(int skeleton) {
        this.skeleton = skeleton;
    }
}
