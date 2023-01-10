package functions_biFunctions;

@FunctionalInterface //is created to be a target type for lambda functions and Method references !
public interface DistanceCalculator {

    double calculateDistance(City city1, City City2);

    // in FunctionalInterface it is forbidden to have two abstract methods
//	double calculateDeliveryTime();

    default void someDefaultMethod() {};

    static void someStaticMethod() {};

}
