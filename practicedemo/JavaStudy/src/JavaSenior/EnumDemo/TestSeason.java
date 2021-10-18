package JavaSenior.EnumDemo;



public class TestSeason {

        public static void main(String[] args) {

            SeasonEnum season = SeasonEnum.valueOf("WINTER");
// valueOf(String str)：可以把一个字符串转为对应的枚举类对象。要求字符
//串必须是枚举类对象的“名字”。如不是，会有运行时异常：
//IllegalArgumentException。
            for (SeasonEnum objectName : SeasonEnum.values())
            //values()方法：返回枚举类型的对象数组。该方法可以很方便地遍历所有的枚举值。
            {
                System.out.println(objectName);
                //System.out.println(SeasonEnum.values());
            }

            for (SeasonEnum objectName : SeasonEnum.values()) {
                System.out.println(objectName.getSeasonDesc());
            }
            SeasonEnum.valueOf("SPRING").show();
        }

}
