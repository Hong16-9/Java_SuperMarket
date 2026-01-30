package supermarket;

class Goods {
    private String id;
    private String name;
    private double price;
    private double num;

    public Goods(String id,String name,double price,double num) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.num = num;
    }

    public void change_id(String id){
        this.id = id;
    }

    public void change_name(String name){
        this.name = name;
    }

    public void change_price(double price){
        this.price = price;
    }

    public void change_num(double num){
        this.num = num;
    }
    
    //当商品被放入购物车时运行此函数
    public double put(double put_num){
        if(put_num <= 0.0){
            System.out.println("不能添加0及以下");
            return 0.0;
        }

        else{
            //计算放入商品的价格
            double get_money = this.price * put_num;
            num -= put_num;//先减

            if(num < 0){//小于0说明出事了
                System.out.println("商品缺货");
                num += put_num;//再加回来
                return 0.00;
            }
            else{
                return get_money;
            }  
        }
        
    }

    //当商品被拿出购物车时运行此函数，注意返回值为负数
    public void out(double out_num){
        num += out_num;
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
}
