package com.opensourceteams.modeles.common.作业.day5.接口;

/**
 * 开发者:刘文  Email:372065525@qq.com
 * 16/3/1  上午4:42
 * 功能描述:
 定义接口
 1.IWhite
 2.IRich
 3.IBeanti
 4.定义类，实现以上三个接口.(WomenStar)
 5.定义土豪类(EarchRicher.marring(...))
 */

interface IWhite{
    public void white();

}
interface IRich{
    public void rich();
}
interface IBeanti{
    public void beanti();
}

interface IDriver{
    void drive();
}

/**
 * 接口集成
 */
interface IWRB extends IWhite,IRich,IBeanti{
}

class WomenStar implements  IWRB{


    public void white() {
        System.out.println("白");
    }
    public void rich() {
        System.out.println("富");
    }
    public void beanti() {
        System.out.println("美");
    }
}

/**
 * 类的扩展,继承原有类,保持原有功能,再继续扩展功能
 */
class WomenStarDriver extends WomenStar implements IDriver{

    public void drive() {
        System.out.println("开车");
    }
}

class RichMan {
    public void marring(IWRB iWRB){
        System.out.println("交往");
    };

    public void drive(IDriver driver ){
        System.out.println("开车");
    }
}

class Run{

    public static void main(String[] args) {
            RichMan richMan = new RichMan();
            richMan.marring(new WomenStar());
            WomenStarDriver womenStarDriver = new WomenStarDriver();
            richMan.drive(womenStarDriver);
    }
}



