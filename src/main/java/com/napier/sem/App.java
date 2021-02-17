package com.napier.sem;


public class App {

    public static void main(String[] args)
    {

        // Create a new DatabaseLink class, containing connect and disconnect functionality, and database interactiond
        DatabaseLink db = new DatabaseLink();


        Population pop = new Population();
        pop.getCityPopulation(5);
        pop.getDistrictPopulation("Buenos Aires");
        pop.getCountryPopulation("DEU");
        pop.getRegionPopulation("Western Europe");
        pop.getContinentPopulation("Europe");
        pop.getWorldPopulation();
        pop.getCountryPopulationProportionInCities("DEU");
        pop.getRegionPopulationProportionInCities("Western Europe");
        pop.getContinentPopulationProportionInCities("Europe");


        // Disconnect from database
        db.disconnect();










    }




}
