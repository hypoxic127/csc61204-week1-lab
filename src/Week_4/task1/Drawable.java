package Week_4.task1;

public interface Drawable {
    void draw();
    default String getDisplayColour() { return "default"; }
}
