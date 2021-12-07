package model;

public class Server {
    
    private double memoryCache;
    private int numberOfProcessor;
    private Processor brandProcessor;
    private double memoryRam;
    private int amountOfDiscs;
    private double discCapacity;

    public Server(double memoryCache, int numberOfProcessor, int brandProcessor, double memoryRam, int amountOfDiscs, double discCapacity) {
        this.memoryCache = memoryCache;
        this.numberOfProcessor = numberOfProcessor;
        if (brandProcessor == 1){
            this.brandProcessor = Processor.INTEL;
        }else {
            this.brandProcessor = Processor.AMD;
        }
        this.memoryRam = memoryRam;
        this.amountOfDiscs = amountOfDiscs;
        this.discCapacity = discCapacity;
    }
	
	//Getter and setters
    public double getProccesCapacity(){
        return discCapacity+memoryRam;
    }


    public double getMemoryCache() {
        return this.memoryCache;
    }

    public void setMemoryCache(double memoryCache) {
        this.memoryCache = memoryCache;
    }

    public int getNumberOfProcessor() {
        return this.numberOfProcessor;
    }

    public void setNumberOfProcessor(int numberOfProcessor) {
        this.numberOfProcessor = numberOfProcessor;
    }

    public double getMemoryRam() {
        return this.memoryRam;
    }

    public void setMemoryRam(double memoryRam) {
        this.memoryRam = memoryRam;
    }

    public int getAmountOfDiscs() {
        return this.amountOfDiscs;
    }

    public void setAmountOfDiscs(int amountOfDiscs) {
        this.amountOfDiscs = amountOfDiscs;
    }

    public double getDiscCapacity() {
        return this.discCapacity;
    }

    public void setDiscCapacity(double discCapacity) {
        this.discCapacity = discCapacity;
    }

    public Processor getBrandProcessor() {
        return this.brandProcessor;
    }

    public void setBrandProcessor(Processor brandProcessor) {
        this.brandProcessor = brandProcessor;
    }
}