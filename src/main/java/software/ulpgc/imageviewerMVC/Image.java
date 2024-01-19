package software.ulpgc.imageviewerMVC;

public interface Image {
    String name();
    Image next();
    Image prev();
}
