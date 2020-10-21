private class Application
    {
        private void makeMap(Choice choice)
        {
            Director director = new Director();
            MapBuilder builder = new MapBuilder();

            switch(choice) {
                case RANDOM: director.createDefaultMap(builder); break;
                case CUSTOM: director.createUserMap(builder); break;
            }

            Map map = builder.resultMap();
            map.printMap();
            map.listOfLocalities();
        }

    }
