private class Map
    {
        //*************************************************************************************************
        //**********************Nested class, because each map has its own relief**************************
        //*************************************************************************************************
        private static class Relief
        {
            private String name;
            private int height;

            //*********Sets name of relief based on its height above the sea level***************************
            private Relief(int h) {
                height = h;
                if (height > 0 && height < 200) name = relief_types[0];
                else if (height > 200 && height < 500) name = relief_types[1];
                else if (height > 500 && height < 2000) name = relief_types[2];
                else if (height > 2000) name = relief_types[3];
                else name = relief_types[4];
            }

            private void printAll() {
                System.out.println("Name of relief: " + name + "\nMeasure of relief: " + height);
            }

        }
        //***********************ArrayLists which contain map components**************************************
        private ArrayList<Road> roads = new ArrayList<>();
        private ArrayList<Reservoir> reservoirs = new ArrayList<>();
        private ArrayList<Building> buildings = new ArrayList<>();
        private ArrayList<Locality> localities = new ArrayList<>();
        private ArrayList<Trees> trees = new ArrayList<>();
        private ArrayList<Relief> reliefs = new ArrayList<>();

        //*************Function, that represents the list of localities on alphabetical order*****************
        private void listOfLocalities() {
            if (localities.size() < 1) {
                System.out.println("\nThere is no localities\n");
            } else {
                Collections.sort(localities, Comparator.comparing(Locality::getName));
                System.out.println("All localities in alphabetic order: ");

                for (int i=0; i<localities.size(); i++)
                    System.out.println(localities.get(i).locality_name);
            }
        }


        //**************Methods for setting map components and representing them*****************************
        private void printMap() {
            for (Road i: roads) i.printAll();
            for (Reservoir i: reservoirs) i.printAll();
            for (Building i: buildings) i.printAll();
            for (Locality i: localities) i.printAll();
            for (Trees i: trees) i.printAll();
            for (Relief i: reliefs) i.printAll();
        }

        private void setNewRoad(int amount) {
            for (int i=0; i<amount; i++) {
                Random random = new Random();
                roads.add(new Road(road_types[random.nextInt(road_types.length)], random.nextInt(7)));
            }
        }

        private void setNewReservoir(int amount) {
            for (int i=0; i<amount; i++) {
                Random random = new Random();
                reservoirs.add(new Reservoir(reservoir_types[random.nextInt(reservoir_types.length)], random.nextInt(1000)));
            }
        }

        private void setNewBuilding(int amount) {
            for (int i=0; i<amount; i++) {
                buildings.add(new Building("SomeBuilding", "SomeLocality"));
            }
        }

        private void setNewLocality(int amount) {
            for (int i=0; i<amount; i++) {
                Random random = new Random();
                localities.add(new Locality(generateName(), locality_types[random.nextInt(locality_types.length)]));
            }
        }

        private void setNewTree(int amount) {
            for (int i=0; i<amount; i++) {
                Random random = new Random();
                trees.add(new Trees("Something", trees_types[random.nextInt(trees_types.length)]));
            }
        }

        private void setNewRelief(int amount) {
            for (int i=0; i<amount; i++) {
                Random random = new Random();
                reliefs.add(new Relief(random.nextInt(5000)));
            }
        }

    }
