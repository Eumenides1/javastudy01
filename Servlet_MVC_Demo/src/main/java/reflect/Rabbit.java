package reflect;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Eumenides
 */
public class Rabbit {

    //创建一个兔子类

        private int age ;//有一个属性age,用来记录年龄(按月计算)

        private static List<Rabbit> list = new ArrayList<Rabbit>(Arrays.asList(new Rabbit(1)));//定义一个"兔子窝",兔子窝中本来就有一对兔子

        public Rabbit(int age){//构造方法
            this.age = age;
        }

        public static Rabbit birth(){//兔子有生小兔子的行为
            return new Rabbit(1);
        }


        public static int getSize(List<Rabbit> list){//获得兔子窝中的兔子总量
            return list.size();
        }


        public static int countRabbits(int month){//计算给定月份兔子窝中应有多少兔子

            if( month == 1 || month == 2) {

                return 1;

            }else{
                list.get(0).age = 3;
            }


            Rabbit curr_Rabbit = null;

            for(int i = 3 ; i <= month ; i++){//从三月份开始

                for(int j = 0; j < list.size(); j++){

                    curr_Rabbit = list.get(j);

                    if(curr_Rabbit.age >= 3){//如果年龄大于等于三个月,可以生兔子

                        list.add(birth());
                    }

                    curr_Rabbit.age++;//不然年龄加1
                }
            }
            return getSize(list);
        }


        public static void main(String[] args) {
            System.out.println(Rabbit.countRabbits(20));
        }
    }

