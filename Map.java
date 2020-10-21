private static class Map
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
