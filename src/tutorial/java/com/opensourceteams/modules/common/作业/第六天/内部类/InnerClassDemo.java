package com.opensourceteams.modules.common.作业.第六天.内部类;

/**
 * 开发者:刘文  Email:372065525@qq.com
 * 16/3/1  下午5:20
 * 功能描述:
 */
class Benz{
        private String color = "黑色";
        private int tires;
        Engine engine = new Engine();

    public void run(){
            //Engine engine = new Engine();
            engine.fire();
            System.out.println("运行");
        }

        public int getTires() {
            return tires;
        }

        public void setTires(int tires) {
            this.tires = tires;
        }

        public String getColor() {
            return color;
        }

        public void setColor(String color) {
            this.color = color;
        }

        class Engine{
            private int power;
            public  void fire(){
                System.out.println("点火");
            }
        }
}

class InnerClassDemo {

    public static void main(String[] args) {
        Benz benz = new Benz();

        System.out.println(benz.getColor());
        benz.run();
    }
}
