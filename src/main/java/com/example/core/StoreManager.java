package com.example.core;

public class StoreManager {
    private static StoreManager instance;

    private Double totalDailyRevenue;
    private Integer totalOrdersCompleted;
    private Integer totalOrdersVoided;

    private StoreManager(){
        this.totalDailyRevenue = 0.0;
        this.totalOrdersCompleted = 0;
        this.totalOrdersVoided = 0;
    }

    public static StoreManager getInstance(){
        if(instance == null){
            instance = new StoreManager();
        }
        return instance;
    }

    public void recodSale(Double amount) {
        totalDailyRevenue += amount;
        totalOrdersCompleted++;
    }

    public void recordVoidedOrder(Integer orderId){
        totalOrdersVoided++;
        System.out.println("[MANAGER LOG] Alert: Order #" + orderId + " was voided.");
    }

    public void printDailyReport() {
        System.out.println("\n==================================");
        System.out.println("      END OF DAY REPORT");
        System.out.println("==================================");
        System.out.println("Total Orders Completed : " + totalOrdersCompleted);
        System.out.println("Total Orders Voided    : " + totalOrdersVoided);
        System.out.println("Total Daily Revenue    : " + String.format("%.2f", totalDailyRevenue) + " dh");
        System.out.println("==================================");
    }
}
