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
        assertEquals(4, CC.CalcPolesSides()); // 310-30=280 : 2 for each side

        CC = new CarportCalculator(210, 640, 270);
        assertEquals(8, CC.CalcPolesSides()); // 640-30=610 : 4 for each side

        CC = new CarportCalculator(210, 330, 270);
        assertEquals(4, CC.CalcPolesSides()); // 330-30=300 : 2 for each side

        CC = new CarportCalculator(210, 350, 270);
        assertEquals(6, CC.CalcPolesSides()); // 350-30=320 : 3 for each side

        CC = new CarportCalculator(210, 10000, 270);
        assertEquals(70, CC.CalcPolesSides()); // 10000-30=9970 : 35 for each side
    }

    @Test
    public void CalcCarportWidth() { // take width minus 30 so there is space for the roof
        CarportCalculator CC = new CarportCalculator(210, 310, 270);
        assertEquals(0, CC.CalcPolesBack()); // 270-30=240 : 0

        CC = new CarportCalculator(210, 310, 310);
        assertEquals(0, CC.CalcPolesBack()); // 310-30=280 : 0

        CC = new CarportCalculator(210, 310, 330);
        assertEquals(0, CC.CalcPolesBack()); // 330-30=300 : 0

        CC = new CarportCalculator(210, 310, 720);
        assertEquals(2, CC.CalcPolesBack()); // 720-30=690 : 2

        CC = new CarportCalculator(210, 310, 10000);
        assertEquals(33, CC.CalcPolesBack()); // 10000-30=9970 : 33
    }

    @Test
    public void CalcCarportRoofWidth() {
        CarportCalculator CC = new CarportCalculator(210, 310, 270);
        CC.CalcRoofRafterWidth();
        assertEquals(2, CC.getProductList().size());
        CC.CalcRoofRafterLength();
        assertEquals(6, CC.getProductList().size());

        CC = new CarportCalculator(210, 350, 250);
        CC.CalcRoofRafterWidth();
        assertEquals(2, CC.getProductList().size());
        CC.CalcRoofRafterLength();
        assertEquals(6, CC.getProductList().size());

        CC = new CarportCalculator(210, 420, 310);
        CC.CalcRoofRafterWidth();
        assertEquals(4, CC.getProductList().size());
        CC.CalcRoofRafterLength();
        assertEquals(6, CC.getProductList().size());

        CC = new CarportCalculator(210, 740, 640);
        CC.CalcRoofRafterWidth();
        assertEquals(4, CC.getProductList().size());
        CC.CalcRoofRafterLength();
        assertEquals(8, CC.getProductList().size());

        CC = new CarportCalculator(210, 10000, 10000);
        CC.CalcRoofRafterWidth();
        assertEquals(30, CC.getProductList().size());
        CC.CalcRoofRafterLength();
        assertEquals(60, CC.getProductList().size());
    }

    @Test
    public void CalcCarportRoofMiddleRafts() {
        CarportCalculator CC = new CarportCalculator(210, 310, 270);
        CC.CalcRoofRafterMiddle();
        assertEquals(4, CC.getProductList().size());

        CC = new CarportCalculator(210, 330, 270);
        CC.CalcRoofRafterMiddle();
        assertEquals(5, CC.getProductList().size());

        CC = new CarportCalculator(210, 350, 270);
        CC.CalcRoofRafterMiddle();
        assertEquals(5, CC.getProductList().size());

        CC = new CarportCalculator(210, 640, 270);
        CC.CalcRoofRafterMiddle();
        assertEquals(9, CC.getProductList().size());

        CC = new CarportCalculator(210, 10000, 270);
        CC.CalcRoofRafterMiddle();
        assertEquals(134, CC.getProductList().size());
    }
    
    @Test
    public void CalcCarportWaterBoard() {
        CarportCalculator CC = new CarportCalculator(210, 310, 270);
        CC.CalcRoofWaterBoardWidth();
        assertEquals(4, CC.getProductList().size());
        CC.CalcRoofWaterBoardLength();
        assertEquals(8, CC.getProductList().size());
        
        CC = new CarportCalculator(210, 360, 310);
        CC.CalcRoofWaterBoardWidth();
        assertEquals(4, CC.getProductList().size());
        CC.CalcRoofWaterBoardLength();
        assertEquals(8, CC.getProductList().size());
        
        CC = new CarportCalculator(210, 420, 360);
        CC.CalcRoofWaterBoardWidth();
        assertEquals(4, CC.getProductList().size());
        CC.CalcRoofWaterBoardLength();
        assertEquals(8, CC.getProductList().size());
        
        CC = new CarportCalculator(210, 640, 420);
        CC.CalcRoofWaterBoardWidth();
        assertEquals(4, CC.getProductList().size());
        CC.CalcRoofWaterBoardLength();
        assertEquals(10, CC.getProductList().size());
        
        CC = new CarportCalculator(210, 10000, 8000);
        CC.CalcRoofWaterBoardWidth();
        assertEquals(40, CC.getProductList().size());
        CC.CalcRoofWaterBoardLength();
        assertEquals(90, CC.getProductList().size());
    }

    @Test
    public void CalcCarportRoof() {
        CarportCalculator CC = new CarportCalculator(210, 310, 270);
        CC.CalcRoofLength(CC.CalcRoofWidth());
        assertEquals(6, CC.getProductList().size());

        CC = new CarportCalculator(210, 360, 310);
        CC.CalcRoofLength(CC.CalcRoofWidth());
        assertEquals(4, CC.getProductList().size());

        CC = new CarportCalculator(210, 480, 360);
        CC.CalcRoofLength(CC.CalcRoofWidth());
        assertEquals(4, CC.getProductList().size());

        CC = new CarportCalculator(210, 640, 480);
        CC.CalcRoofLength(CC.CalcRoofWidth());
        assertEquals(10, CC.getProductList().size());

        CC = new CarportCalculator(210, 10000, 8000);
        CC.CalcRoofLength(CC.CalcRoofWidth());
        assertEquals(1458, CC.getProductList().size());

    }

    @Test
    public void CompleteCarportTest() {
        CarportCalculator CC = new CarportCalculator(210, 310, 270);
        CC.CalcCarport();
        assertEquals(28, CC.getProductList().size());
        
        CC = new CarportCalculator(210, 360, 310);
        CC.CalcCarport();
        assertEquals(29, CC.getProductList().size());
        
        CC = new CarportCalculator(210, 420, 360);
        CC.CalcCarport();
        assertEquals(29, CC.getProductList().size());
        
        CC = new CarportCalculator(210, 640, 420);
        CC.CalcCarport();
        assertEquals(44, CC.getProductList().size());
        
        CC = new CarportCalculator(210, 10000, 8000);
        CC.CalcCarport();
        assertEquals(1832, CC.getProductList().size());
    }
}
