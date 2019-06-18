package com.company.javaDemo; /**
 * @author Jeremy
 * @create 2019/6/10-17:43
 */
import java.util.Scanner;

/**
 * @author Jeremy
 * @create 2019/6/10-16:39
 */
public  class Main{
    public  static  void main(String[] args){
        Scanner in = new Scanner(System.in);
        Fraction a = new Fraction(in.nextInt(),in.nextInt());
        Fraction b = new Fraction(in.nextInt(),in.nextInt());
        a.print();
        b.print();
        a.plus(b).print();
        a.multiply(b).plus(new Fraction(5,6)).print();
        a.print();
        b.print();
        in.close();
    }


    static class Fraction {
        int a;//表示分子
        int b;//表示分母

        Fraction(int a, int b){
            this.a = a;
            this.b = b;
        }

        int gcd = gcd(a,b);

        double toDouble(){
            return   this.a/this.b;
        }
        Fraction plus(Fraction r){
            return new Fraction( (this.a*r.b + r.a*this.b) , (this.b*r.b));
        }
        Fraction multiply(Fraction r){
            return new Fraction( (this.a*r.a) , (this.b*r.b));
        }

        void print(){
            if(a!=b){
                System.out.println(a/gcd(a,b)+"/"+b/gcd(a,b));//这里通过分子分母同时除以最大公约数实现分数的简化
            }else{
                System.out.println(1);
            }
        }

        int gcd(int x, int y){ // 这个是运用 辗转相除法（递归的原理）  求两个数的 最大公约数
            if(y == 0)
                return x;
            else
                return gcd(y,x%y);
        }


    }
}