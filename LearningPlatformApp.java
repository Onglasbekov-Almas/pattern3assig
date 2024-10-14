interface VideoLecture {
    void getInfo();
    void play();
}

class RealVideoLecture implements VideoLecture {
    private String fileName;

    public RealVideoLecture(String fileName) {
        this.fileName = fileName;
        loadFromDisk();
    }

    private void loadFromDisk() {
        System.out.println("Loading video " + fileName);
    }

    @Override
    public void getInfo() {
        System.out.println("Video: " + fileName);
    }

    @Override
    public void play() {
        System.out.println("Playing video " + fileName);
    }
}

// ProxyVideoLecture class
class ProxyVideoLecture implements VideoLecture {
    private String fileName;
    private RealVideoLecture realVideoLecture;

    public ProxyVideoLecture(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public void getInfo() {
        System.out.println("Video: " + fileName);
    }

    @Override
    public void play() {
        if (realVideoLecture == null) {
            realVideoLecture = new RealVideoLecture(fileName);
        }
        realVideoLecture.play();
    }
}

// OnlineCourse class
class OnlineCourse {
    private VideoLecture[] lectures;

    public OnlineCourse() {
        lectures = new VideoLecture[]{
                new ProxyVideoLecture("Lecture 1.mp4"),
                new ProxyVideoLecture("Lecture 2.mp4")
        };
    }

    public void showLectures() {
        for (VideoLecture lecture : lectures) {
            lecture.getInfo();
        }
    }

    public void playLecture(int index) {
        lectures[index].play();
    }
}

// LearningPlatformApp class
class LearningPlatformApp {
    public static void main(String[] args) {
        OnlineCourse course = new OnlineCourse();
        course.showLectures();
        course.playLecture(0); // Lecture 1 should load and play
    }
}
