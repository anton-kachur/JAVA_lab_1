public class MapBuilder extends Builder
    {
        private Map map = new Map();
        Random random = new Random();

        public void setRoads() {
            map.setNewRoad(random.nextInt(10));
        }
        public void setReservoirs() {
            map.setNewReservoir(random.nextInt(10));
        }
        public void setBuildings() {
            map.setNewBuilding(random.nextInt(10));
        }
        public void setLocalities() {
            map.setNewLocality(random.nextInt(10));
        }
        public void setTrees() {
            map.setNewTree(random.nextInt(10));
        }
        public void setRelief() {
            map.setNewRelief(random.nextInt(10));
        }

        public void setRoads(int n) {
            map.setNewRoad(n);
        }
        public void setReservoirs(int n) {
            map.setNewReservoir(random.nextInt(n));
        }
        public void setBuildings(int n) { map.setNewBuilding(random.nextInt(n)); }
        public void setLocalities(int number_of_localities) { map.setNewLocality(number_of_localities); }
        public void setTrees(int n) {
            map.setNewTree(random.nextInt(n));
        }
        public void setRelief(int n) {
            map.setNewRelief(random.nextInt(n));
        }

        private Map resultMap() { return map; }
    }
