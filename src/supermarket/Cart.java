package supermarket;

import java.util.ArrayList;

class Cart {
    private final ArrayList<Commodity> commodities = new ArrayList<>();
    private double total_price = 0;

    //向购物车内添加商品
    public boolean add_commodity(String name,double num,Manager manager){
        Goods good = manager.search_good(name);
        if (good != null){
            boolean or = add_ext_commodity(good, num);
            return or;
        }
        else{
            System.out.println("此商品不存在于仓库中");
            return false;
        }
    }

    //向购物车内添加存在的商品
    private boolean add_ext_commodity(Goods good,double num){
        double temp_money = good.put(num);//已进行放入测试

        if  (temp_money != 0.0){

            String name = good.get_name();

            //查找购物车内是否有同名商品
            Commodity obj = sreach_same_name_commodity(name);
            if(obj != null){
                obj.up_num(num);
            }
            else{
                //不同名商品
                //创建购买的商品然后放进购物车
                Commodity com = new Commodity(good.get_id(),name,good.get_price(),num);
                commodities.add(com);
            }
            
            total_price += temp_money;//向总价格中添加商品的价格
            return true;
        }
        return false;
    }

    //向购物车内拿出同名或同id的商品
    public boolean out_commodity(String name,double num){
        Commodity obj = sreach_same_name_commodity(name);

        if (obj != null){
            double temp_money = obj.out(num);//进行拿出测试
            if (temp_money == 0.0){
                return false;
            }
            total_price += temp_money;
            return true;
        }
        System.out.println("未放入此商品");
        return false;
    }

    //计算购物车内的商品总价格
    public void calculate_total_price(){
        this.total_price = 0;
        for (Commodity com : commodities) {
            total_price += com.get_num()*com.get_price();
        }
    }
    
    //展示购物车内的所有商品名称，单价，数量，该商品总价，以及总价
    public void show_all(){
        for (Commodity com : commodities) {
            String name = com.get_name();
            double price = com.get_price();
            double num = com.get_num();
            double all_price = price * num;
            System.out.println(name+" 单价："+price+" 共"+num+"件 "+all_price+"元");
        }
        System.out.println("合计：" + total_price + "元" );
    }

    //寻找购物车内同名或同id商品
    private Commodity sreach_same_name_commodity(String name){
        for (Commodity com : commodities) {
                if(com.get_name().equals(name) || com.get_id().equals(name)){
                    return com;
                }
            }
        return null;
    }
}
