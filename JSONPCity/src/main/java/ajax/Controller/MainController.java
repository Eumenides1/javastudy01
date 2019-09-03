package ajax.Controller;

import ajax.Bean.City;
import ajax.Bean.Province;
import ajax.Bean.ResponseResult;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@Controller
public class MainController {

    @RequestMapping("/index.do")
    public String showIndex(){
        return "index";
    }


    @RequestMapping("/get_provinces.do")
    @ResponseBody
    public ResponseResult<List<Province>> getProvinces() {
        List<Province> list = new ArrayList<Province>();
        list.add(new Province(1, "广东省"));
        list.add(new Province(2, "河北省"));
        list.add(new Province(3, "湖北省"));
        list.add(new Province(4, "山东省"));
        ResponseResult<List<Province>> rr = new ResponseResult<List<Province>>(1, list);
        return rr;
    }

    @RequestMapping("/get_cities.do")
    @ResponseBody
    public ResponseResult<List<City>> getCities(Integer provinceId){

        List<City> cities = new ArrayList<>();

        //String jsonString;
        switch (provinceId) {
            case 1:
                cities.add(new City(11,"广州市"));
                cities.add(new City(12,"深圳市"));
                cities.add(new City(13,"珠海市"));
                break;

            case 2:
                cities.add(new City(21,"石家庄市"));
                cities.add(new City(22,"保定市"));
                cities.add(new City(23,"秦皇岛市"));
                break;

            case 3:
                cities.add(new City(31,"武汉市"));
                cities.add(new City(32,"黄石市"));
                cities.add(new City(33,"荆州市"));
                break;

            case 4:
                cities.add(new City(41,"青岛市"));
                cities.add(new City(42,"烟台市"));
                cities.add(new City(43,"威海市"));
                break;

            default:
                //jsonString = null;
                break;
        }

        ResponseResult <List<City>> rr = new ResponseResult<>(1,cities);
        return rr;
    }

    @RequestMapping("/get_city.do")
    @ResponseBody
    @Deprecated
    public ResponseResult<City> getCity(){
        City city = new City(3,"威海");
        ResponseResult<City> rr = new ResponseResult<City>(1,null,city);
        return rr;
    }

}
