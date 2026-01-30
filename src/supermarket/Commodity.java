package supermarket;

public class Commodity {
    private final String id;
    private final String name;
    private final double price;
    private double num;

    public Commodity(String id,String name,double price,double num) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.num = num;
    }

    public String get_id(){
        return this.id;
    }

    public String get_name(){
        return this.name;
    }

    public double get_price(){
        return this.price;
    }

    public double get_num(){
        return this.num;
    }

    public void up_num(double num){
        this.num += num;
    }

    public void down_num(double num){
        this.num -= num;
    }

    //当商品被拿出购物车时运行此函数，注意返回值为负数
    public double out(double out_num){
        if(out_num <= 0){
            System.out.println("不能拿出0个及以下");
            return 0.0;
        }
        else if(this.num - out_num < 0){
            System.out.println("拿出太多了");
            return 0.0;
        }
        else {
            //计算返还多少钱，注意为负数
            double get_money = this.price * out_num;
            down_num(num);
            return -get_money;
        }
        
    }

}