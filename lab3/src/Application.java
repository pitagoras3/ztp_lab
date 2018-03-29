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

            stringBox.setGenericObject("Hello World!");
            intBox.setGenericObject(123);
            doubleBox.setGenericObject(1d);
            charBox.setGenericObject('a');
            booleanBox.setGenericObject(true);


            // Create generic array
            Box[] boxArray = new Box[BOX_ARRAY_SIZE];

            boxArray[0] = stringBox;
            boxArray[1] = intBox;
            boxArray[2] = doubleBox;
            boxArray[3] = charBox;
            boxArray[4] = booleanBox;

            // Check if everything is ok
            for(int i = 0; i < BOX_ARRAY_SIZE; i++){
                System.out.printf("%s %-30s %s %-20s %n",
                        "Generic object type in box:",
                        boxArray[i].getGenericObject().getClass().toString(),
                        "Generic object value in box:",
                        boxArray[i].getGenericObject());
            }

        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }

}