package JavaSenior.EnumDemo;

public class TestSeason {

        public static void main(String[] args) {
            for (SeasonEnum objectName : SeasonEnum.values()) {
                System.out.println(objectName);
            }

            for (SeasonEnum objectName : SeasonEnum.values()) {
                System.out.println(objectName.getSeasonDesc());
            }
        }

}
