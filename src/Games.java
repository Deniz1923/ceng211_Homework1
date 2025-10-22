public class Games {
    /*
    ID,GameName,BasePointPerRound
    1,Valorant,12
    2,League of Legends,15
    3,CS2,18
    4,Overwatch,10
    5,Fortnite,9
    6,PUBG,14
    7,Apex Legends,16
    8,Dota2,17
    9,Rocket League,11
    10,Call of Duty,13
    */

    private int id;
    private String name;
    private int pointPerPound;

    public Games(int id,String name, int pointPerPound){
        this.id = id;
        this.name = name;
        this.pointPerPound = pointPerPound;
    }

    public int getId(){
        return id;
    }

    public String getName(){
        return name;
    }
    public int getPointPerPound(){
        return pointPerPound;
    }

}
