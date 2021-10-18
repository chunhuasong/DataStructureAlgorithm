package JavaSenior.EnumDemo;


    interface info{
        void show();
    }


    enum SeasonEnum implements info{


        SPRING("春天","春风又绿江南岸"){
            public void show(){System.out.println("春天在哪里？"); }
        },
        SUMMER("夏天","映日荷花别样红") {
            @Override
            public void show() {

            }
        },
        AUTUMN("秋天","秋水共长天一色") {
            @Override
            public void show() {

            }
        },
        WINTER("冬天","窗含西岭千秋雪") {
            @Override
            public void show() {

            }
        };

        private final String seasonName;
        private final String seasonDesc;

        SeasonEnum(String seasonName, String seasonDesc) {
            this.seasonName = seasonName;
            this.seasonDesc = seasonDesc;
        }

        public String getSeasonName() {
            return seasonName;
        }

        public String getSeasonDesc() {
            return seasonDesc;
        }

        public static void main(String[] args) {

            SeasonEnum season= SeasonEnum.AUTUMN;
            System.out.println(season.getSeasonDesc());

        }


    }




