package com.learning.research.xmltojsoncomparator;

//@SpringBootApplication
public class XmlToJsonComparatorApplication {

//    @Autowired
//    private ComparatorService compareService;

//    public static void main(String[] args) {
//        SpringApplication.run(XmlToJsonComparatorApplication.class, args);
//    }

//    @Bean
//    public CommandLineRunner run() {
//        return args -> {
//            JsonNode jsonNode = new ObjectMapper().readTree(new File("sample-json.json"));
//            JsonNode xmlNode = new XmlMapper().readTree(new File("sample-xml.xml"));
//
//            if (compareService.compareJson(jsonNode, xmlNode)) {
//                System.out.println("JSON and XML are equal");
//            } else {
//                System.out.println("There are differences in JSON and XML");
//            }
//            System.exit(1);
//        };
//    }

    public static void main(String[] args) {
        int[] A = {-533,-666,-500,169,724,478,358,-38,-536,705,-855,281,-173,961,-509,-5,942,-173,436,-609,-396,902,-847,-708,-618,421,-284,718,895,447,726,-229,538,869,912,667,-701,35,894,-297,811,322,-667,673,-336,141,711,-747,-132,547,644,-338,-243,-963,-141,-277,741,529,-222,-684,35};
        int B = 48;
        int N = A.length;
        System.out.println(N);
        int totalSum = 0;
        int si = 0;
        int ei = N-1;

        while(B > 0) {
            if (A[si] > A[ei]) {
                totalSum += A[si];
                System.out.println("Removed from start: " + A[si] + ". End element: " + A[ei] + ". Total Sum: " + totalSum);
                si++;
            } else {
                totalSum += A[ei];
                System.out.println("Removed from end: " + A[ei] + ". Start element: " + A[si] + ". Total Sum: " + totalSum);
                ei--;
            }
            System.out.println();
            B--;
        }
    }

}
