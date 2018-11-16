/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FunctionLayer;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Michael & Christian
 */
public class CarportCalculatorTest {

    public CarportCalculatorTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Test
    public void CalcCarportLength() { // take length minus 30 so there is space for the roof
        CarportCalculator CC = new CarportCalculator(210, 310, 270);
        assertEquals(4, CC.calcPolesSides()); // 310-30=280 : 2 for each side

        CC = new CarportCalculator(210, 640, 270);
        assertEquals(8, CC.calcPolesSides()); // 640-30=610 : 4 for each side

        CC = new CarportCalculator(210, 330, 270);
        assertEquals(4, CC.calcPolesSides()); // 330-30=300 : 2 for each side

        CC = new CarportCalculator(210, 350, 270);
        assertEquals(6, CC.calcPolesSides()); // 350-30=320 : 3 for each side

        CC = new CarportCalculator(210, 10000, 270);
        assertEquals(70, CC.calcPolesSides()); // 10000-30=9970 : 35 for each side
    }

    @Test
    public void CalcCarportWidth() { // take width minus 30 so there is space for the roof
        CarportCalculator CC = new CarportCalculator(210, 310, 270);
        assertEquals(0, CC.calcPolesBack()); // 270-30=240 : 0

        CC = new CarportCalculator(210, 310, 310);
        assertEquals(0, CC.calcPolesBack()); // 310-30=280 : 0

        CC = new CarportCalculator(210, 310, 330);
        assertEquals(0, CC.calcPolesBack()); // 330-30=300 : 0

        CC = new CarportCalculator(210, 310, 720);
        assertEquals(2, CC.calcPolesBack()); // 720-30=690 : 2

        CC = new CarportCalculator(210, 310, 10000);
        assertEquals(33, CC.calcPolesBack()); // 10000-30=9970 : 33
    }

    @Test
    public void CalcCarportRoofWidth() throws FogException {
        CarportCalculator CC = new CarportCalculator(210, 310, 270);
        CC.calcRoofRafterWidth();
        assertEquals(2, CC.getProductList().size());
        CC.calcRoofRafterLength();
        assertEquals(6, CC.getProductList().size());

        CC = new CarportCalculator(210, 350, 250);
        CC.calcRoofRafterWidth();
        assertEquals(2, CC.getProductList().size());
        CC.calcRoofRafterLength();
        assertEquals(6, CC.getProductList().size());

        CC = new CarportCalculator(210, 420, 310);
        CC.calcRoofRafterWidth();
        assertEquals(4, CC.getProductList().size());
        CC.calcRoofRafterLength();
        assertEquals(6, CC.getProductList().size());

        CC = new CarportCalculator(210, 740, 640);
        CC.calcRoofRafterWidth();
        assertEquals(4, CC.getProductList().size());
        CC.calcRoofRafterLength();
        assertEquals(8, CC.getProductList().size());

        CC = new CarportCalculator(210, 10000, 10000);
        CC.calcRoofRafterWidth();
        assertEquals(30, CC.getProductList().size());
        CC.calcRoofRafterLength();
        assertEquals(60, CC.getProductList().size());
    }

    @Test
    public void CalcCarportRoofMiddleRafts() throws FogException {
        CarportCalculator CC = new CarportCalculator(210, 310, 270);
        CC.calcRoofRafterMiddle();
        assertEquals(4, CC.getProductList().size());

        CC = new CarportCalculator(210, 330, 270);
        CC.calcRoofRafterMiddle();
        assertEquals(5, CC.getProductList().size());

        CC = new CarportCalculator(210, 350, 270);
        CC.calcRoofRafterMiddle();
        assertEquals(5, CC.getProductList().size());

        CC = new CarportCalculator(210, 640, 270);
        CC.calcRoofRafterMiddle();
        assertEquals(9, CC.getProductList().size());

        CC = new CarportCalculator(210, 10000, 270);
        CC.calcRoofRafterMiddle();
        assertEquals(134, CC.getProductList().size());
    }

    @Test
    public void CalcCarportWaterBoard() throws FogException {
        CarportCalculator CC = new CarportCalculator(210, 310, 270);
        CC.calcRoofWaterBoardWidth();
        assertEquals(4, CC.getProductList().size());
        CC.calcRoofWaterBoardLength();
        assertEquals(8, CC.getProductList().size());

        CC = new CarportCalculator(210, 360, 310);
        CC.calcRoofWaterBoardWidth();
        assertEquals(4, CC.getProductList().size());
        CC.calcRoofWaterBoardLength();
        assertEquals(8, CC.getProductList().size());

        CC = new CarportCalculator(210, 420, 360);
        CC.calcRoofWaterBoardWidth();
        assertEquals(4, CC.getProductList().size());
        CC.calcRoofWaterBoardLength();
        assertEquals(8, CC.getProductList().size());

        CC = new CarportCalculator(210, 640, 420);
        CC.calcRoofWaterBoardWidth();
        assertEquals(4, CC.getProductList().size());
        CC.calcRoofWaterBoardLength();
        assertEquals(10, CC.getProductList().size());

        CC = new CarportCalculator(210, 10000, 8000);
        CC.calcRoofWaterBoardWidth();
        assertEquals(40, CC.getProductList().size());
        CC.calcRoofWaterBoardLength();
        assertEquals(90, CC.getProductList().size());
    }

    @Test
    public void CalcCarportRoof() throws FogException, FogException {
        CarportCalculator CC = new CarportCalculator(210, 310, 270);
        CC.calcRoofLength(CC.calcRoofWidth());
        assertEquals(6, CC.getProductList().size());

        CC = new CarportCalculator(210, 360, 310);
        CC.calcRoofLength(CC.calcRoofWidth());
        assertEquals(4, CC.getProductList().size());

        CC = new CarportCalculator(210, 480, 360);
        CC.calcRoofLength(CC.calcRoofWidth());
        assertEquals(4, CC.getProductList().size());

        CC = new CarportCalculator(210, 640, 480);
        CC.calcRoofLength(CC.calcRoofWidth());
        assertEquals(10, CC.getProductList().size());

        CC = new CarportCalculator(210, 10000, 8000);
        CC.calcRoofLength(CC.calcRoofWidth());
        assertEquals(1458, CC.getProductList().size());

    }

    @Test
    public void CompleteCarportTest() throws FogException {
        CarportCalculator CC = new CarportCalculator(210, 310, 270);
        CC.calcCarport();
        assertEquals(28, CC.getProductList().size());

        CC = new CarportCalculator(210, 360, 310);
        CC.calcCarport();
        assertEquals(29, CC.getProductList().size());

        CC = new CarportCalculator(210, 420, 360);
        CC.calcCarport();
        assertEquals(29, CC.getProductList().size());

        CC = new CarportCalculator(210, 640, 420);
        CC.calcCarport();
        assertEquals(44, CC.getProductList().size());

        CC = new CarportCalculator(210, 10000, 8000);
        CC.calcCarport();
        assertEquals(1832, CC.getProductList().size());
    }
}
