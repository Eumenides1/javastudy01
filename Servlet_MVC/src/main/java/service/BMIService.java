package service;

/**
 * 模型：
 *      负责封装业务逻辑的处理
 * @author Eumenides
 */
public class BMIService {
    /**
     * 依据身高体重计算bmi指数，返回身体状况
     * @param height
     * @param weight
     * @return
     */
    public String bmi(double height,double weight){
        //计算bmi指数
        double bmi = weight/height/height;
        //依据BMI指数判断用户的身体状况
        String status = "正常";
        if(bmi < 19){
            status = "过轻";
        }
        if(bmi > 25){
            status = "过重";
        }
        return status;
    }
}
