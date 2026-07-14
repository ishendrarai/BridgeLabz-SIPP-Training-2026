public class RestaurantManagement {
    static class Person {
        String name;
        int id;

        public Person(String name, int id) {
            this.name = name;
            this.id = id;
        }
    }

    interface Worker {
        void performDuties();
    }

    static class Chef extends Person implements Worker {
        public Chef(String name, int id) {
            super(name, id);
        }

        @Override
        public void performDuties() {
            System.out.println("Chef " + name + " (ID: " + id + ") is cooking food.");
        }
    }

    static class Waiter extends Person implements Worker {
        public Waiter(String name, int id) {
            super(name, id);
        }

        @Override
        public void performDuties() {
            System.out.println("Waiter " + name + " (ID: " + id + ") is serving customers.");
        }
    }

    public static void main(String[] args) {
        Chef chef = new Chef("Gordon", 1);
        Waiter waiter = new Waiter("James", 2);

        chef.performDuties();
        waiter.performDuties();
    }
}
