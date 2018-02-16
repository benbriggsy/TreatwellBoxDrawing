import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

/**
 * A class containing tests to make sure a box is created as
 * intended
 */
public class BoxDrawerTest {

    /**
     * A method to test the corners are the correct characters
     * @throws InvalidBoxSizeException If width or height are less than 2
     */
    @Test
    public void BoxCornersTest() throws InvalidBoxSizeException {
        char[] expected = {761, 762, 763, 764};
        char[] actual = new char[4];
        int height = 6, width = 4;

        char[][] box = BoxDrawer.boxArray(width,height);
        actual[0] = box[0][0];//top left
        actual[1] = box[width-1][0];//top right
        actual[2] = box[0][height-1];//bottom left
        actual[3] = box[width-1][height-1];//bottom right

        Assert.assertArrayEquals(expected, actual);
    }

    /**
     * A method to test the left edge contains the correct characters
     * @throws InvalidBoxSizeException If width or height are less than 2
     */
    @Test
    public void BoxLeftEdgeTest() throws InvalidBoxSizeException {
        int height = 6, width = 4;
        char[] expected = new char[height-2];
        char[] actual = new char[height-2];

        Arrays.fill(expected, '|');

        char[][] box = BoxDrawer.boxArray(width,height);
        for(int i = 1; i < height-1; i++){
            actual[i-1] = box[0][i];
        }

        Assert.assertArrayEquals(expected, actual);
    }

    /**
     * A method to test the right edge contains the correct characters
     * @throws InvalidBoxSizeException If width or height are less than 2
     */
    @Test
    public void BoxRightEdgeTest() throws InvalidBoxSizeException {
        int height = 6, width = 4;
        char[] expected = new char[height-2];
        char[] actual = new char[height-2];

        Arrays.fill(expected, '|');

        char[][] box = BoxDrawer.boxArray(width,height);
        for(int i = 1; i < height-1; i++){
            actual[i-1] = box[width-1][i];
        }

        Assert.assertArrayEquals(expected, actual);
    }

    /**
     * A method to test the bottom edge contains the correct characters
     * @throws InvalidBoxSizeException If width or height are less than 2
     */
    @Test
    public void BoxBottomEdgeTest() throws InvalidBoxSizeException {
        int height = 6, width = 4;
        char[] expected = new char[width-2];
        char[] actual = new char[width-2];

        Arrays.fill(expected, '-');

        char[][] box = BoxDrawer.boxArray(width,height);
        for(int i = 1; i < width-1; i++){
            actual[i-1] = box[i][height-1];
        }

        Assert.assertArrayEquals(expected, actual);
    }

    /**
     * A method to test the top edge contains the correct characters
     * @throws InvalidBoxSizeException If width or height are less than 2
     */
    @Test
    public void BoxTopEdgeTest() throws InvalidBoxSizeException {
        int height = 6, width = 4;
        char[] expected = new char[width-2];
        char[] actual = new char[width-2];

        Arrays.fill(expected, '-');

        char[][] box = BoxDrawer.boxArray(width,height);
        for(int i = 1; i < width-1; i++){
            actual[i-1] = box[i][0];
        }

        Assert.assertArrayEquals(expected, actual);
    }

    /**
     * A method to test the middle cells contain the correct characters
     * @throws InvalidBoxSizeException If width or height are less than 2
     */
    @Test
    public void BoxMiddleTest() throws InvalidBoxSizeException {
        int height = 6, width = 4;
        char[] expected = new char[(width-2) * (height-2)];
        char[] actual = new char[(width-2) * (height-2)];

        Arrays.fill(expected, ' ');

        char[][] box = BoxDrawer.boxArray(width,height);
        int count = 0;
        for(int i = 1; i < width-1; i++){
            for(int j = 1; j < height-1; j++){
                actual[count] = box[i][j];
                count++;
            }
        }

        Assert.assertArrayEquals(expected, actual);
    }

}
