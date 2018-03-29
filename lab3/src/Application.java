public class Application {

    public static final int BOX_ARRAY_SIZE = 5;

    public static void main(String[] args){
        try {

            // Create generic objects using reflection
            Box stringBox = Box.class.newInstance();
            Box intBox = Box.class.newInstance();
            Box doubleBox = Box.class.newInstance();
            Box charBox = Box.class.newInstance();
            Box booleanBox = Box.class.newInstance();

            stringBox.setFirstGenericObject("Hello World!");
            stringBox.setSecondGenericObject("Hello Szymon!");

            intBox.setFirstGenericObject(123);
            intBox.setSecondGenericObject(456);

            doubleBox.setFirstGenericObject(1d);
            doubleBox.setSecondGenericObject(10d);

            charBox.setFirstGenericObject('a');
            charBox.setSecondGenericObject('b');

            booleanBox.setFirstGenericObject(true);
            booleanBox.setSecondGenericObject(false);


            // Create generic array
            Box[] boxArray = new Box[BOX_ARRAY_SIZE];

            boxArray[0] = stringBox;
            boxArray[1] = intBox;
            boxArray[2] = doubleBox;
            boxArray[3] = charBox;
            boxArray[4] = booleanBox;

            // Check if array of generics works fine
            for(int i = 0; i < BOX_ARRAY_SIZE; i++){
                System.out.printf("%-30s %-30s %-30s %-20s %n",
                        "Generic object type in box:",
                        boxArray[i].getFirstGenericObject().getClass().toString(),
                        "Generic object value in box:",
                        boxArray[i].toString());
            }

            // Test cloning object

            System.out.println("=========================");
            System.out.println("======== CLONING ========");
            System.out.println("=========================");

            Box clonedStringBox = (Box) stringBox.clone();
            Box clonedIntBox = (Box) intBox.clone();
            Box clonedDoubleBox = (Box) doubleBox.clone();
            Box clonedCharBox = (Box) charBox.clone();
            Box clonedBooleanBox = (Box) booleanBox.clone();

            System.out.printf("%s %-80s %-10s %-40s %n", "Cloned ", stringBox.toString(), "into ", clonedStringBox.toString());
            System.out.printf("%s %-80s %-10s %-40s %n", "Cloned ", intBox.toString(), "into ", clonedIntBox.toString());
            System.out.printf("%s %-80s %-10s %-40s %n", "Cloned ", doubleBox.toString(), "into ", clonedDoubleBox.toString());
            System.out.printf("%s %-80s %-10s %-40s %n", "Cloned ", charBox.toString(), "into ", clonedCharBox.toString());
            System.out.printf("%s %-80s %-10s %-40s %n", "Cloned ", booleanBox.toString(), "into ", clonedBooleanBox.toString());

        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }

}