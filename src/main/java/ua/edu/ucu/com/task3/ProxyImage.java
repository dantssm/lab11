package ua.edu.ucu.com.task3;

public class ProxyImage implements MyImage {
    private RealImage image;
    private String filename;
    private boolean imageAccessed;

    public ProxyImage(String filename) {
        this.filename = filename;
        this.imageAccessed = false;
        log("ProxyImage for file: " + filename);
    }

    @Override
    public void display() {
        if (image == null) {
            log("The real image is preparing...");
            image = new RealImage(filename);
        } else if (!imageAccessed) {
            log("The image is already prepared :)");
        }
        imageAccessed = true;
        log("Displaying the image...");
        image.display();
    }

    private void log(String message) {
        System.out.println("[ProxyImage Log]: " + message);
    }
}
