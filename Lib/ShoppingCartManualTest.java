package lib;
import java.util.ArrayList;

public class ShoppingCartManualTest {
    public static void run() {
        System.out.println("--- Starting Shopping Cart Calculator Tests ---");
        System.out.println(); // for spacing

        int passedCount = 0;
        int failedCount = 0;

        // Test 1: ตะกร้าเป็น null
        try {
            double total1 = ShoppingCartCalculator.calculateTotalPrice(null);
            if (total1 == 0.0) {
                System.out.println("Tast Case 1 : PASSED: Null cart should return 0.0");
                passedCount++;
            } else {
                System.out.println("Tast Case 1 : FAILED: Null cart expected 0.0 but got " + total1);
                failedCount++;
            }
        } catch (Exception e) {
            System.out.println("Tast Case 1 : FAILED: Null cart caused an exception: " + e.getMessage());
            failedCount++;
        }

        // Test 2: ตะกร้าว่าง
        ArrayList<CartItem> emptyCart = new ArrayList<>();
        double total2 = ShoppingCartCalculator.calculateTotalPrice(emptyCart);
        if (total2 == 0.0) {
            System.out.println("Tast Case 2 : PASSED: Empty cart should return 0.0");
            passedCount++;
        } else {
            System.out.println("Tast Case 2 : FAILED: Empty cart expected 0.0 but got " + total2);
            failedCount++;
        }

        // Test 3: คำนวณปกติ ไม่มีส่วนลด
        ArrayList<CartItem> simpleCart = new ArrayList<>();
        simpleCart.add(new CartItem("NORMAL", "Bread", 25.0, 2)); // 50
        simpleCart.add(new CartItem("NORMAL", "Milk", 15.0, 1));      // 15
        double total3 = ShoppingCartCalculator.calculateTotalPrice(simpleCart);
        if (total3 == 65.0) {
            System.out.println("Tast Case 3 : PASSED: Simple cart total is correct (65.0)");
            passedCount++;
        } else {
            System.out.println("Tast Case 3 : FAILED: Simple cart total expected 65.0 but got " + total3);
            failedCount++;
        }

        // Test 4: ค่า price ติดลบ 
        ArrayList<CartItem> MinusPriceCart = new ArrayList<>();
        MinusPriceCart.add(new CartItem("NORMAL", "Candy", -5, 2)); // -10
        MinusPriceCart.add(new CartItem("NORMAL", "Milk", 15.0, 1)); // 15
        double total4 = ShoppingCartCalculator.calculateTotalPrice(MinusPriceCart);
        if (total4 == 0.0) {
            System.out.println("Tast Case 4 : PASSED: Minus Price Cart total should return 0.0");
            passedCount++;
        } else {
            System.out.println("Tast Case 4 : FAILED: Minus Price Carttotal expected 0.0 but got " + total4);
            failedCount++;
        }

        // Test 5: ค่า quantity ติดลบ 
        ArrayList<CartItem> MinusQuantityCart = new ArrayList<>();
        MinusQuantityCart.add(new CartItem("NORMAL", "TOY", 50, -2)); // -100
        MinusQuantityCart.add(new CartItem("NORMAL", "Milk", 40, 1)); // 40
        double total5 = ShoppingCartCalculator.calculateTotalPrice(MinusQuantityCart);
        if (total5 == 0.0) {
            System.out.println("Tast Case 5 : PASSED: Minus Quantity Cart should return 0.0");
            passedCount++;
        } else {
            System.out.println("Tast Case 5 : FAILED: Minus Quantity Cart total expected 0.0 but got " + total5);
            failedCount++;
        }

        // Test 6: ค่า price และ quantity ติดลบ 
        ArrayList<CartItem> MinusCart = new ArrayList<>();
        MinusCart.add(new CartItem("NORMAL", "Omo", -100, -2)); // 200
        MinusCart.add(new CartItem("NORMAL", "Oil", -50, -1)); // 50
        double total6 = ShoppingCartCalculator.calculateTotalPrice(MinusCart);
        if (total6 == 0.0) {
            System.out.println("Tast Case 6 : PASSED: Minus Cart should return 0.0");
            passedCount++;
        } else {
            System.out.println("Tast Case 6 : FAILED: Minus Cart total expected 0.0 but got " + total6);
            failedCount++;
        }

        // Test 7: คำนวณตามกฎส่วนลด BOGO(ซื้อ 1 แถม 1) กรณีซื้อสินค้าทั้งหมดตามโปรที่วางไว้
        ArrayList<CartItem> FreeCart = new ArrayList<>();
        FreeCart.add(new CartItem("BOGO", "Frozen food", 85.0, 3)); // 85*2 == 170 free 1
        FreeCart.add(new CartItem("BOGO", "Milk", 30.0, 2));      // 30 free 1
        double total7 = ShoppingCartCalculator.calculateTotalPrice(FreeCart);
        if (total7 == 200.0) {
            System.out.println("Tast Case 7 : PASSED: Free cart total is correct (200.0)");
            passedCount++;
        } else {
            System.out.println("Tast Case 7 : FAILED: Free cart total expected 200.0 but got " + total7);
            failedCount++;
        }

        otal9 == 154.8) {
            System.out.println("Tast Case 9 : PASSED: Discount cart total is correct (154.8)");
            passedCount++;
        } else {
            System.out.println("Tast Case 9 : FAILED: Discount cart total expected 154.8 but got " + total9);
            failedCount++;
        }
            
        // --- Test Summary ---
        System.out.println("\n--------------------");
        System.out.println("--- Test Summary ---");
        System.out.println("Passed: " + passedCount + ", Failed: " + failedCount);
        if (failedCount == 0) {
            System.out.println("Excellent! All tests passed!");
        } else {
            System.out.println("Some tests failed.");
        }
    }
}
