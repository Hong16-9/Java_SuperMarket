package supermarket;

import java.util.ArrayList;

class Manager {
    private final ArrayList<Goods> all_goods = new ArrayList<>();

    //向仓库中添加商品
    void add_good(String id,String name,double price,double num){
        Goods good = new Goods(id,name,price,num);
        all_goods.add(good);
    }

    //在仓库中查找同名或同id商品
    Goods search_good(String name)
    {
        for (Goods good : all_goods) {
            if(good.get_name().equals(name) || good.get_id().equals(name)){
                return good;
            }
        }

        return null;
    }

    void show_all(){
        for (Goods good : all_goods) {
            String id = good.get_id();
            String name = good.get_name();
            double price = good.get_price();
            double num = good.get_num();

            System.out.println(id +" "+ name + " 单价:" + price +"剩余："+num);
        }
    }
}
