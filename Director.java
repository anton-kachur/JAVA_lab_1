private class Director
    {
        //********************Creates random map*****************************************************
        private void createDefaultMap(Builder builder)
        {
            builder.setRoads();
            builder.setReservoirs();
            builder.setBuildings();
            builder.setLocalities();
            builder.setTrees();
            builder.setRelief();
        }

        //********************Creates map, customized by user****************************************
        private void createUserMap(Builder builder)
        {
            System.out.println("Enter the number of roads: ");
            builder.setRoads(input.nextInt());
            System.out.println("Enter the number of reservoirs: ");
            builder.setReservoirs(input.nextInt());
            System.out.println("Enter the number of buildings: ");
            builder.setBuildings(input.nextInt());
            System.out.println("Enter the number of localities: ");
            builder.setLocalities(input.nextInt());
            System.out.println("Enter the number of trees: ");
            builder.setTrees(input.nextInt());
            System.out.println("Enter the number of relief: ");
            builder.setRelief(input.nextInt());
        }
    }
