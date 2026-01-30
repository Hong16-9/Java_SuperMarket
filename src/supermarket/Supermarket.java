package supermarket;

import java.util.Scanner;

public class Supermarket {
    public static void main(String[] args) throws Exception {
        Manager manager = new Manager();
        manager.add_good("Linger", "林杰", 250, 4);

        Cart cart = new Cart();

        boolean done = false;

        System.out.println("欢迎使用超市系统");
        System.out.println("1.查看商品");
        System.out.println("2.放入商品");
        System.out.println("3.拿出商品");
        System.out.println("4.完成购买");

        Scanner sc = new Scanner(System.in);

        while (true) {

            int option = sc.nextInt();

            switch (option) {
                case 1 -> manager.show_all();

                case 2 -> {
                    System.out.println("请输入购买商品的名称或id:");
                    String name_put = sc.next();
                    System.out.println("请输入购买商品的数量:");
                    double num_put = sc.nextDouble();

                    if(cart.add_commodity(name_put, num_put, manager)){
                        System.out.println("购买成功，现在购物车内有：");
                        cart.show_all();
                    }
                    else{
                        System.out.println("放入失败！");
                    }
                }

                case 3 -> {
                    System.out.println("请输入拿出商品的名称或id:");
                    String name_out = sc.next();
                    System.out.println("请输入拿出商品的数量:");
                    double num_out = sc.nextDouble();

                    if(cart.out_commodity(name_out, num_out)){
                        System.out.println("拿出成功，现在购物车内有：");
                        cart.show_all();
                    }
                    else{
                        System.out.println("拿出失败！");
                    }
                }

                case 4 -> done = true;

                default -> System.out.println("请输入有效数字");
            }
            
            if(done){
                sc.close();
                break;
            }
        }
        
    }
}
