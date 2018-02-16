/**
 * An Exception class for when an attempt is
 * made to draw a box with invalid width or height
 */
public class InvalidBoxSizeException extends Exception {
    private String message;

    /**
     * A constructor that creates a message that
     * explains why the Exception has been thrown
     * @param width The given width of a box
     * @param height The given height of a box
     */
    public InvalidBoxSizeException(int width, int height) {

        if(width < 2 && height < 2){
            this.message = "Width and height must be greater than 1, given width: " + width + " given height: " + height;
        }else if(width < 2){
            this.message = "Width must be greater than 1, Given width: " + width;
        }else if(height < 2){
            this.message = "Height must be greater than 1, Given height: " + height;
        }else{
            this.message = "";
        }
    }

    /**
     * @return A message explaining why the Exception has been thrown
     */
    @Override
    public String getMessage() {
        return message;
    }
}
