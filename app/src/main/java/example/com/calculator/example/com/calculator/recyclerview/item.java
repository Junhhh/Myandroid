package example.com.calculator.example.com.calculator.recyclerview;

/**
 * Created by 钱俊华 on 2018/7/16 0016.
 */

public class item {
    private String Name;
    private int imageId;

    public item(String Name,int imageId){
        this.Name = Name;
        this.imageId = imageId;
    }
    public String getName(){
        return Name;
    }
    public int getImageId(){
        return imageId;
    }
}
