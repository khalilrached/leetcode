import com.polytech.util.DownloadBar;

public class TestDownloadBar {
    public static void main(String[] args) {
        DownloadBar bar = new DownloadBar("downloading");
        for (int i = 0;i<=130;i++){
            System.out.println(bar);
            bar.slide();
        }
    }
}
