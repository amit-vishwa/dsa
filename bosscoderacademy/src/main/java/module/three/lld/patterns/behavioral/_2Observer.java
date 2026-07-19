package module.three.lld.patterns.behavioral;

import java.util.ArrayList;
import java.util.List;

/**
 * Observer Pattern:
 * - Channel is the Subject interface.
 * - YouTubeChannel is the Concrete Subject.
 * - Subscriber is the Observer interface.
 * - MobileUser and EmailUser are Concrete Observers.
 * <p>
 * When a new video is uploaded, all registered subscribers
 * are notified automatically.
 */
public class _2Observer {

    public static void main(String[] args) {
        Subscriber amit = new MobileUser("Amit");
        Subscriber raja = new EmailUser("Raja");

        Channel channel = new YouTubeChannel();

        channel.subscribe(amit);
        channel.subscribe(raja);

        channel.uploadVideo("Sci-Fi Movie Review");

        channel.unsubscribe(amit);

        channel.uploadVideo("Comedy Movie Review");
    }

}

interface Subscriber {
    void update(String videoTitle);
}

interface Channel {
    void subscribe(Subscriber subscriber);

    void unsubscribe(Subscriber subscriber);

    void uploadVideo(String videoTitle);
}

class MobileUser implements Subscriber {

    private final String name;

    public MobileUser(String name) {
        this.name = name;
    }

    @Override
    public void update(String videoTitle) {
        System.out.println(
                "[Mobile Notification] " +
                        name +
                        " received update: " +
                        videoTitle
        );
    }
}

class EmailUser implements Subscriber {

    private final String name;

    public EmailUser(String name) {
        this.name = name;
    }

    @Override
    public void update(String videoTitle) {
        System.out.println(
                "[Email Notification] " +
                        name +
                        " received update: " +
                        videoTitle
        );
    }
}

class YouTubeChannel implements Channel {
    private final List<Subscriber> subscriberList = new ArrayList<>();

    @Override
    public void subscribe(Subscriber subscriber) {
        this.subscriberList.add(subscriber);
    }

    @Override
    public void unsubscribe(Subscriber subscriber) {
        this.subscriberList.remove(subscriber);
    }

    @Override
    public void uploadVideo(String videoTitle) {
        System.out.println("Video uploaded: " + videoTitle);
        notifySubscribers(videoTitle);
    }

    private void notifySubscribers(String videoTitle) {
        for (Subscriber subscriber : this.subscriberList) {
            subscriber.update(videoTitle);
        }
        System.out.println();
    }
}