/**
 * This class contains static methods to draw a box to the
 * command line
 */
public class BoxDrawer {
    /**
     * A main method showing off the drawBox method
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //testing valid dimensions
        drawBox(2,2);
        drawBox(6,4);
        drawBox(10,10);

        //testing with invalid dimensions
        drawBox(-2,2);
        drawBox(-2,-10);
        drawBox(1,1);
    }

    /**
     * A method that draws a rectangle of a given width
     * and height
     * @param width     The width of the rectangle
     * @param height    The height of the rectangle
     */
    public static void drawBox(int width, int height){
        try {
            //create array containing box
            char[][] box = boxArray(width, height);

            //print out array row by row
            for(int i = 0; i < height; i++){
                for(int j = 0; j < width; j++){
                    System.out.print(box[j][i] + "");
                }
                //begin a new line
                System.out.println("");
            }
        } catch (InvalidBoxSizeException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }

    /**
     * A method that creates a 2D char array where
     * the edges and corners are set to the appropriate
     * characters to draw a box when printed
     * @param width     The width of the rectangle
     * @param height    The height of the rectangle
     * @return The array modelling a box
     * @throws InvalidBoxSizeException If width or height are less than 2
     */
    public static char[][] boxArray(int width, int height) throws InvalidBoxSizeException {
        //check
        if (width < 2 || height < 2) {
            throw new InvalidBoxSizeException(width, height);
        }
        char[][] box = new char[width][height];

        //fill box with spaces and set edges
        for(int i = 0; i < height; i++){
            for(int j = 0; j < width; j++){
                if(j == 0 || j == width-1){//check for left and right edges
                    box[j][i] = '|';
                }else if(i == 0 || i == height-1){//check for top and bottom edges
                    box[j][i] = '-';
                }else{//This must be a central cell
                    box[j][i] = ' ';
                }
            }
        }

        //set corner values after the rest to
        //avoid checking for a corner every iteration
        box[0][0] = 761;
        box[width-1][0] = 762;
        box[0][height-1] = 763;
        box[width-1][height-1] = 764;

        return box;
    }
}
